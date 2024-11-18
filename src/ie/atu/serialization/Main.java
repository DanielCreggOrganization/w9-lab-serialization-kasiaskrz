package ie.atu.serialization;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        //initialize movie object
        Movie movie = null;
        
        // Create a movie with exception handling for invalid year
        try {
            movie = new Movie("Kung Fu Panda", "John Doe", 2015, 8.5);
            System.out.println("Original movie: " + movie);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating movie: " + e.getMessage());
            return; // Exit early if movie creation failed
        }
    
        // Serialize
        try (FileOutputStream fileOut = new FileOutputStream("resources/movie.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(movie);
                System.out.println("Movie has been serialized.");
            } catch (IOException e) {
                e.printStackTrace();
    }

    // Deserialize
    try (FileInputStream fileIn = new FileInputStream("resources/movie.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Movie deserializedMovie = (Movie) in.readObject();
            System.out.println("Movie has been deserialized");
            System.out.println("Deserialized Movie: " + deserializedMovie);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
