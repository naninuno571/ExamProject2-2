import creature.*;
import creature.Character;
import creature.character.*;
import creature.monster.*;

import java.util.ArrayList;
import java.io.*;

import static java.lang.Math.random;

//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。
public class GameMaster {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> party = new ArrayList<Character>();
        ArrayList<Monster> monster = new ArrayList<Monster>();
        Hero h = new Hero("勇者",100);
        party.add(h);
        party.add(new Wizard("魔法使い",60,20));
        Thief t = new Thief("盗賊",70);
        party.add(t);
        int[] a = new int[party.size()];

        int matangocnt = 0;
        int slimecnt = 0;
        int goblinint = 0;
        for(int i=0;i<5;i++){
            int cnt = (int) (random()*3);
            switch(cnt){
                case 0:
                    monster.add(new Matango((char)('A'+matangocnt),45));
                    matangocnt++;
                    break;
                case 1:
                    monster.add(new Goblin((char)('A'+goblinint),50));
                    goblinint++;
                    break;
                case 2:
                    monster.add(new Slime((char)('A'+slimecnt),40));
                    slimecnt++;
                    break;
            }
        }
        int[] monsterparty = new int[monster.size()];
        boolean superheroflg = false;

        while(!(party.isEmpty() || monster.isEmpty())){

            for (int e:a) {
                int choice = 0;
                for (int c2:monsterparty) {
                    if (!(monster.get(c2).isAlive())) {
                        monster.get(c2).die();
                        monster.remove(c2);
                        monsterparty=new int[monster.size()];
                    } else if (monster.get(c2).getHp() <= 5) {
                        monster.get(c2).run();
                        monster.remove(c2);
                        monsterparty=new int[monster.size()];
                    }
                }
                System.out.println("---味方パーティ---");
                for(Character c : party){
                    c.showStatus();
                }
                System.out.println("---敵グループ---");
                for(Monster c2 : monster){
                    c2.showStatus();
                }
                if (party.get(e) instanceof Hero && (!(superheroflg))) {
                    System.out.println(party.get(e).getName() + "のターン\n1. 攻撃\n2. SuperHeroになる");
                } else if (party.get(e) instanceof Wizard) {
                    System.out.println(party.get(e).getName() + "のターン\n1. 攻撃\n2. 魔法攻撃");
                } else if (party.get(e) instanceof Thief) {
                    System.out.println(party.get(e).getName() + "のターン\n1. 攻撃\n2. 守り");
                    ((Thief) party.get(e)).guard();
                } else if (party.get(e) instanceof SuperHero && superheroflg) {
                    System.out.println(party.get(e).getName() + "のターン\n1. 攻撃");
                }
                if(superheroflg){}
                    do {
                        try {
                            System.out.println("行動を入力してください");
                            choice = Integer.parseInt(br.readLine());
                            if (!(choice == 1 || choice == 2)) {
                                System.out.println("選びなおしてください");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException error) {
                            System.out.println("数字を入力してください");
                        }
                    } while (true);
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
                            party.get(e).attack(monster.get(target));
                            break;
                        } catch (NumberFormatException error) {
                            System.out.println("数字を入力してください");
                        } catch (IndexOutOfBoundsException error) {
                            System.out.println("選びなおしてください");
                            continue;
                        }
                    } while (true);
                } else if (party.get(e) instanceof Hero&& (!(superheroflg))) {
                    superheroflg = true;
                    SuperHero sh = new SuperHero(new Hero("勇者", party.get(e).getHp()));
                    party.remove(party.get(e));
                    party.add(0, sh);
                } else if (party.get(e) instanceof Wizard) {
                    System.out.println("攻撃対象を選んでください");
                    int target = Integer.parseInt(br.readLine());
                    ((Wizard) party.get(e)).magic(monster.get(target));
                } else if (party.get(e) instanceof Thief) {
                    ((Thief) party.get(e)).guard();
                }
            }
            for (int c2:monsterparty) {
                for (int c:a) {
                    if ((!party.get(c).isAlive())) {
                        party.get(c).die();
                        party.remove(c);
                        a = new int[party.size()];
                    }
                }
                int attacktarget = (int) (random() * party.size());
                monster.get(c2).attack(party.get(attacktarget));
            }
            if(party.isEmpty()){
                System.out.println("味方パーティは全滅してしまった…");
            } else if(monster.isEmpty()){
                System.out.println("敵を全て倒した!"+h.getName()+"達は勝利した!");
            }
        }

    }
}