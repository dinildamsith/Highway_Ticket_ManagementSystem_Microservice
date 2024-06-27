package lk.ijse.vehicle_service.controller;

import lk.ijse.vehicle_service.dto.VehicleDTO;
import lk.ijse.vehicle_service.service.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/vehicleService")
public class VehicleController {

    @Autowired
    VehicleServices vehicleServices;

    @PostMapping
    public void checkHealth(){
        System.out.println("Vehicle Worked...");
    }

    @PostMapping
    @RequestMapping("/register")
    public void registerVehicle(@RequestBody VehicleDTO vehicleDTO){
        vehicleServices.registerVehicle(vehicleDTO);
    }
}
