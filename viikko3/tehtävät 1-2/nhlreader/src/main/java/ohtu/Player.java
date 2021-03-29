
package ohtu;

import java.util.Comparator;

public class Player implements Comparable<Player>{
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;
    

    public void setName(String name, String nationality, int assists, int goals, String team) {
        this.name = name;
        this.team = team;
        this.nationality = nationality;
        this.assists = assists;
        this.goals = goals;
    }

    public String getName() {
        return this.name;
    }
    public String getMaa() {
        return this.nationality;
    }
    public int getPisteet() {
        return this.goals + this.assists;
    }
    
    @Override
    public String toString() {
        return team + "\t" + goals + " + " + assists + " = " + (goals+assists);
    }

    @Override
    public int compareTo(Player o) {
        return o.getPisteet() - getPisteet();
    }
      
}
