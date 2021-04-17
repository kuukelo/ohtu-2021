/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Elina
 */
public class Summa extends Komento {
    private int viimeisin;
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        int tulos = Integer.parseInt(tuloskentta.getText());
        int syote = Integer.parseInt(syotekentta.getText());
        tulos += syote;
        tuloskentta.setText(String.valueOf(tulos));
        syotekentta.setText("");
        viimeisin = syote;
    }

    @Override
    public void peru() {
        int tulos = Integer.parseInt(tuloskentta.getText());
        tulos = tulos - viimeisin;
        tuloskentta.setText(String.valueOf(tulos));
        syotekentta.setText("");
    }
    
}
