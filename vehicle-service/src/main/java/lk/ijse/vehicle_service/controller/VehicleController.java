package lk.ijse.vehicle_service.controller;

import lk.ijse.vehicle_service.dto.VehicleDTO;
import lk.ijse.vehicle_service.service.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    @RequestMapping("/update/{updateVehicleId}")
    public void updateVehicle(@PathVariable ("updateVehicleId") String updateVehicleId , @RequestBody VehicleDTO vehicleDTO){
        vehicleServices.updateVehicle(updateVehicleId,vehicleDTO);
    }

    @DeleteMapping
    @RequestMapping("/delete/{deleteVehicleId}")
    public void deleteVehicle(@PathVariable ("deleteVehicleId") String deleteVehicleId){
        vehicleServices.deleteVehicle(deleteVehicleId);
    }

    @GetMapping
    @RequestMapping("/getAllVehicles")
    public List<VehicleDTO> getAllVehicles(){
        List<VehicleDTO> allVehicles = vehicleServices.getAllVehicles();
        return allVehicles;
    }
}
