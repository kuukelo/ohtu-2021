
package statistics.matcher;

import statistics.Player;

public class PlaysIn implements Matcher {
    private String team;

    public PlaysIn(String team) {
        this.team = team;
    }        
    
    @Override
    public boolean matches(Player p) {
//        System.out.println("Ollaan " + team);
        return p.getTeam().contains(team);
    }
    
}
