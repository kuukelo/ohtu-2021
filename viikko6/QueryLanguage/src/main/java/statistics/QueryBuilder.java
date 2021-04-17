/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

/**
 *
 * @author Elina
 */
public class QueryBuilder {
    Matcher m;
    
    public QueryBuilder() {
        m = new All();
    }
    
    public QueryBuilder playsIn(String team) {
        this.m = new And(m, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.m = new And(m, new HasAtLeast(value, category));
        return this;        
    }

    public Matcher build() {
        return m;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.m = new And(m, new HasFewerThan(value, category));
        return this;
    }
    
}
