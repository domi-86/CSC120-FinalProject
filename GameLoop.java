public class GameLoop {

    boolean stillPlaying;
    Game myGame;
    Scanner userInput = new Scanner(System.in);

    do {

        myGame.play();

    } while (stillPlaying);
}