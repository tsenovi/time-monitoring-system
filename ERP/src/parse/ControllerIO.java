package parse;

import java.io.*;

public class ControllerIO {

    @SuppressWarnings("unchecked")
    public static <T> T loadFile(String fileName) {
        T data = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            data = (T) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while reading from file!");
        }
        return data;
    }

    public static <T> void overwriteFile(String fileName, T data) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            System.out.println("Error while writing to file!");
        }
    }
}
