package com.details.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.details.adminservice.entities.BusRoute;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRouteRepository extends JpaRepository<BusRoute,String>{

}



