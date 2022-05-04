package com.example.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "busroute_busdetail")
public class BusRouteBusDetail extends Auditable<String>{
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "busroute_busdetail_id")
    private Long busRouteBusDetailId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "busdepo_route_id", unique = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BusDepoRoute busDepoRouteId;

    

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_detail_id", unique = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BusDetail busDetailId;



    public Long getBusRouteBusDetailId() {
        return busRouteBusDetailId;
    }



    public void setBusRouteBusDetailId(Long busRouteBusDetailId) {
        this.busRouteBusDetailId = busRouteBusDetailId;
    }

    public BusDepoRoute getBusDepoRouteId() {
        return busDepoRouteId;
    }

    public void setBusDepoRouteId(BusDepoRoute busDepoRouteId) {
        this.busDepoRouteId = busDepoRouteId;
    }


    public BusDetail getBusDetailId() {
        return busDetailId;
    }



    public void setBusDetailId(BusDetail busDetailId) {
        this.busDetailId = busDetailId;
    }



    @Override
    public String toString() {
        return "BusRouteBusDetail [busDepoRouteId=" + busDepoRouteId + ", busDetailId=" + busDetailId
                + ", busRouteBusDetailId=" + busRouteBusDetailId + "]";
    }

}
