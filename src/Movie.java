/**
 * The Movie class represents a movie object with a title and sales data. The title of the movie
 * is a String, and the sales are a long integer. The class provides a constructor to create a
 * new movie object with the specified title and sales. It also provides methods to retrieve the
 * title and sales of the movie.
 */
public class Movie {
  private String title;
  private long sales;

  public Movie (String title, long sales) {
    this.title = title;
    this.sales = sales;
  }

  public String getTitle() {
    return title;
  }

  public long getSales() {
    return sales;
  }
}