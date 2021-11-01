package BibliotekaFilmow;

public class Rezyser {
    private String imieRezysera;
    private String nazwiskoRezysera;
    private double pensjaRezysera;

    public Rezyser(String imieRezysera, String nazwiskoRezysera, double pensjaRezysera) {
        this.imieRezysera = imieRezysera;
        this.nazwiskoRezysera = nazwiskoRezysera;
        this.pensjaRezysera = pensjaRezysera;
    }

    public Rezyser() {

    }

    public String getImieRezysera() {
        return imieRezysera;
    }

    public void setImieRezysera(String imieRezysera) {
        this.imieRezysera = imieRezysera;
    }

    public String getNazwiskoRezysera() {
        return nazwiskoRezysera;
    }

    public void setNazwiskoRezysera(String nazwiskoRezysera) {
        this.nazwiskoRezysera = nazwiskoRezysera;
    }

    public double getPensjaRezysera() {
        return pensjaRezysera;
    }

    public void setPensjaRezysera(double pensjaRezysera) {
        this.pensjaRezysera = pensjaRezysera;
    }
}
