package lk.ijse.vehicle_service.service;

import lk.ijse.vehicle_service.dto.VehicleDTO;

import java.util.List;

public interface VehicleServices {
     void registerVehicle(VehicleDTO vehicleDTO);
     void updateVehicle(String updateVehicleId , VehicleDTO vehicleDTO);
     void deleteVehicle(String deleteVehicleId);
     List<VehicleDTO> getAllVehicles();

}
