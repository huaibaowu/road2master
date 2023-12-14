package serialization;

import util.LeoUtils;

import java.io.IOException;

public class InheritanceSerializationTest {
    public static void main(String[] args) {
        SubClass sub = new SubClass ("S1", 001, "This is S1");
        try {
            LeoUtils.writeToFile (sub, "./subclass.ser");
        } catch (IOException e) {
            e.printStackTrace ();
            throw new RuntimeException (e);
        }
        SubClass temp;
        try {
            temp = (SubClass) LeoUtils.readFromFile ("./subclass.ser");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException (e);
        }
        System.out.println (temp.toString ());
    }
}
