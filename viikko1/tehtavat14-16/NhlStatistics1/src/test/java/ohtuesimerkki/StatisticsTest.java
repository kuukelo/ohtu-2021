/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elina
 */
public class StatisticsTest {
    
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka k‰ytt‰‰ "stubia"
        stats = new Statistics(this.readerStub);
    }  
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearch() {
        String name = "Semenko";
        Player expResult = stats.search(name);
        assertEquals(expResult.getAssists(), 12);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSearch2() {
        String name = "V‰‰r‰";
        Player expResult = stats.search(name);
        assertEquals(expResult, null);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {
        String teamName = "PIT";
        List<Player> expResult = stats.team(teamName);
        assertEquals(expResult.size(), 1);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
        System.out.println("topScorers");
        int howMany = 1;
        List<Player> expResult = stats.topScorers(howMany);
        assertEquals(expResult.get(0).getName(), "Gretzky");
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
