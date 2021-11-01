package BibliotekaFilmow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Film{
    private String nazwaFilmu;
    private List<Aktor> listaAktorow = new ArrayList<>();
    private Rezyser rezyserFilmu;
    private double kosztFilmu;
    private LocalDate dataPremiery;

    public Film(String nazwaFilmu, LocalDate dataPremiery, Rezyser rezyser) {
        this.nazwaFilmu = nazwaFilmu;
        this.dataPremiery = dataPremiery;
        this.rezyserFilmu = rezyser;
    }

    public String getNazwaFilmu() {
        return nazwaFilmu;
    }

    public void setNazwaFilmu(String nazwaFilmu) {
        this.nazwaFilmu = nazwaFilmu;
    }

    public LocalDate getDataPremiery() {
        return dataPremiery;
    }

    public void setDataPremiery(LocalDate dataPremiery) {
        this.dataPremiery = dataPremiery;
    }

    public void getListaAktorow (){
        System.out.println("Lista aktorow");
        for(int i=0; i<listaAktorow.size(); i++){
            System.out.println("----------");
            System.out.println("" + listaAktorow.get(i).getImieAktora() + listaAktorow.get(i).getNazwiskoAktora());
        }
    }

    public List<Aktor> listaAktorow(){
        return this.listaAktorow;
    }
    public void setListaAktorow (Aktor aktor){
        this.listaAktorow.add(aktor);
    }

    public void setRezyserFilmu (Rezyser rezyser){
        this.rezyserFilmu = rezyser;
    }

    public void getRezyserFilmu (){
        System.out.println("-------");
        System.out.println("Rezyser: " + this.rezyserFilmu.getImieRezysera() + this.rezyserFilmu.getNazwiskoRezysera());
    }

    public void setKosztFilmu (){
        double kosztAktorow = 0.0;
        for(int i=0; i<listaAktorow.size(); i++){
            kosztAktorow += listaAktorow.get(i).getPensjaAktora();
        }
        this.kosztFilmu = kosztAktorow + this.rezyserFilmu.getPensjaRezysera();
    }

    public double getKosztFilmu (){
        return this.kosztFilmu;
    }

    @Override
    public String toString() {
        return "Film{" +
                "nazwaFilmu='" + nazwaFilmu + '\'' +
                ", listaAktorow=" + listaAktorow +
                ", rezyserFilmu=" + rezyserFilmu +
                ", kosztFilmu=" + kosztFilmu +
                ", dataPremiery=" + dataPremiery +
                '}';
    }
}
