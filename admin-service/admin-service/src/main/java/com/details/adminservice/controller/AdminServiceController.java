package com.details.adminservice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.details.adminservice.entities.Bus;
import com.details.adminservice.entities.BusRoute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.details.adminservice.service.AdminService;
import com.details.adminservice.entities.BusRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.details.adminservice.service.impl.AdminServicesImpl;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class AdminServiceController {
	
	Logger logger = LoggerFactory.getLogger(AdminServiceController.class);

	@Autowired
	AdminServicesImpl adminServicesImpl ;	
	
	@PostMapping("/createBusRoute")  //http://localhost:8095/api/v1/createBusRoute
	public ResponseEntity<BusRoute> createBusRoute(@RequestBody BusRoute busRoute)
	{		
		BusRoute savedBusRoute = adminServicesImpl.createBusRoute(busRoute);
		
		return new ResponseEntity<>(savedBusRoute,HttpStatus.CREATED);
	}
	
	@GetMapping("/routes")   //http://localhost:8095/api/v1/busRoutes
	public ResponseEntity<List<BusRoute>> getAllBusRoutes()
	{
		List<BusRoute> busRoutes=adminServicesImpl.getAllBusRoutes();
		
		return new ResponseEntity<>(busRoutes,HttpStatus.OK);
	}
	
	
	@PostMapping("/createBus")  //http://localhost:8095/api/v1/createBus
	public ResponseEntity<Bus> createBus(@RequestBody Bus bus)
	{		
		Bus savedBus = adminServicesImpl.createBus(bus);
		
		return new ResponseEntity<>(savedBus,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/buses")   //http://localhost:8095/api/v1/buses
	public ResponseEntity<List<Bus>> getAllBuses()
	{
		List<Bus> buses=adminServicesImpl.getAllBuses();
		
		return new ResponseEntity<>(buses,HttpStatus.OK);
	}	
	
	@GetMapping("{busid}")
	public ResponseEntity<Bus> getBusbyId(@PathVariable("busid") String busid)
	{
		Bus bus = adminServicesImpl.getBusbyId(busid);
		
		return new ResponseEntity<>(bus,HttpStatus.OK);
		
	}
	
	@GetMapping("{routeid}")
	public ResponseEntity<BusRoute> getBusRoutebyId(@PathVariable("routeid") String busRouteId)
	{
		BusRoute busRoute = adminServicesImpl.getBusRoutebyId(busRouteId);
		
		return new ResponseEntity<>(busRoute,HttpStatus.OK);
		
	}
	
	@PutMapping("{busid}")
	public ResponseEntity<Bus> updateBus(@PathVariable("busid") String busid,
			@RequestBody Bus bus)
	{
		bus.setBusid(busid);
		Bus updatedBus = adminServicesImpl.updateBus(bus);
		return new ResponseEntity<>(updatedBus,HttpStatus.OK);
	
	}
	
	@PutMapping("{routeid}")
	public ResponseEntity<BusRoute> updateBusRoute(@PathVariable("routeid") String routeid,
			@RequestBody BusRoute busRoute)
	{
		busRoute.setRouteid(routeid);
		BusRoute updatedBusRoute = adminServicesImpl.updateBusRoute(busRoute);
		return new ResponseEntity<>(updatedBusRoute,HttpStatus.OK);
	
	}
	
}
