import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * A class that represents the entry point for the Movie Guesser application. It loads a list of
 * movies from an XML file, creates a MovieGuesserBackend object to handle game logic, creates a
 * MovieGuesserFrontend object to handle user input and output, and starts the input loop of the
 * front end.
 */
public class MovieGuesser {

  public static void main(String[] args) throws FileNotFoundException {
        MovieLoader movieLoader = new MovieLoader();
        // load the movies from the data file
        List<Movie> movieList = movieLoader.loadMovies("highestgrossingmovies.xml");
        // instantiate the back-end
        MovieGuesserBackend backend = new MovieGuesserBackend(movieList);
        // add all the movies to the back-end
        
        // instantiate the scanner for user input
        Scanner userInputScanner = new Scanner(System.in);
        // instantiate the front-end and pass references to the scanner, and back-end
        MovieGuesserFrontend frontend = new MovieGuesserFrontend(userInputScanner, backend);
        // start the input loop of the front-end
        frontend.runCommandLoop();
    }
}