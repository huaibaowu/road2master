package demo;

public record RecordCycle(int radius) {
    public RecordCycle {
        if (radius < 0) {
            throw new IllegalArgumentException("The radius of a circle can not be negative [" + radius + "]");
        }
    }
}
