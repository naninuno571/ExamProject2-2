package creature.monster;

import creature.Creature;
import creature.Monster;

public class Goblin extends Monster {
    public Goblin(char suffix, int hp) {
        super(suffix,hp);
    }
    public void attack(Creature target){
        System.out.println("ゴブリン"+getSuffix()+"はナイフで切りつけた！"+target.getName()+"に8のダメージを与えた！");
        target.setHp(target.getHp()-8);
    }

    @Override
    public String getName() {
        return "ゴブリン" + getSuffix();
    }
}
