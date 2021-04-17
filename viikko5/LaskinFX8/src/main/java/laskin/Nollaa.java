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
public class Nollaa extends Komento {
    private int viimeisin;
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {    
        viimeisin = Integer.parseInt(tuloskentta.getText());
        this.tuloskentta.setText("0");
        this.syotekentta.setText("");
    }

    @Override
    public void peru() {
        tuloskentta.setText(String.valueOf(viimeisin));
        syotekentta.setText("");
    }
    
}
