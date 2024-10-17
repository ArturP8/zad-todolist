public class Zadanie {
    private String nazwa;
    private String opis;
    private boolean zakonczone;

    public Zadanie(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.zakonczone = false;
    }

    public void oznaczJakoZakonczone() {
        this.zakonczone = true;
    }

    public boolean czyZakonczone() {
        return zakonczone;
    }

    @Override
    public String toString() {
        String status = (zakonczone ? "(X)" : "( )");
        return status + " " + nazwa + ": " + opis;
    }
}
