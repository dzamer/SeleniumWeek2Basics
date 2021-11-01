package BibliotekaFilmow;

public class Aktor {
    private String imieAktora;
    private String nazwiskoAktora;
    private double pensjaAktora;

    public Aktor(String imieAktora, String nazwiskoAktora, double pensjaAktora) {
        this.imieAktora = imieAktora;
        this.nazwiskoAktora = nazwiskoAktora;
        this.pensjaAktora = pensjaAktora;
    }

    public String getImieAktora() {
        return imieAktora;
    }

    public void setImieAktora(String imieAktora) {
        this.imieAktora = imieAktora;
    }

    public String getNazwiskoAktora() {
        return nazwiskoAktora;
    }

    public void setNazwiskoAktora(String nazwiskoAktora) {
        this.nazwiskoAktora = nazwiskoAktora;
    }

    public double getPensjaAktora() {
        return pensjaAktora;
    }

    public void setPensjaAktora(double pensjaAktora) {
        this.pensjaAktora = pensjaAktora;
    }
}
