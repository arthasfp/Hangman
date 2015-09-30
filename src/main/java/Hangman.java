import java.io.IOException;

public class Hangman {

    public static void main(String[] args) throws IOException {
        // Enter amazing code here:
        Game game = new Game("treehouse");
        Prompter prompter = new Prompter(game);
        prompter.play();
    }

}