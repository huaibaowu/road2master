package exceptions;

public class ChainedException {
    public static void main(String[] args) {
        try {
            NumberFormatException nfe = new NumberFormatException ("Exception");
            nfe.initCause (new NullPointerException ("Causual Exception"));
            throw nfe;
        } catch (NumberFormatException e) {
            System.out.println (e);
            System.out.println (e.getCause ());
        }
    }
    void myMethod() {
        int foo;
        try {
            foo = getResults ();
        } catch (Exception e) {
            return;
        }
        int bar = foo;
    }

    private int getResults() {
        return 0;
    }
}
