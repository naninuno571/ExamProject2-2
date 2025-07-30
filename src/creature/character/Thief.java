package creature.character;

import creature.Character;
import creature.Creature;
import weapon.Dagger;
import weapon.Weapon;

public class Thief extends Character {
    Weapon weapon= new Dagger();
    boolean guard;
    public Thief(String name, int hp) {
        super(name, hp,new Dagger());
    }
    public void attack(Creature target) {
        System.out.println(getName()+"は素早く２回攻撃した！"+target.getName()+ weapon.attackMessage());
        target.setHp(target.getHp()-5*2);
    }
    public void guard(){
        guard=true;
    }
    public void setHp(int damage){
        if(guard){
            System.out.println("しかし、"+getName()+"は攻撃を回避し、ダメージが入らなかった！");
            guard=false;
            super.setHp(getHp());
        }
    }
}
