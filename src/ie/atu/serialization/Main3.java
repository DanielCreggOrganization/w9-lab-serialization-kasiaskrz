package ie.atu.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Kung Fu Panda", "John Doe", 2015, 8.5));
        movies.add(new Movie("Kung Fu Panda 2", "John Doe", 2016, 8));
        movies.add(new Movie("Kung Fu Panda 3", "John Doe", 2017, 9));
        movies.add(new Movie("Kung Fu Panda 4", "John Doe", 2018, 7));
        movies.add(new Movie("Kung Fu Panda 5", "John Doe", 2021, 5));

        
        System.out.println("Original catalog:");
        movies.forEach(System.out::println);
        
        // Serialize list
        serializeMovies(movies, "resources/library.ser");
        
        // Deserialize list
        List<Movie> loadedMovies = deserializeMovies("resources/library.ser");
        
        System.out.println("\nDeserialized catalog:");
        loadedMovies.forEach(System.out::println);
    }
    
    private static void serializeMovies(List<Movie> movies, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            out.writeObject(movies);
            System.out.println("\nCatalog has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static List<Movie> deserializeMovies(String filename) {
        List<Movie> movies = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filename))) {
            movies = (List<Movie>) in.readObject();
            System.out.println("Catalog has been deserialized");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return movies;
    }
}