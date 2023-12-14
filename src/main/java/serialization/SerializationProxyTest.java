package serialization;

import util.LeoUtils;

import java.io.IOException;

public class SerializationProxyTest {
    public static void main(String[] args) {
        String fileName = "./temp/data.ser";

        Data data = new Data ("This is secret");

        try {
            LeoUtils.writeToFile (data, fileName);
        } catch (IOException e) {
            e.printStackTrace ();
        }

        try {
            Data newData = (Data) LeoUtils.readFromFile (fileName);
            System.out.println (newData);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace ();
        }
    }

}
