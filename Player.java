
import java.awt.Point;
//import java.util.ArrayList;

public class Player {

    private int maxHP;
    private int hp;
    private Inventory inv;
    private boolean alive;
    private Point pos;

    public Player() {
        this.maxHP = 100;
        this.hp = 100;
        this.inv = new Inventory();
        this.alive = true;
        this.pos = new Point(0,0);
        //this.visited = new ArrayList<>();
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

    public boolean getStatus() {
        return this.alive;
    }

    public void changePos(int newX, int newY) {
        this.pos.setLocation(newX, newY);
    }


    public int getX() {
        return (int)this.pos.getX();
    }

    public int getY() {
        return (int)this.pos.getY();
    }

    public Point getPos() {
        return this.pos;
    }

    public TakeableItem[] getInv() {
        return this.inv.getInv();
    }

    public String toString(){
        return "Your status is: "+this.alive+" and you have "+this.hp+" HP.";
    }

    
}
