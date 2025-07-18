import creature.*;
import creature.Character;
import creature.character.*;
import creature.monster.*;

import java.util.ArrayList;

//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。
public class GameMaster {
    private static Object c1;

    public static void main(String[] args) {
        ArrayList<Character> party = new ArrayList<Character>();
        ArrayList<Monster> monster = new ArrayList<Monster>();
        party.add(new Hero("勇者",100,"剣"));
        party.add(new Wizard("魔法使い",60,10));
        party.add(new Thief("盗賊",70));
        monster.add(new Matango('A',45));
        monster.add(new Goblin('A',50));
        monster.add(new Slime('A',40));
        System.out.println("---味方パーティ---");
        for(Character c : party){
            c.showStatus();
        }
        System.out.println("---敵グループ---");
        for(Monster c2 : monster){
            c2.showStatus();
        }
        for(Character c : party){
            for(Monster c2 : monster){
                c.attack(c2);

            }
        }
        for(Monster c2 : monster){
            for(Character c : party){
                c2.attack(c);
            }
        }
        SuperHero sh = new SuperHero(new Hero("勇者",100,"剣"));
        for(Monster c2 : monster){
            sh.attack(c2);
        }
        System.out.println("---味方パーティの最終ステータス---");
        for(Character c : party){
            c.showStatus();
            System.out.print("生存状況:");
            if(c.isAlive()){
                System.out.println("生存");
            }else{
                System.out.println("死亡");
            }
        }
        System.out.println("---敵グループの最終ステータス---");
        for(Monster c2 : monster){
            c2.showStatus();
            System.out.print("生存状況:");
            if(c2.isAlive()){
                System.out.println("生存");
            }else{
                System.out.println("討伐済み");
            }
        }
    }
}