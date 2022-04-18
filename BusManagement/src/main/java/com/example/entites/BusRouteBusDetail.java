package com.example.entites;

import javax.persistence.CascadeType;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "busroute_busdetail")
public class BusRouteBusDetail extends Auditable<String>{
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "busroute_busdetail_id")
    private Long busRouteBusDetailId;

    @OneToMany(targetEntity = BusRouteBusDetail.class,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "busdepo_route_id")
    private List<BusDepoRoute> busDepoRouteId = new ArrayList<>();

    

    @OneToMany(targetEntity = BusRouteBusDetail.class,cascade = CascadeType.ALL, 
            fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_detail_id")
    private List<BusDetail> busDetailId = new ArrayList<>();



    public Long getBusRouteBusDetailId() {
        return busRouteBusDetailId;
    }



    public void setBusRouteBusDetailId(Long busRouteBusDetailId) {
        this.busRouteBusDetailId = busRouteBusDetailId;
    }



    public List<BusDepoRoute> getBusDepoRouteId() {
        return busDepoRouteId;
    }



    public void setBusDepoRouteId(List<BusDepoRoute> busDepoRouteId) {
        this.busDepoRouteId = busDepoRouteId;
    }



    public List<BusDetail> getBusDetailId() {
        return busDetailId;
    }



    public void setBusDetailId(List<BusDetail> busDetailId) {
        this.busDetailId = busDetailId;
    }



    @Override
    public String toString() {
        return "BusRouteBusDetail [busDepoRouteId=" + busDepoRouteId + ", busDetailId=" + busDetailId
                + ", busRouteBusDetailId=" + busRouteBusDetailId + "]";
    }

  
    
    
}
