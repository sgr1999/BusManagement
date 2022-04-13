package com.example.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "state_id")
    private Long stateId;

    @Column(name = "state_code")
    private String stateCode;

    @Column(name = "state_name")
    private String stateName;

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
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
