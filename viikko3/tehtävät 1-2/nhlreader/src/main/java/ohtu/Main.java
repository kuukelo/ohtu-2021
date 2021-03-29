/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author mluukkai
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        ArrayList<Player> pelaajat = new ArrayList();
        for (Player player : players) {
            pelaajat.add(player);
        }
        
        Collections.sort(pelaajat);
        
        System.out.println("Players from FIN " + LocalDateTime.now());
        System.out.println("");
        for (Player player : pelaajat) {
            if (player.getMaa().equals("FIN")) {
                if(player.getName().length()>15) {
                    System.out.print(player.getName() + "\t");
                } else {
                    System.out.print(player.getName() + "\t\t");
                }
//                System.out.print(player.getName());
                System.out.println(player);
            }
            
        }   
    }
}
