package serialization;

import util.LeoUtils;

import java.io.IOException;

public class RecordSerializationTest {
    public static void main(String[] args) {
        String filePath = "./temp/record.ser";
        RecordClass rc = new RecordClass ("leo", 30, "SZ");
        try {
            LeoUtils.writeToFile (rc, filePath);
        } catch (IOException e) {
            e.printStackTrace ();
        }
        try {
            RecordClass temp = (RecordClass) LeoUtils.readFromFile (filePath);
            System.out.println (temp.name () + " " + temp.address ());
            System.out.println (temp);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace ();
        }

    }
}
