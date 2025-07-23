package weapon;

public abstract class Weapon {
    private String name;
    private int damage;
    private int cost;
    public Weapon(String name, int damage){
        this.name = name;
        this.damage = damage;
    }
    public abstract String attackMessage();
    public void setCost(int cost){this.cost = cost;}
    public int getCost(){return cost;}
    public void setName(String name){this.name = name;}
    public int getDamage(){return this.damage;}
    public String getName(){return this.name;}
}
