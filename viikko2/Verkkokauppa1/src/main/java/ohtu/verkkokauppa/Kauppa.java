package ohtu.verkkokauppa;

public class Kauppa {

    private Varasto2 varasto;
    private Pankki2 pankki;
    private Ostoskori ostoskori;
    private Viitegeneraattori2 viitegeneraattori;
    private String kaupanTili;

    public Kauppa(Varasto2 v, Pankki2 p, Viitegeneraattori2 vg) {
        varasto = v;
        pankki = p;
        viitegeneraattori = vg;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}