import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The MovieLoader class is responsible for loading a list of movies from an XML file and
 * creating a list of Movie objects.
 */
public class MovieLoader {

  /**
   * This method loads the list of movies from an XML file and returns a list of Movie objects.
   * @param filepathToXML path to the XML file relative to the executable
   * @return a list of Movie objects
   * @throws FileNotFoundException if the XML file cannot be found
   */
  public List<Movie> loadMovies(String filepathToXML) throws FileNotFoundException {

    ArrayList<Movie> movieList = new ArrayList<Movie>();

    Scanner sc = new Scanner(new File(filepathToXML));
    sc.nextLine();
    
    String title = null;
    Long sales = null;

    while (sc.hasNextLine()) {
      // get new line text
      String line = sc.nextLine().trim();
      // check for tags and set variables accordingly
      switch (line) {
        case "<Title>":
          title = sc.nextLine().trim();
          break;
        case "<Sales>":
          String salesString = sc.nextLine().trim();
          sales = Long.parseLong(salesString);
          break;
        case "</dataitem>":
          //create new movie object and add it to the list
          if (!(title == null || sales == null)) {
            movieList.add(new Movie(title, sales));
          }
          title = null;
          sales = null;
          break;
      }
    }
    sc.close();
    return movieList;
  }
}