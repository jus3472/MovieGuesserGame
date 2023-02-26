import java.util.List;
import java.util.Random;

/**
 * This class represents the backend for the Movie Guesser game. It contains methods to retrieve a
 * pair of movies to compare and to compare the sales of two movies.
 */
public class MovieGuesserBackend {
  private Random randGen = new Random();
  private List<Movie> movieList;

  /**
   * Constructs a new MovieGuesserBackend object with the given list of movies.
   * @param movieList a list of movies to use for the game
   */
  public MovieGuesserBackend(List<Movie> movieList) {
    this.movieList = movieList;
  }

  /**
   * Returns an array of two movies randomly chosen from the movie list.
   * @return an array of two movies to compare
   */
  public Movie[] getMoviePair() {
    int num1 = 0;
    int num2 = 0;

    while (num1 == num2) {
      num1 = randGen.nextInt(movieList.size());
      num2 = randGen.nextInt(movieList.size());
    }

    Movie[] moviePair = {movieList.get(num1), movieList.get(num2)};
    return moviePair;
  }

  /**
   * Compares the sales of two movies and returns the index of the movie with the higher sales.
   * If both movies have the same sales, returns 0.
   * @param moviePair an array of two movies to compare
   * @return the index of the movie with the higher sales, or 0 if both movies have the same sales
   */
  public int compareMovies(Movie[] moviePair) {
    if(moviePair[0].getSales() > moviePair[1].getSales()) {
      return 0;
    } else {    
      return 1;
    }
  } 
}