import java.awt.Point;
//import java.util.ArrayList;

public class Player {

    private int maxHP;
    private int hp;
    private Inventory inv;
    private boolean alive;
    private Point pos;

    /** Constructor */
    public Player() {
        this.maxHP = 100;
        this.hp = 100;
        this.inv = new Inventory();
        this.alive = true;
        this.pos = new Point(0, 0);
        //this.visited = new ArrayList<>();
    }

    /**
     * lowers player's HP by num
     * @param num
     */
    public void takeDamage(int num) {
        this.hp -= num;
        if (hp == 0) {
            alive = false;
        }
    }

    /**
     * raises player's HP
     */
    public void heal() {
        this.hp += 10;
        if (this.hp > this.maxHP) {
            this.hp = 100;
        }
    }

    /**
     * getter for HP
     * @return
     */
    public int getHP() {
        return this.hp;
    }

    /**
     * returns whether the player is alive
     * @return
     */
    public boolean getStatus() {
        return this.alive;
    }

    /**
     * mutator to change player's location/x and y coordinates
     * @param newX
     * @param newY
     */
    public void changePos(int newX, int newY) {
        this.pos.setLocation(newX, newY);
    }

    /**
     * getter for x coordinate
     * @return
     */
    public int getX() {
        return (int) this.pos.getX();
    }

    /**
     * getter for y coordinate
     * @return
     */
    public int getY() {
        return (int) this.pos.getY();
    }

    /**
     * getter for the Point value
     * @return
     */
    public Point getPos() {
        return this.pos;
    }

    /**
     * getter for the array of items in inventory
     * @return
     */
    public TakeableItem[] getInv() {
        return this.inv.getInv();
    }

    /**
     * getter for the inventory object
     * @return
     */
    public Inventory getInventory() {
        return this.inv;
    }

    /** returns player's status and HP value */
    public String toString() {
        return "Your status is: " + this.alive + " and you have " + this.hp + " HP.";
    }


}