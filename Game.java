import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Room room1, room2, room3, hallway, room5, room6; // room7, room8, room9, room10;
    //private Room room3;
    private Room[][] gameMap;
    private Map map;
    private boolean stillPlaying;
    private Player player;
    private List <String> commands;
    private List <String> movementCommands;
    private Room currentRoom;
    private Inventory inventory;



    /**
     * Constructor
     */
    public Game() {
        Item lightSwitch = new Item("switch", "Flip it to turn on the lights.");
        TakeableItem key = new TakeableItem("key", "It must go to something.");
        this.room1 = new Room("Entrance", "The Entrance: You are in a large hall with two sets of unpassable staircases on the sides of the room. To the north is x, to the west is y, and to the east is a set of wooden doors with a stained glass mural above them.", true, true, false, false);
        this.room2 = new Room("Library", "The Library: The library is filled with bookshelves, leaving only narrow pathways to walk through them. It's very claustrophobic. To the west is the entrance hallway and to the south is a door.", false, false, true, true);
        this.room3 = new Room("Library Study", "It is a small room. It has a desk, chair, and small bookcases lining the walls. It looks like an office, but it's dark. There is a switch on the wall.", true, false, true, false, key, lightSwitch); //maybe when you look around you can find a hidden passage to the south
        this.hallway = new Room("Hidden Passage", "Hidden Passage: You are in a small hall just barely tall and wide enough for you to fit through. There is light coming from the east wall. You see pebbles falling from the ceiling. It'd be best to get out of here quickly.", false, true, false, false);
        this.room5 = new Room("Garden", "The Garden: After navigating through the winding tunnel, you're end up outside! Overgrown plants overtake the benches and fountain. There is an archway to the east.", false, true, false, false);
        this.room6 = new Room("Outdoors", "Surrounding the mansion is a dense forest oddly void of any noise.", false, false, false, true);
        //this.room5 = new Room("");
        this.stillPlaying = true;
        this.gameMap = new Room[][] { //room here
            {room1,room2}, 
            {null,room3},
            {null,hallway,room5,room6},
        };
        this.map = new Map(gameMap);
        this.player = new Player();
        this.commands = Arrays.asList("look around", "examine", "drop", "pick up", "take", "inv", "inventory", "use", "help");
        this.movementCommands = Arrays.asList("go north", "n", "go east", "e", "go west", "w", "go south", "s");
        this.currentRoom = gameMap[0][0];
        this.inventory = player.getInventory();


        //
    }

    /**
     * Prints a list of all commands
     * @return
     */
    public String getCommands() {
        return """
        =========
        available commands:
            - "go north" / "n" 
            - "go east" / "e" 
            - "go west" / "w" 
            - "go south" / "s"
            - "look around"
            - "examine"
            - "drop"
            - "pick up" / "take"
            - "inv" / "inventory"
            - "use" 
            - "help" 
            =========
                """; 
    }


    /***
     * Player travels between rooms
     * @param input
     */
    public void go(String input) {
        if (input.equals("go north") || input.equals("n")) {
            if (currentRoom.getNExit()) {
                player.changePos(player.getX() - 1, player.getY());
                currentRoom = gameMap[player.getX()][player.getY()];
                System.out.println(gameMap[player.getX()][player.getY()].getDescription());
            } else {
                System.out.println("You cannot go this way.");
            }

        } else if (input.equals("go east") || input.equals("e")) {
            if (currentRoom.getEExit() == true) {
                player.changePos(player.getX(), player.getY() + 1);
                currentRoom = gameMap[player.getX()][player.getY()];
                System.out.println(gameMap[player.getX()][player.getY()].getDescription());
            } else {
                System.out.println("You cannot go this way.");
            }

        } else if (input.equals("go south") || input.equals("s")) {

            if (currentRoom.getSExit()) {
                player.changePos(player.getX() + 1, player.getY());
                currentRoom = gameMap[player.getX()][player.getY()];
                System.out.println(gameMap[player.getX()][player.getY()].getDescription());
            } else {
                System.out.println("You cannot go this way.");
            }
        } else if (input.equals("go west") || input.equals("w")) {
            if (currentRoom.getWExit()) {
                player.changePos(player.getX(), player.getY() - 1);
                currentRoom = gameMap[player.getX()][player.getY()];
                System.out.println(gameMap[player.getX()][player.getY()].getDescription());
            } else {
                System.out.println("You cannot go this way.");
            }
        } else {
            System.out.println("Incorrect command.");
        }
    }

    /**
     * Returns a description of the room
     * @return
     */
    public String lookAround() {
        return currentRoom.getDescription();
    }

    /**
     * Returns the description of an item
     * @param input
     * @return
     */
    public String examine(String input) {

        if (input.equals("examine")) {
            return "Specify which item to examine in the command.";
        }

        String item = input.substring(input.indexOf("examine" + 8, input.length()));

        if (((currentRoom.getItem().getName().equals(item)))) {

            return currentRoom.getItem().getDescription();

        } else if (currentRoom.getItem2().getName().equals(item)) {

            return currentRoom.getItem2().getDescription();

        } else if (inventory.itemInInv(item)) { //or if inventory has items)4
            return player.getInventory().getItemDesc(item);
            //}


        }
        return "Incorrect command.";
    }

    /**
     * Removes item from inventory
     * @param input
     * @return
     */
    public String drop(String input) {

        if (input.equals("drop")) {
            return "Specify which item to drop.";
        } else if (input.contains("drop ")) {
            String item = input.substring(input.indexOf("drop" + 5, input.length()));

            if (inventory.itemInInv(item)) {

                inventory.removeFromInv(item);

                return item + " successfully removed from inventory.\n" + inventory.toString();
            } else {
                return "Item not in inventory.";
            }
        }

        return "Incorrect command.";

    }

    /**
     * adds item to inventory
     * @param input
     * @return
     */
    public String take(String input) {

        if (input.equals("take") || input.equals("pick up")) {
            return "Specify which item to take in your command.";
        } else if (input.contains("take ") || input.equals("pick up ")) {
            String item = "";
            if (input.contains("take ")) {
                item = input.substring(input.indexOf("take" + 5, input.length()));

            } else {
                item = input.substring(input.indexOf("pick up" + 7, input.length()));
            }


            if (currentRoom.getItem().getName().equals(item)) {
                inventory.addToInv(item);
                return item + " successfully added to inventory.\n" + inventory.toString();
            } else if (currentRoom.getItem2().getName().equals(item)) {
                inventory.addToInv(item);
                return item + " successfully added to inventory.\n" + inventory.toString();
            } else {
                return "Item not in inventory.";
            }

        } else {
            return "Incorrect command.";
        }
    }

    /**
     * uses an item and removes it from inventory (if applicable)
     * @param input
     * @return
     */
    public String use(String input) {
        if (input.equals("use")) {
            return "Specify what to use in the command.";
        } else if (input.contains("use ")) {

            String item = input.substring(input.indexOf("use" + 4, input.length()));
            System.out.println(item);

            if (item.equals("key") && inventory.itemInInv(item)) {


                inventory.removeFromInv(item);
                return "You used the key on the door and hear it unlock.";


            } else if (item.equals("switch")) {


                if (currentRoom.getItem().getName().equals(item) || currentRoom.getItem2().getName().equals(item)) {
                    if (currentRoom.getItem().getName().equals(item)) {
                        return "You flip the switch and the lights flicker on. In the light, you can see there is another passage to the south.";

                    } else if (currentRoom.getItem2().getName().equals(item)) {
                        return "You flip the switch and the lights flicker on. In the light, you can see there is another passage to the south.";

                    }
                }

            } else {
                return "You can't use this item.";
            }

        }
        return "Incorrect command.";
    }

    /**
     * ends the game
     *  */
    public void quit() {
        stillPlaying = false;
        System.out.println("Thank you for playing!");
        System.exit(0);
    }

    /**
     * checks the input and goes through all commands
     * @param input
     */
    public void actions(String input) { //"look around","examine","drop","pick up","take","inv","inventory","use","help"
        input = input.toLowerCase();

        if (input.equals("look around")) {
            System.out.println(lookAround());
        } else if (input.contains("examine")) {

            System.out.println(examine(input));

        } else if (input.contains("drop")) {

            System.out.println(drop(input));

        } else if (input.contains("take") || input.contains("pick up")) {

            System.out.println(take(input));
        } else if (input.equals("inv") || input.equals("inventory")) {
            System.out.println(inventory.toString());
        } else if (input.contains("use")) {

            System.out.println(use(input));

        } else if (input.equals("help")) {
            System.out.println(getCommands());
        }

    }

    /** everything put together in order to play & loop the game */
    public void play() {

        map.addRoom(room1, 0, 0);
        map.addRoom(room2, 0, 1);
        map.addRoom(room3, 1, 1);
        map.addRoom(hallway, 2, 1);
        map.addRoom(room5, 2, 2);
        map.addRoom(room6, 2, 3);

        //map.showMap();

        System.out.println("You wake up in a dark room lying on rotting floorboards...");
        System.out.println(currentRoom.getDescription() + "\nWhat will you do?");

        Scanner userInput = new Scanner(System.in);

        this.stillPlaying = true;

        do {

            // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓

            // ask player for input

            String userResponse = userInput.nextLine().toLowerCase();


            if (movementCommands.contains(userResponse)) {
                go(userResponse);
            } else if (commands.contains(userResponse)) {
                actions(userResponse);
            } else if (userResponse.equals("quit")) {
                stillPlaying = false;
                break;
            }

            if (currentRoom == room6) {
                System.out.println("You win!");
                stillPlaying = false;
                break;
            }

            // depending on the room they are in they can do a few things,
            // have list of commands to look through, have option for each, and then 


            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓

            if ((player.getStatus() == false)) {
                this.stillPlaying = false;

                System.out.println("You died.");

            }

        } while (this.stillPlaying);

        userInput.close();


    }





}