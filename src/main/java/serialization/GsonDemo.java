package serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GsonDemo {
    public static void main(String[] args) {
        RecordClass rc = new RecordClass ("leo", 30, "SZ");
        SuperClass sc = new SuperClass ("leo", 1);
        Gson gson = new Gson ();
        String str = gson.toJson (sc);
        String str2 = gson.toJson (rc);
        System.out.println (str);
        System.out.println (str2);
    }
}
