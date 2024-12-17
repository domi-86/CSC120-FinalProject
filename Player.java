
import java.util.ArrayList;

public class Player {

    private int maxHP;
    private int hp;
    private Item[] inventory;
    private boolean alive;
    private int xPos;
    private int yPos;

    public Player() {
        this.maxHP = 100;
        this.hp = 100;
        this.inventory = new TakeableItem[10];
        this.alive = true;
        this.xPos = 0;
        this.yPos = 0;
        this.visited = new ArrayList<>();
    }

    public void takeDamage(int num) {
        this.hp -= num;
        if (hp == 0) {
            alive = false;
        }
    }

    public void heal() {
        this.hp += 10;
        if (this.hp>this.maxHP) {
            this.hp = 100;
        }
    }

    public int getHP(){
        return this.hp;
    }

    public String getStatus(){
        return "Your status is: "+this.alive+" and you have "+this.hp+" HP.";
    }

    public int getX() {
        return this.xPos;
    }

    public int getY() {
        return this.yPos;
    }

    
}
