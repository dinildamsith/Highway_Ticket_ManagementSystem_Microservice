package lk.ijse.vehicle_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/vehicleService")
public class VehicleController {

    @PostMapping
    public void checkHealth(){
        System.out.println("Vehicle Worked...");
    }
}
