import java.util.Arrays;

public class Map {
    private Room[][] map;
    //private List<String> directions;
    //private ArrayList<Room> visited; 


    /**
     * Constructor
     * @param map
     */
    public Map(Room[][] map) {
        this.map = map;
        //this.directions = Arrays.asList("north,east,south,west");
        //this.visited = new ArrayList<>();
    }

    /**
     * adds room to the map
     * @param room
     * @param xPos
     * @param yPos
     */
    public void addRoom(Room room, int xPos, int yPos) {
        this.map[xPos][yPos] = room;

    }

    // public void addVisited() { // work on later

    //     if (!visited.contains(map[Player.getX()][Player.getY()])) {
    //         visited.add(map[Player.getX()][Player.getY()]);
    //     }
    // }

    /**
     * prints out a readable map
     */
    public void showMap() {
        System.out.println("=========\n MAP:");
        for (Room[] row: map)

            System.out.println(Arrays.toString(row));

        System.out.println("=========");

    }

}