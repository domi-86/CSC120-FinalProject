
import java.util.Arrays;
import java.util.ArrayList;

public class Inventory {

    private TakeableItem[] inv;

    public Inventory() {

        this.inv = new TakeableItem[5];

        
    }

    // add to inventory

    //remove from inventory 

    public boolean itemInInv(String item) {
        for (TakeableItem i : this.inv) {
            if (i.getName().equals(item)) {
                return true;
    }
}
    return false;
    }

    public String getItemDesc(String thing) {

        if (itemInInv(thing)) {
            for (TakeableItem i : this.inv) {
                if (i.getName().equals(thing)) {
                    return i.getDescription();
            }
            }
 
            }
        
        return "This item is not in your inventory";

    }

    public TakeableItem[] getInv() { //get contents of inventory
        return this.inv;

}

    public boolean isEmpty() {
        return Arrays.asList(this.inv).isEmpty();
    }

}