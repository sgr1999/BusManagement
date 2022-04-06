package com.example.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BusMaster {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long busId;
    private String depo;
    private String whereFrom;
    private String whereTo;

    
    public long getBusId() {
        return busId;
    }
    public void setBusId(long busId) {
        this.busId = busId;
    }
    public String getDepo() {
        return depo;
    }
    public void setDepo(String depo) {
        this.depo = depo;
    }
    public String getWhereFrom() {
        return whereFrom;
    }
    public void setWhereFrom(String whereFrom) {
        this.whereFrom = whereFrom;
    }
    public String getWhereTo() {
        return whereTo;
    }
    public void setWhereTo(String whereTo) {
        this.whereTo = whereTo;
    }
    @Override
    public String toString() {
        return "BusMaster [busId=" + busId + ", depo=" + depo + ", whereFrom=" + whereFrom + ", whereTo=" + whereTo
                + "]";
    }
    
    
}
