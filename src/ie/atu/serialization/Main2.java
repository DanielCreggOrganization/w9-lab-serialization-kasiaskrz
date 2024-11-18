package ie.atu.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 19.99));
        books.add(new Book("1984", "George Orwell", 15.99));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 12.99));
        
        System.out.println("Original catalog:");
        books.forEach(System.out::println);
        
        // Serialize list
        serializeBooks(books, "resources/library.ser");
        
        // Deserialize list
        List<Book> loadedBooks = deserializeBooks("resources/library.ser");
        
        System.out.println("\nDeserialized catalog:");
        loadedBooks.forEach(System.out::println);
    }
    
    private static void serializeBooks(List<Book> books, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            out.writeObject(books);
            System.out.println("\nCatalog has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static List<Book> deserializeBooks(String filename) {
        List<Book> books = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filename))) {
            books = (List<Book>) in.readObject();
            System.out.println("Catalog has been deserialized");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }
}