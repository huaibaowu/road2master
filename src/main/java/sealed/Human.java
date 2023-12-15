package sealed;

sealed class Human permits Chinese, European {
    public void print(){
        System.out.println ("default human");
    }
}
