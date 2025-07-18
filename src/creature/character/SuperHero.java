package creature.character;

public class SuperHero extends Hero {
    public SuperHero(Hero h) {
        super(h.getName(), h.getHp(),h.getWeapon());
        System.out.println("ダメージを受けた"+getName()+"が突然光りだした\n"+getName()+"スーパーヒーローに進化した！");
    }
    public void attack(Creature target) {
        System.out.println(getName() + "は" + super.getWeapon() + "で攻撃！" + target.getName() + "に25のダメージを与えた");
        target.setHp(target.getHp()-25);
    }
}
