package BibliotekaFilmow;

import java.time.LocalDate;

public class CaleZadanie {
    public static void main(String[] args) {
        BibliotekaFilmow biblioteka = new BibliotekaFilmow();

        Rezyser rezyser1 = new Rezyser("Jan", "Kowalski",25000.0);
        Rezyser rezyser2 = new Rezyser("Zbigniew","nowak", 1525.21);
        Rezyser rezyser3 = new Rezyser("Miroslaw","Kowal",2512.01);

        biblioteka.addNewFilm("Nowy film jeden", LocalDate.of(2000,02,10),rezyser1);
        biblioteka.addNewFilm("Nowy film dwa", LocalDate.of(2018,11,10),rezyser2);
        biblioteka.addNewFilm("Stary film", LocalDate.of(2012,05,01),rezyser3);

        Aktor nowyAktor1 = new Aktor("Jan","Kowalski",256.21);
        Aktor nowyAktor2 = new Aktor("Zbigniew", "Nowak", 291.21);
        Aktor nowyAktor3 = new Aktor("Marian", "Kowa",890.12);
        Aktor nowyAktor4 = new Aktor("Joanna", "Tak", 7821.12);
        biblioteka.bibliotekaFilmow.get(0).setListaAktorow(nowyAktor4);
        biblioteka.bibliotekaFilmow.get(0).setListaAktorow(nowyAktor1);

        biblioteka.bibliotekaFilmow.get(1).setListaAktorow(nowyAktor2);
        biblioteka.bibliotekaFilmow.get(1).setListaAktorow(nowyAktor4);

        biblioteka.bibliotekaFilmow.get(2).setListaAktorow(nowyAktor3);

        System.out.println(biblioteka.lookForFilmName("Nowy film dwa"));

        biblioteka.filmProductionCosts("Stary film");

        biblioteka.filmsInRange(LocalDate.of(2011,10,02),LocalDate.of(2022,10,05));

        biblioteka.whereActorPlayed("Joanna", "Tak");

        System.out.println(biblioteka.bibliotekaFilmow.get(0).getDataPremiery());
        System.out.println(biblioteka.bibliotekaFilmow.get(1).getDataPremiery());
        System.out.println(biblioteka.bibliotekaFilmow.get(2).getDataPremiery());

    }
}
