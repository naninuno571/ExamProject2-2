package creature.monster;

import creature.Creature;
import creature.Monster;

public class Matango extends Monster {

    public Matango(char suffix, int hp) {
        super(suffix, hp);
    }

    public void attack(Creature target) {
        System.out.println("お化けキノコ" + getSuffix() + "は体当たり攻撃！" + target.getName() + "に6のダメージを与えた");
        target.setHp(target.getHp() - 6);
    }

    @Override
    public String getName() {return "お化けキノコ" + getSuffix();}
    @Override
    public void setHp(int hp){super.setHp(hp);}
}


