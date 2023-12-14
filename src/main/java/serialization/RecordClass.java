package serialization;

import java.io.Serializable;

public record RecordClass(String name, int age, String address) implements Serializable {
}
