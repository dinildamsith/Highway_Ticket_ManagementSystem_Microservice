package lk.ijse.vehicle_service.service;

import lk.ijse.vehicle_service.dto.VehicleDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehicleServices {
     String registerVehicle(VehicleDTO vehicleDTO);
     String updateVehicle(String updateVehicleId , VehicleDTO vehicleDTO);
     String deleteVehicle(String deleteVehicleId);
     List<VehicleDTO> getAllVehicles();

}
