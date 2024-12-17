import java.util.Scanner;

public class Game {

    private Room room1;
    private Room room2;
    private Room room3;
    //private Room room3;
    private Room[][] gameMap;
    private Map map;
    private boolean stillPlaying;
    private Player player;
    

    public Game() {
        this.room1 = new Room("Entrance","The Entrance: You are in a large hall with two sets of unpassable staircases on the sides of the room. To the north is x, to the west is y, and to the east is z.",true, true,false,true);
        this.room2 = new Room("Library", "The Library: The library is filled with bookshelves, leaving only narrow pathways to walk through them. It's very claustrophobic. To the east is the entrance hallway and to the south is a door.", false,true,true,false);
        this.room3 = new Room("Library Study","It is a small room. It has a desk, chair, and small bookcases lining the walls. It looks like an office.",true,false,false,false); //maybe when you look around you can find a hidden passage
        this.stillPlaying = true;
        this.gameMap = new Room[][]{
                                    {room1,room2},      
                                    {null, room3}};
        this.map = new Map(gameMap);
        this.player = new Player();

        //
    }

    

    public void play() {

        map.addRoom(room1,0,0);
        map.addRoom(room2,0,1);
        map.addRoom(room2,1,1);

        map.showMap();

        //System.out.println(gameMap[0][0].getDescription());

        System.out.println("You wake up in a dark room lying on rotting floorboards...");

        Scanner userInput = new Scanner(System.in);

        this.stillPlaying = true;

        do {

        // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            System.out.println("You are still playing.");

            // ask player for input
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
            userInput.close();

        } 



 }






    

