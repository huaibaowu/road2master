package sealed;

public class Main {
    public static void main(String[] args) {
        Cantonese cantonese = new Cantonese ();
        Chinese chinese = new Chinese ();
        European european = new European ();
        cantonese.print ();
        chinese.print ();
        european.print ();
    }
}
