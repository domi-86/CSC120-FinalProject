public class Item {

    protected String description;
        protected String name;
    
        public Item(String name, String description) {
    
            this.name = name;
            this.description = description;
    
        }
    
        public Item(String name) {
    
            this.name = name;
    
        }
    
        public String getDescription() {
            return this.description;
    }

    public String getName() {
        return this.name;
    }

    public void use() {

        if (this.name.equals("switch")) {
            System.out.println("You flipped the switch.");
        }


    }

    public String toString() {
        return this.name;
    }
    
}
