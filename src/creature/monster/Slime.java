package creature.monster;

import creature.Creature;
import creature.Monster;

public final class Slime extends Monster {
    public Slime(char suffix, int hp){
        super(suffix,hp);
    }

    @Override
    public void attack(Creature target) {
        System.out.println("スライム"+getSuffix()+"は体当たり攻撃！"+target.getName()+"に5のダメージを与えた！");
        target.setHp(target.getHp()-5);
    }

    @Override
    public String getName() {
        return "スライム" + getSuffix();
    }
}
