package ie.atu.serialization;

import java.io.*;

public class Main4 {
    public static void main(String[] args) {
        UserProfile user = new UserProfile("johndoe", "secret123", "john@example.com");
        System.out.println("Original User: " + user);
        
        // Serialize
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("resources/user.ser"))) {
            out.writeObject(user);
            System.out.println("User has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Deserialize
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("resources/user.ser"))) {
            UserProfile deserializedUser = (UserProfile) in.readObject();
            System.out.println("User has been deserialized");
            System.out.println("Deserialized User: " + deserializedUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}