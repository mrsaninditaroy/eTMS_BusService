package com.details.adminservice.service.impl;

import com.details.adminservice.entities.Bus;
import com.details.adminservice.entities.BusRoute;
import com.details.adminservice.service.AdminService;
import com.details.adminservice.repository.*;
import com.details.adminservice.repository.BusRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServicesImpl implements AdminService {

	@Autowired
	private BusRouteRepository busRouteRepository;
	
	@Autowired
	private BusRepository busRepository;
	
	@Override
	public Bus createBus(Bus bus) {
		return  busRepository.save(bus) ;
	}

	@Override
	public BusRoute createBusRoute(BusRoute busRoute) {
		
		return busRouteRepository.save(busRoute) ;
	}
	
	@Override
	public List<Bus> getAllBuses() {
		List<Bus> buses = busRepository.findAll();
		return buses;
	}

	@Override
	public List<BusRoute> getAllBusRoutes() {		
		
		List<BusRoute> busRoutes = busRouteRepository.findAll();
		return busRoutes;
	}
	
	@Override
	public Bus updateBus(@RequestBody Bus bus) {
		
		Bus existingBus= busRepository.findById(bus.getBusid()).get();
		existingBus.setBusMovement(bus.getBusMovement());
		existingBus.setBusStatus(bus.getBusStatus());
		existingBus.setBusStoppages(bus.getBusStoppages());
		existingBus.setSeats(bus.getSeats());
		
		Bus updatedBus = busRepository.save(existingBus);
		
	    return updatedBus;
	}

	@Override
	public BusRoute updateBusRoute(@RequestBody BusRoute busRoute) {
		
		BusRoute existingBusRoute= busRouteRepository.findById(busRoute.getRouteid()).get();
		existingBusRoute.setDestination(busRoute.getDestination());
		existingBusRoute.setPrice(busRoute.getPrice());
		existingBusRoute.setSource(busRoute.getSource());
		existingBusRoute.setBusid(busRoute.getBusid());
		
		BusRoute updatedBusRoute = busRouteRepository.save(existingBusRoute);
		
	    return updatedBusRoute;
		
	}

	@Override
	public Bus getBusbyId(String busid) {
		Optional<Bus> optionalbus = busRepository.findById(busid);
		return optionalbus.get();
	}

	@Override
	public BusRoute getBusRoutebyId(String routeid) {
		Optional<BusRoute> optionalBusRoute = busRouteRepository.findById(routeid);
		return optionalBusRoute.get();
	}
	

	@Override
	public void deleteBus(String busid) {
	
		busRepository.deleteById(busid);
		
	}

	@Override
	public void deleteBusRoute(String routeid) {
		
		busRouteRepository.deleteById(routeid);
		
	}	

}
