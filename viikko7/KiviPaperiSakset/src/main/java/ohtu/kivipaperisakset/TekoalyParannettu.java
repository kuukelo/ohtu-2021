
package ohtu.kivipaperisakset;

// "Muistava tekoäly"

public class TekoalyParannettu {
    private String[] muisti;
    private int vapaaMuistiIndeksi;
    private int k;
    private int p;
    private int s;
    
    public TekoalyParannettu(int muistinKoko) {
        muisti = new String[muistinKoko];
        vapaaMuistiIndeksi = 0;
        this.k = 0;
        this.p = 0;
        this.s = 0;
    }
  
  public void asetaSiirto(String siirto) {
    // jos muisti täyttyy, unohdetaan viimeinen alkio
    if(vapaaMuistiIndeksi == muisti.length) {
        muistiTaysi();
    }
    
    muisti[vapaaMuistiIndeksi] = siirto;    
    vapaaMuistiIndeksi++;
  }

  
  public String annaSiirto() {
    if(vapaaMuistiIndeksi < 2) {
        return "k";
    }
    
    laskesiirrot();
    
    
    // Tehdään siirron valinta esimerkiksi seuraavasti;
    // - jos kiviä eniten, annetaan aina paperi
    // - jos papereita eniten, annetaan aina sakset
    // muulloin annetaan aina kivi
    if(k > p && k > s) {
        return "p";
    }
    else if (p > k && p > s) {
        return "s";
    }
    else {
        return "k";
    }
    
    // Tehokkaampiakin tapoja löytyy, mutta niistä lisää 
    // Johdatus Tekoälyyn kurssilla!
  }

    private void laskesiirrot() {
        k = 0;
        p = 0;
        s = 0;
        String viimeisinSiirto = muisti[vapaaMuistiIndeksi - 1];
        for(int i = 0; i < vapaaMuistiIndeksi - 1; i++) {
            if(viimeisinSiirto.equals(muisti[i])) {
                String seuraava = muisti[i+1];

                if("k".equals(seuraava)) {
                    k++;
                }
                else if("p".equals(seuraava)) {
                    p++;
                }
                else {
                    s++;
                }        
            }
        }
    }

    private void muistiTaysi() {
        for(int i = 1; i < muisti.length; i++) {
            muisti[i-1] = muisti[i];
        }
      
        vapaaMuistiIndeksi--;
    }
}