package creature.character;

import creature.Character;
import creature.Creature;
import weapon.Wand;
import weapon.Weapon;

public class Wizard extends Character {
    private int hp;
    private int mp;
    Weapon w = new Wand();
    public Wizard(String name, int hp, int mp) {
        super(name, hp,new Wand());
        this.mp=mp;
    }
    @Override
    public void attack(Creature target) {
        System.out.println(getName()+"は石を投げた！"+target.getName()+"に3のダメージを与えた！");
        target.setHp(target.getHp()-3);
    }
    public void magic(Creature target) {
        if(this.mp<w.getCost()){
            System.out.println("MPが足りない！");
        } else {
            this.mp-=w.getCost();
            target.setHp(target.getHp()-w.getDamage());
            System.out.println(getName()+"は"+w.getName()+w.attackMessage());
        }

    }
}
