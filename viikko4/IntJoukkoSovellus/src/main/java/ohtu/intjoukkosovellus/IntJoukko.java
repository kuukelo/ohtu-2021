
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5,
                            OLETUSKASVATUS = 5; 

    private int kasvatuskoko;
    private int[] ljono; 
    private int alkioidenLkm; 

    public IntJoukko() {
        this.ljono = new int[KAPASITEETTI];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti ei saa olla negatiivinen");
        }
        this.ljono = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti ei saa olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko ei saa olla negatiivinen");
        }
        this.ljono = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            kasvata();
            return true;
        }
        return false;
    }
    
    public void kasvata() {
        if (alkioidenLkm % ljono.length == 0) {
            ljono = Arrays.copyOf(ljono, ljono.length+kasvatuskoko);
        }
    }
    
    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                ljono[i] = 0;
                for (int i2 = i+1; i2 < alkioidenLkm; i2++) {
                    ljono[i] = ljono[i2];
                }
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String vastaus = "{";
        
        for (int i = 0; i < alkioidenLkm; i++) {
            vastaus += ljono[i] + ", ";
        }
        
        if (vastaus.length() > 1) {
            vastaus = vastaus.substring(0, vastaus.length()-2);
        }
        
        return vastaus + "}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int i = 0; i < a.getAlkioidenLkm(); i++) {
            x.lisaa(a.getLjono()[i]);
        }
        for (int i = 0; i < b.getAlkioidenLkm(); i++) {
            x.lisaa(b.getLjono()[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        for (int i = 0; i < a.getAlkioidenLkm(); i++) {
            for (int j = 0; j < b.getAlkioidenLkm(); j++) {
                if (a.getLjono()[i] == b.getLjono()[j]) {
                    y.lisaa(b.getLjono()[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        for (int i = 0; i < a.getAlkioidenLkm(); i++) {
            z.lisaa(a.getLjono()[i]);
        }
        for (int i = 0; i < b.getAlkioidenLkm(); i++) {
            z.poista(b.getLjono()[i]);
        }
        return z;
    }

    public int[] getLjono() {
        return ljono;
    }

    public int getAlkioidenLkm() {
        return alkioidenLkm;
    }
    
}
