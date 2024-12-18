public class Item {

    protected String description;
    protected String name;

    /**
     * Constructor
     * @param name
     * @param description
     */
    public Item(String name, String description) {

        this.name = name;
        this.description = description;

    }

    /**
     * Constructor
     * @param name
     */
    public Item(String name) {

        this.name = name;

    }

    /**
     * Constructor
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * getter for name
     * @return
     */
    public String getName() {
        return this.name;
    }

    // public String use(Item item) {

    //     if (item.name.equals("switch")) {
    //         return "You flipped the switch.";
    //     }


    // }

    /** returns the item's name */
    public String toString() {
        return this.name;
    }

}