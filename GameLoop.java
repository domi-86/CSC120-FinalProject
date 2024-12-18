//if hp <= 0, player types "quit", or if player wins then the came will end

import java.util.Scanner;

public class GameLoop {

public static void main(String[] args) {

    Game myGame = new Game();

    boolean stillPlaying = true;

    // We'll use this to get input from the user.
    Scanner userInput = new Scanner(System.in);

    // Storage for user's responses
    String userResponse = "";

    // This could be replaced with a more interesting opening
    System.out.println("******************");
    System.out.println("Press ENTER to continue.");
    System.out.println("******************");

    userResponse = userInput.nextLine().toUpperCase();
    if (userResponse.equals("")) {
        System.out.println("Game start!");

        myGame.play();
    }

    userInput.close();

    System.out.println("Thank you for playing!");
    

}

}
