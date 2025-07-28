import creature.*;
import creature.Character;
import creature.character.*;
import creature.monster.*;

import java.util.ArrayList;
import java.io.*;

import static java.lang.Math.random;
import static java.lang.Math.sqrt;

//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。
public class GameMaster {
    private static Object c1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> party = new ArrayList<Character>();
        ArrayList<Monster> monster = new ArrayList<Monster>();
        Hero h = new Hero("勇者",100);
        party.add(h);
        party.add(new Wizard("魔法使い",60,20));
        Thief t = new Thief("盗賊",70);
        party.add(t);
        for(int i=0;i<5;i++){
            int cnt = (int) (random()*3);
            switch(cnt){
                case 0:
                    monster.add(new Matango((char)('A'+i),45));
                    break;
                case 1:
                    monster.add(new Goblin((char)('A'+i),50));
                    break;
                case 2:
                    monster.add(new Slime((char)('A'+i),40));
            }
        }
        boolean superheroflg = false;
        System.out.println("---味方パーティ---");
        for(Character c : party){
            c.showStatus();
        }
        System.out.println("---敵グループ---");
        for(Monster c2 : monster){
            c2.showStatus();
        }
        do {
            for (Character c : party) {
                if (c instanceof Hero && (!(superheroflg))) {
                    System.out.println(c.getName() + "のターン\n1. 攻撃\n2. SuperHeroになる");
                } else if (c instanceof Wizard) {
                    System.out.println(c.getName() + "のターン\n1. 攻撃\n2. 魔法攻撃");
                } else if (c instanceof Thief) {
                    System.out.println(c.getName() + "のターン\n1. 攻撃\n2. 守り");
                    ((Thief) c).guard();
                } else if (c instanceof SuperHero && superheroflg) {
                    System.out.println(c.getName() + "のターン\n1. 攻撃");
                }
                int choice;
                do {
                    try {
                        System.out.println("行動を入力してください");
                        choice = Integer.parseInt(br.readLine());
                        if(!(choice ==1||choice ==2)){
                            System.out.println("選びなおしてください");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("数字を入力してください");
                    }
                } while (true);
                for (Monster c2 : monster) {
                    if (!(c2.isAlive())) {
                        c2.die();
                        monster.remove(c2);
                    } else if (c2.getHp() <= 5) {
                        c2.run();
                        monster.remove(c2);
                    }
                }
                if (choice == 1) {
                    do {
                        try {
                            int cnt = 1;
                            for (Monster c2 : monster) {
                                System.out.println(cnt + ":" + c2.getName());
                                cnt++;
                            }
                            System.out.println("攻撃対象を選んでください");
                            int target = Integer.parseInt(br.readLine())-1;
                            c.attack(monster.get(target));
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("数字を入力してください");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("選びなおしてください");
                        }
                    } while (true);
                } else if (c instanceof Hero) {
                    superheroflg = true;
                    SuperHero sh = new SuperHero(new Hero("勇者", c.getHp()));
                    party.remove(c);
                    party.add(sh);
                } else if (c instanceof Wizard) {
                    System.out.println("攻撃対象を選んでください");
                    int target = Integer.parseInt(br.readLine());
                    ((Wizard) c).magic(monster.get(target));
                } else if (c instanceof Thief) { }
            }
            for (Monster c2 : monster) {
                for (Character c : party) {
                    if ((!c.isAlive())) {
                        c.die();
                        party.remove(c);
                    }
                }
                int attacktarget = (int) (random() * party.size());
                c2.attack(party.get(attacktarget));
            }
            if(party.isEmpty()){
                System.out.println("味方パーティは全滅してしまった…");
            } else if(monster.isEmpty()){
                System.out.println("敵を全て倒した!"+h.getName()+"達は勝利した!");
            }
        }while(!(party.isEmpty() || monster.isEmpty()));

    }
}