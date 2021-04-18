/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author Elina
 */
public abstract class KiviPaperiSakset {
    private static final Scanner scanner = new Scanner(System.in);
    
    // t‰m‰ on ns template metodi
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        String ekanSiirto = ensimmaisenSiirto();
        String tokanSiirto = toisenSiirto(ekanSiirto);
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari + "\n");
            
            ekanSiirto = ensimmaisenSiirto();
            tokanSiirto = toisenSiirto(ekanSiirto);    
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    protected String ensimmaisenSiirto() {
        System.out.println("Ensimm√§isen pelaajan siirto: ");
        String vastaus = scanner.nextLine();
        return vastaus;
    }

    // t‰m‰ on abstrakti metodi sill‰ sen toteutus vaihtelee eri pelityypeiss‰
    abstract protected String toisenSiirto(String ekanSiirto);
    
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
