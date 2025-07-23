package creature.character;

import creature.Creature;

import weapon.Sword;
import weapon.Weapon;
public class SuperHero extends Hero {
    Weapon w = new Sword();
    public SuperHero(Hero h) {
        super(h.getName(), h.getHp(),w.getName());
        this.setHp(h.getHp()-30);
        System.out.println("ダメージを受けた"+getName()+"が突然光りだした\n"+getName()+"スーパーヒーローに進化した！");
    }
    public void attack(Creature target) {
        System.out.println(getName() + "は" + w.getName() + "で攻撃！" + target.getName() + "に25のダメージを与えた");
        target.setHp(target.getHp()- w.getDamage());
    }
}
