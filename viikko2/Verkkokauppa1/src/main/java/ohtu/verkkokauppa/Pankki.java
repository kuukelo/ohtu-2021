package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

@Component
public class Pankki implements Pankki2 {

    public Kirjanpito kirjanpito;

    public Pankki(Kirjanpito k) {
        kirjanpito = k;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
