import java.util.ArrayList;
import java.util.Arrays;

public class Map {
    private Room[][] map;
    //private ArrayList<Room> visited; 


    public Map(Room[][] map) {
        this.map = map;
        //this.visited = new ArrayList<>();
    }

    public void addRoom(Room room, int xPos, int yPos) {
       this.map[xPos][yPos] = room;

    }

    // public void addVisited() { // work on later

    //     if (!visited.contains(map[Player.getX()][Player.getY()])) {
    //         visited.add(map[Player.getX()][Player.getY()]);
    //     }
    // }

    

    //how to travel between rooms?

    //travel between floors

    // enter()
    // exit

    public void showMap() {
        System.out.println("=========\n MAP:");
        for (Room[] row : map)

            System.out.println(Arrays.toString(row));

        System.out.println("=========");
    
    }

}
