package com.details.adminservice.service;

import com.details.adminservice.entities.BusRoute;
import com.details.adminservice.entities.Bus;
import java.util.List;

public interface AdminService {

	BusRoute createBusRoute(BusRoute busRoute);

	List<BusRoute> getAllBusRoutes();

	Bus createBus(Bus bus);

	List<Bus> getAllBuses();

	Bus getBusbyId(String busid);

	BusRoute getBusRoutebyId(String routeid);

	Bus updateBus(Bus bus);

	BusRoute updateBusRoute(BusRoute busRoute);
	
	void deleteBus(String busid);
	
	void deleteBusRoute(String busRouteId);

}
