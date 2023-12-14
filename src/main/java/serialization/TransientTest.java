package serialization;


import util.LeoUtils;

import java.io.*;

public class TransientTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person leo = new Person ("leo", "secretpass", 30, 1000000);
        LeoUtils.writeToFile (leo, "leofile");
        Person another = (Person) LeoUtils.readFromFile ("leofile");
        System.out.println (another.getName () + " " + another.getPassword () + " " + another.getAge () + " " + another.getWage ());
    }
}

class Person implements Serializable {
    private String name;

    private transient String password;

    private transient int age;

    private transient int wage;

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public Person(String name, String password, int age, int wage) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject ();
        oos.writeInt (age);
        oos.writeInt (wage);
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject ();
        age = ois.readInt ();
        wage = ois.readInt ();
    }
}