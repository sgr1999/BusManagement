package com.example.entites;

import javax.persistence.*;

@Entity
public class State {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long stateId;
    private String stateCode;
    private String stateName;
    
    public long getStateId() {
        return stateId;
    }
    public void setStateId(long stateId) {
        this.stateId = stateId;
    }
    public String getStateCode() {
        return stateCode;
    }
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "State [stateCode=" + stateCode + ", stateId=" + stateId + ", stateName=" + stateName + "]";
    }

    
}
