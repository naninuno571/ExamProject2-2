package creature;

public interface Creature {
    public boolean isAlive();
    public void showStatus();
    public  String getName();
    public int getHp();
    public void setHp(int hp);
}