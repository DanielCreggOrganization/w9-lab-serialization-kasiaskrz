package ie.atu.serialization;

import java.io.Serializable;
import java.time.Year;

public class Movie implements Serializable {
    private String title;
    private String director;
    private int year;
    private double rating;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;

        int currentYear = Year.now().getValue();
        if (year < 1900 || year > currentYear) {
            throw new IllegalArgumentException("Year must be between 1900 and " + currentYear);
        }

        this.year = year;
        this.rating = rating;
    }
    
    @Override
    public String toString() {
        return "Movie{title='" + title + "', director='" + director + "', year='" + year + "', rating='" + rating + "'}";
    }
}
