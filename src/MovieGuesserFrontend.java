import java.util.Scanner;

/**
 * The MovieGuesserFrontend class represents the front end of the Movie Guessing Game, which
 * interacts with the user and displays the questions and results of the game.
 */
public class MovieGuesserFrontend {
    Scanner in;
    MovieGuesserBackend backend;
    
    int score = 0;

    /**
     * Constructs a new MovieGuesserFrontend object with a Scanner for user input and a
     * MovieGuesserBackend for the game logic.
     * @param userInputScanner the Scanner for user input
     * @param backend the MovieGuesserBackend for the game logic
     */
    public MovieGuesserFrontend(Scanner userInputScanner, MovieGuesserBackend backend) {
        in = userInputScanner;
        this.backend = backend;
    }

    /**
     * Runs the main input loop of the game and displays the questions and results to the user.
     */
    public void runCommandLoop() {
        System.out.println("Welcome to Movie Guessing Game!");
        System.out.println("-------------------------------");
        System.out.println();
        boolean exit = false;
        boolean fail = false;
        boolean newQuestion = true;
        Movie[] moviePair = null;
        int correctChoice = 0;
        
        while (!exit) {
            if (newQuestion) {
              moviePair = backend.getMoviePair();
              correctChoice = backend.compareMovies(moviePair) + 1;
              System.out.println("Q" + (score+1) + ": Which is the higher grossing movie?\n");
              System.out.println("(1) " + moviePair[0].getTitle());
              System.out.println("\tor");
              System.out.println("(2) " + moviePair[1].getTitle());
              newQuestion = false;
            }
            
            char userInput = '0';
            if (in.hasNextLine()) {
                userInput = in.nextLine().trim().charAt(0);
            }
            
            if (userInput == '1' || userInput == '2') {
              int userChoice = Integer.parseInt(userInput + "");
              if (userChoice == correctChoice) {
                System.out.println("Correct\n");
                score += 1;
                newQuestion = true;
              } else {
                System.out.println("Incorrect\n");
                fail = true;
              }
              
              System.out.print(moviePair[0].getTitle() + ": ");
              System.out.println(shortenNumber(moviePair[0].getSales()) + "\n");
              System.out.print(moviePair[1].getTitle() + ": ");
              System.out.println(shortenNumber(moviePair[1].getSales()) + "\n");
            }
            
            if (fail) {
              System.out.println("Game Over! Your score is " + score + ".");
              in.close();
              exit = true;
            }
            
            if (userInput == 'q') {
              System.out.println("Quitting. Your score is " + score + ".");
              in.close();
              exit = true;
            }      
        }
    }

    /**
     * Shortens a given long number to a string representation with the suffix "K" for thousands,
     * "M" for millions, and "B" for billions, if the number is greater than or equal to 1000. If
     * the number is less than 1000, it returns the original number string.
     * @param num the long number to shorten
     * @return the shortened string representation of the number
     */
    public static String shortenNumber(long num) {
      if (num < 1000000) {
          return num + "";  // Return the original number string if it's less than 1 million
      }
      String suffix = "";
      double shortenedNum = num;
      if (num >= 1000000000) {
          suffix = "B";  // Use "B" for billions
          shortenedNum = num / 1000000000.0;
      } else if (num >= 1000000) {
          suffix = "M";  // Use "M" for millions
          shortenedNum = num / 1000000.0;
      } else if (num >= 1000) {
          suffix = "K";  // Use "K" for thousands
          shortenedNum = num / 1000.0;
      }
      // Format the shortened number to have 1 or 2 significant digits after the decimal point
      String formatStr = shortenedNum < 10 ? "%.1f%s" : "%.2f%s";
      return String.format(formatStr, shortenedNum, suffix);
    }

}