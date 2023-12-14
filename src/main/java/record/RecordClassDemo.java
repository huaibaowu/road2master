package demo;

public class TestCase {
    public static void main(String[] args) {
        PlainCircle pc1 = new PlainCircle(10);
        PlainCircle pc2 = new PlainCircle(10);
        System.out.println("pc1.equals(pc2)? " + pc1.equals(pc2));

        RecordCycle rc1 = new RecordCycle(10);
        RecordCycle rc2 = new RecordCycle(10);
        System.out.println("rc1.equals(rc2)? " + rc1.equals(rc2));
//        RecordCycle rc3 = new RecordCycle(-10);
        System.out.println(rc1.radius());
    }
}
