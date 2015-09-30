import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompter{
    private Game mGame;

    public Prompter (Game game){
        mGame = game;
    }

    public void play() throws IOException {
        while(mGame.getRemainingTries() > 0 && !mGame.isSolved()){
            displayProgress();
            promptForGuess();
        }
        if(mGame.isSolved()){
            System.out.printf("Congratulations you won with %d tries remaining.\n", mGame.getRemainingTries());
        } else {
            System.out.printf("Bummer the word was %s.   :(\n", mGame.getAnswer());
        }
    }


    public boolean promptForGuess() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isHit = false;
        boolean isValidGuess = false;
        while(!isValidGuess){
            System.out.println("Enter a letter:  ");
            String guessAsString = reader.readLine();
            try{
                isHit = mGame.applyGuess(guessAsString);
                isValidGuess = true;
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s.  Please try again. \n", iae.getMessage());
            }
        }
        return isHit;
    }

    public void displayProgress(){
        System.out.printf("You have %d tries left to solve: %s\n",
                mGame.getRemainingTries(),
                mGame.getCurrentProgress());
    }
}