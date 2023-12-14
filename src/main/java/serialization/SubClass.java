package serialization;

import java.io.*;


public class SubClass extends SuperClass implements Serializable, ObjectInputValidation {

    private String description;

    public SubClass(String name, int id, String description) {
        super (name, id);
        this.description = description;
    }

    public SubClass() {
        super ();
    }

    @Override
    public String toString() {
        return "SubClass{" +
                "name=[" + getName () + "] " +
                "id=[" + getId () + "] " +
                "description=[" + description + "] " +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        if (description == null || description.isEmpty ()) {
            throw new InvalidObjectException ("Description can not be empty or null!");
        }
        if (getId () < 0) {
            throw new InvalidObjectException ("Id must be greater than zero!");
        }
        if (getName () == null || "".equals (getName ())) {
            throw new InvalidObjectException ("Name can not be empty or null!");
        }
    }
    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject ();
        oos.writeInt (getId ());
        oos.writeObject (getName ());
    }
    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject ();
        setId (ois.readInt ());
        setName ((String) ois.readObject ());
    }
}
