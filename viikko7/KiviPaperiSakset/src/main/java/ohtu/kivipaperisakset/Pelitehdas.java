/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author Elina
 */
public class Pelitehdas {

    void luoPeli(String vastaus) {
        if (vastaus.endsWith("a")) {
            KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja();
            kaksinpeli.pelaa();
        } else if (vastaus.endsWith("b")) {
            KPSTekoaly yksinpeli = new KPSTekoaly();
            yksinpeli.pelaa();
        } else if (vastaus.endsWith("c")) {
            KPSParempiTekoaly pahaYksinpeli = new KPSParempiTekoaly();
            pahaYksinpeli.pelaa();
        }
    }

    boolean lopetetaan(String vastaus) {
        return !("a".equals(vastaus) || "b".equals(vastaus) || "c".equals(vastaus));
    }
}
