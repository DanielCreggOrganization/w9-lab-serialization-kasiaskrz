package ie.atu.serialization;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main5 {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date lastAccessTime = null;

        try {
            lastAccessTime = dateFormat.parse("01.01.2021");
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        // Create a BankAccount object

        BankAccount user = new BankAccount("1234567890", "John Doe", 100, "0000", lastAccessTime);
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
            BankAccount deserializedUser = (BankAccount) in.readObject();
            System.out.println("User has been deserialized");
            System.out.println("Deserialized User: " + deserializedUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}