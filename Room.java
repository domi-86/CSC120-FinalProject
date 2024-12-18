public class Room {

    //private boolean hasStairs;
    private String name;
    private String description;
    private boolean nExit, eExit, sExit, wExit;
    private boolean hasItem;
    private Item item;
    private Item item2;


    public Room(String name, String description, boolean nExit, boolean eExit, boolean sExit, boolean wExit) {
        //this.hasStairs = hasStairs;
        this.name = name;
        this.description = description;
        this.nExit = nExit;
        this.eExit = eExit;
        this.sExit = sExit;
        this.wExit = wExit;
        this.hasItem = false;
    }

    public Room(String name, String description, boolean nExit, boolean eExit, boolean sExit, boolean wExit,Item item) {
        //this.hasStairs = hasStairs;
        this.name = name;
        this.description = description;
        this.nExit = nExit;
        this.eExit = eExit;
        this.sExit = sExit;
        this.wExit = wExit;
        this.hasItem = true;
        this.item = item;
        
    }

    public Room(String name, String description, boolean nExit, boolean eExit, boolean sExit, boolean wExit,Item item, Item item2) {
        //this.hasStairs = hasStairs;
        this.name = name;
        this.description = description;
        this.nExit = nExit;
        this.eExit = eExit;
        this.sExit = sExit;
        this.wExit = wExit;
        this.hasItem = true;
        this.item = item;
        this.item2 = item2;
        
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
       return this.name; 
    }


    public boolean getNExit(){
        return this.nExit;
    }

    public boolean getEExit(){
        return this.eExit;
    }

    public boolean getSExit() {
        return this.sExit;

    }

    public boolean getWExit() {
        return this.wExit;

    }

    public void blockExit(String direction) {
        // change a Room so that an exit is now false
    }

    public void openExit(String direction) {
        //change a Room so that an exit is now true
    }

    public void lookAround() {
        System.out.println(this.description);
    }

    public boolean getHasItem() {
        return this.hasItem;
    }

    public Item getItem() {
        return this.item;
    }

    public Item getItem2() {
        return this.item;
    }

    public String toString() {
        return this.name;
    }

    

    // look around

    // each Room has a description, doors, and possibly objects in it
    
}
