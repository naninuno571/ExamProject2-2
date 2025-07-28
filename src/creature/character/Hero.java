package creature.character;

import creature.Character;
import creature.Creature;
import weapon.Sword;
import weapon.Weapon;

public class Hero extends Character {
    Weapon w = new Sword();
    public Hero(String name, int hp) {
        super(name, hp,new Sword());
    }

    public void attack(Creature target) {
        System.out.println(getName() + "は" +w.getName() + w.attackMessage());
        target.setHp(target.getHp()-w.getDamage());
    }

}
