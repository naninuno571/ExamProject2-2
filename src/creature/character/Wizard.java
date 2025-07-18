package creature.character;

import creature.Character;
import creature.Creature;

public class Wizard extends Character {
    private int hp;
    private int mp;
    public Wizard(String name, int hp, int mp) {
        super(name, hp);
        this.mp=mp;
    }
    @Override
    public void attack(Creature target) {
        if(mp>0){
            System.out.println(getName()+"は火の玉を放った！"+target.getName()+"に3のダメージを与えた！");
            target.setHp(target.getHp()-3);
            mp-=1;
        }
    }
}
