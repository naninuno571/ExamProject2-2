package creature;

public abstract class Character implements Creature{
    private String name;
    private int hp;
    public Character(String name, int hp){
         if(hp <= 0){
             throw new IllegalArgumentException("初期設定に誤りがあるため、キャラクターを作成できませんでした");
         }
         this.name = name;
         this.hp = hp;
    }
    final public boolean isAlive(){
        return this.hp>0;
    }
    public void showStatus(){
        System.out.println(getName()+":"+getHp());
    }
    public void setHp(int hp){if(hp <= 0){this.hp=0;}else{this.hp = hp;}}
    public int getHp(){return hp;}
    public String getName(){return name;}
    public void setName(){this.name=name;}

    public abstract void attack(Creature target);
}
