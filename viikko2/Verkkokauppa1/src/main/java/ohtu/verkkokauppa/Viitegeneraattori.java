package ohtu.verkkokauppa;

public class Viitegeneraattori implements Viitegeneraattori2 {
    
    private int seuraava;
    
    public Viitegeneraattori(){
        seuraava = 1;    
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
