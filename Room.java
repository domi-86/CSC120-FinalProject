public class Room {

    //private boolean hasStairs;
    private String name;
    private String description;
    private boolean nExit, eExit, sExit, wExit;
    private boolean hasItem;
    private Item item;


    public Room(String name, String description, boolean nExit, boolean eExit, boolean sExit, boolean wExit) {
        //this.hasStairs = hasStairs;
        this.name = name;
        this.description = description;
        this.nExit = nExit;
        this.nExit = eExit;
        this.nExit = sExit;
        this.nExit = wExit;
        this.hasItem = false;
    }

    public Room(String name, String description, boolean nExit, boolean eExit, boolean sExit, boolean wExit,Item item) {
        //this.hasStairs = hasStairs;
        this.name = name;
        this.description = description;
        this.nExit = nExit;
        this.nExit = eExit;
        this.nExit = sExit;
        this.nExit = wExit;
        this.hasItem = true;
        this.item = item;
        
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

    public void blockExit() {
        // change a Room so that an exit is now false
    }

    public void openExit() {
        //change a Room so that an exit is now true
    }

    public void lookAround() {
        System.out.println(this.description);
    }

    public String toString() {
        return this.name;
    }

    

    // look around

    // each Room has a description, doors, and possibly objects in it
    
}
