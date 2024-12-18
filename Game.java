import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Game {

    private Room room1, room2, room3, hallway, room5, room6, room7, room8, room9, room10;
    //private Room room3;
    private Room[][] gameMap;
    private Map map;
    private boolean stillPlaying;
    private Player player;
    private List<String> commands;
    private List<String> movementCommands;
    private Room currentRoom;

    

    public Game() {
        Item lightSwitch = new Item("switch","Flip it to turn on the lights.");
        TakeableItem key = new TakeableItem("key","It must go to something.");
        this.room1 = new Room("Entrance","The Entrance: You are in a large hall with two sets of unpassable staircases on the sides of the room. To the north is x, to the west is y, and to the east is a set of wooden doors with a stained glass mural above them.",true, true,false,false);
        this.room2 = new Room("Library", "The Library: The library is filled with bookshelves, leaving only narrow pathways to walk through them. It's very claustrophobic. To the east is the entrance hallway and to the south is a door.", false,false,true,true);
        this.room3 = new Room("Library Study","It is a small room. It has a desk, chair, and small bookcases lining the walls. It looks like an office, but it's dark. There is a switch on the wall.",true,false,true,false,key,lightSwitch); //maybe when you look around you can find a hidden passage to the south
        this.hallway = new Room("Hidden Passage","Hidden Passage: You are in a small hall just barely tall and wide enough for you to fit through. There is light coming from the east wall. You see pebbles falling from the ceiling. It'd be best to get out of here quickly.",false, true,false,false);
        //this.room5 = new Room("");
        this.stillPlaying = true;
        this.gameMap = new Room[][]{ //room here
                                    {room1,room2},      
                                    {null, room3},
                                    {null,hallway,room5},
                                };
        this.map = new Map(gameMap);
        this.player = new Player();
        this.commands = Arrays.asList("look around","examine","drop","pick up","take","inv","inventory","use","help");
        this.movementCommands = Arrays.asList("go north","n","go east","e","go west","w","go south","s");
        this.currentRoom = gameMap[0][0];
        

        //
    }

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
                - "use" / "flip" (a switch)
                - "help"
                =========
                """;
    }


    public void go(String input) {
            if (input.equals("go north") || input.equals("n")) {
                if (currentRoom.getNExit()) {
                    player.changePos(player.getX()-1,player.getY());
                    currentRoom = gameMap[player.getX()][player.getY()];
                    System.out.println(gameMap[player.getX()][player.getY()].getDescription());
                }
                else{
                    System.out.println("You cannot go this way.");
                }

            }
            else if (input.equals("go east") || input.equals("e")) {
                if (currentRoom.getEExit() == true) {
                    player.changePos(player.getX(),player.getY()+1);
                    currentRoom = gameMap[player.getX()][player.getY()];
                    System.out.println(gameMap[player.getX()][player.getY()].getDescription());
                }
                else{
                    System.out.println("You cannot go this way.");
                }

            }
            else if (input.equals("go south") || input.equals("s")) {

                if (currentRoom.getSExit()) {
                    player.changePos(player.getX()+1,player.getY());
                    currentRoom = gameMap[player.getX()][player.getY()];
                    System.out.println(gameMap[player.getX()][player.getY()].getDescription());
            }
                else {
                    System.out.println("You cannot go this way.");
                }
            }

            else if (input.equals("go west") || input.equals("w")) {
                if (currentRoom.getWExit()){
                    player.changePos(player.getX(),player.getY()-1);
                    currentRoom = gameMap[player.getX()][player.getY()];
                    System.out.println(gameMap[player.getX()][player.getY()].getDescription());
            }
                else {
                    System.out.println("You cannot go this way.");
                }
        }
            else {
                System.out.println("Incorrect command.");
            }
    }

    public void actions(String input) { //"look around","examine","drop","pick up","take","inv","inventory","use","help"
        input = input.toLowerCase();
        
        if (input.equals("look around")) {
            currentRoom.lookAround();
        }
        else if (input.contains("examine")) {

            String item = input.substring(input.indexOf("examine"+8,input.length()));

            if (((currentRoom.getItem().equals(item) ) )) {

                System.out.println(currentRoom.getItem());

            }
            
            else if (currentRoom.getItem2().equals(item) ) {
                
                currentRoom.getItem2();
    
            }
            
            else if (inventory.itemInInv(item))  { //or if inventory has items)4
                System.out.println(inventory.getItemDesc(item));
                
        }
        }
    }
        


    

    public void play() {

        map.addRoom(room1,0,0);
        map.addRoom(room2,0,1);
        map.addRoom(room3,1,1);
        map.addRoom(hallway,2,1);
        map.addRoom(room5,2,2);

        map.showMap();

        //System.out.println(gameMap[0][0].getDescription());

        System.out.println("You wake up in a dark room lying on rotting floorboards...");
        //System.out.println(player.getPos());
        System.out.println(currentRoom.getDescription() + "\nWhat will you do?");
        

        this.stillPlaying = true;

        do {

            Scanner userInput = new Scanner(System.in);
            
        // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓

            // ask player for input

            String userResponse = userInput.nextLine().toLowerCase();


            if (movementCommands.contains(userResponse)) {
                go(userResponse);
            }
            System.out.println(player.getPos());
            // depending on the room they are in they can do a few things,
            // have list of commands to look through, have option for each, and then 


            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓

            if ((player.getStatus() == false)) {
                this.stillPlaying = false;

                System.out.println("You died.");

                // if (userResponse.equals("WIN")) {
                //     System.out.println("Yay, you won!");
                //     break;
                // } 
                // else { // userResponse.equals("LOSE")
                //     System.out.println("Better luck next time.");
                //     break;
                // }
    
            }

            } while (this.stillPlaying);

            // Tidy up
            

        } 




        
 }






    

