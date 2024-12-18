
import java.util.Arrays;
//import java.util.ArrayList;

public class Inventory {

    private TakeableItem[] inv;

    public Inventory() {

        this.inv = new TakeableItem[5];

        
    }

    // add to inventory

    public void addToInv(TakeableItem item) {
        
        for (int i = 0; i < 5; i++) {
            if (this.inv[i] == null) {
                this.inv[i] = item;
                break;
            }
        }
    }

    public void addToInv(String item) {

        addToInv(getItem(item));

    }

    //remove from inventory 

    public void removeFromInv(TakeableItem item) {

        for (int i = 0; i < 5; i++) {
            if (this.inv[i] == item) {
                this.inv[i] = null;
                break;
            }
        }

    }

    public void removeFromInv(String item) {

        removeFromInv(getItem(item));

    }

    public TakeableItem getItem(String itemName) {

        for (int i = 0; i < 5; i++) {
            if (this.inv[i].getName().equals(itemName)) {

                return this.inv[i];
                
            }

    }
        return null;
}

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

    @Override
    public String toString() {
        return Arrays.toString(this.inv);
    }
    


}