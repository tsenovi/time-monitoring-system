package parse;

import java.io.*;

public class IOcontroller {

    public static <T> T loadFile(String fileName){
        T data = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            data = (T) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while reading from file!");
        }
        return data;
    }

    public static <T> void overwriteFile(String fileName, T data){
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName))) {
            os.writeObject(data);
        } catch (IOException e) {
            System.out.println("Error while writing to file!");
        }
    }
}
