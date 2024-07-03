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
    public String registerVehicle(@RequestBody VehicleDTO vehicleDTO){
        String resp = vehicleServices.registerVehicle(vehicleDTO);
        return resp;
    }

    @PutMapping
    @RequestMapping("/update/{updateVehicleId}")
    public String updateVehicle(@PathVariable ("updateVehicleId") String updateVehicleId , @RequestBody VehicleDTO vehicleDTO){
        String resp = vehicleServices.updateVehicle(updateVehicleId, vehicleDTO);
        return resp;
    }

    @DeleteMapping
    @RequestMapping("/delete/{deleteVehicleId}")
    public String deleteVehicle(@PathVariable ("deleteVehicleId") String deleteVehicleId){
        String resp = vehicleServices.deleteVehicle(deleteVehicleId);
        return resp;
    }

    @GetMapping
    @RequestMapping("/getAllVehicles")
    public List<VehicleDTO> getAllVehicles(){
        List<VehicleDTO> allVehicles = vehicleServices.getAllVehicles();
        return allVehicles;
    }
}
