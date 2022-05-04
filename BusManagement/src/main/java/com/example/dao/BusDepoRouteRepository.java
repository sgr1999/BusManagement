package com.example.dao;

import java.util.List;

import com.example.Model.BusDepoRouteModel;
import com.example.entites.BusDepoRoute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusDepoRouteRepository extends JpaRepository<BusDepoRoute, Long>{
    
  
}
