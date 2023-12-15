package sealed;

non-sealed class Chinese extends Human {
    @Override
    public void print() {
        System.out.println ("I am a Chinese evolved from Human");
    }
}
