package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KiviPaperiSakset {

    private static final Scanner scanner = new Scanner(System.in);
    private Tekoaly tekoaly;
    
    public KPSTekoaly() {
        this.tekoaly = new Tekoaly();
    }

    @Override
    protected String toisenSiirto(String ekanSiirto) {
        String siirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        return siirto;
    }
}