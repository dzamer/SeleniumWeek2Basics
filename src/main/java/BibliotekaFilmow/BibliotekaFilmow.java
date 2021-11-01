package BibliotekaFilmow;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class BibliotekaFilmow {
    public List<Film> bibliotekaFilmow = new LinkedList<>();


    public void addNewFilm (String nazwaFilmu, LocalDate dataProdukcji, Rezyser rezyser){
        this.bibliotekaFilmow.add(new Film(nazwaFilmu, dataProdukcji, rezyser));
    }

    public Film lookForFilmName (String nazwaFilmu){
        Film getFilm = null;
        for(int i=0; i< bibliotekaFilmow.size();i++){
            if(bibliotekaFilmow.get(i).getNazwaFilmu().equals(nazwaFilmu)){
                getFilm = bibliotekaFilmow.get(i);
            }
        }
        return getFilm;
    }

    public double filmProductionCosts(String nazwaFilmu){
        double kosztFilmu = 0.0;
        for(int i=0;i<bibliotekaFilmow.size(); i++){
            if(bibliotekaFilmow.get(i).getNazwaFilmu().equals(nazwaFilmu)){
                bibliotekaFilmow.get(i).setKosztFilmu();
                kosztFilmu = bibliotekaFilmow.get(i).getKosztFilmu();
                System.out.println("Koszt produkcji " + bibliotekaFilmow.get(i).getNazwaFilmu() + " wynosi: "+kosztFilmu);
            }
        }
        return kosztFilmu;
    }

    public void whereActorPlayed(String imieAktora, String nazwiskoAktora){
        for(int i=0; i<bibliotekaFilmow.size(); i++) {
            List<Aktor> listaAktorow = bibliotekaFilmow.get(i).listaAktorow();
            for (int j = 0; j < listaAktorow.size(); j++) {
                if ((listaAktorow.get(j).getImieAktora().equals(imieAktora)) &&
                        (listaAktorow.get(j).getNazwiskoAktora().equals(nazwiskoAktora))) {
                    System.out.println("W filmie: " + bibliotekaFilmow.get(i).getNazwaFilmu() + " gral: " +
                            listaAktorow.get(j).getImieAktora() + " " + listaAktorow.get(j).getNazwiskoAktora());
                }
            }
        }
    }

    public void filmsInRange(LocalDate dataPoczatkowa, LocalDate dataKoncowa){
        for(int i=0; i<bibliotekaFilmow.size();i++){
            if(bibliotekaFilmow.get(i).getDataPremiery().isBefore(dataKoncowa)&&
                    bibliotekaFilmow.get(i).getDataPremiery().isAfter(dataPoczatkowa)){
                System.out.println("Film: " + bibliotekaFilmow.get(i).getNazwaFilmu() + " miesci sie w przedziale dat.");

            }
        }
    }
}
