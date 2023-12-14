package util;

import java.io.*;

public class LeoUtils {
    public static void writeToFile(Object obj, String path) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (path));
        oos.writeObject (obj);
        oos.flush ();
        oos.close ();
    }

    public static Object readFromFile(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream (new FileInputStream (path));
        return ois.readObject ();
    }
}
