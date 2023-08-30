package com.details.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.details.adminservice.entities.Bus;
import org.springframework.stereotype.Repository;
@Repository
public interface BusRepository extends JpaRepository<Bus,String> {
}