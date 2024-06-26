package lk.ijse.vehicle_service.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.vehicle_service.dto.VehicleDTO;
import lk.ijse.vehicle_service.service.VehicleServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VehicleServiceIMPL implements VehicleServices {
    @Override
    public void registerVehicle(VehicleDTO vehicleDTO) {

    }

    @Override
    public void updateVehicle(String updateVehicleId, VehicleDTO vehicleDTO) {

    }

    @Override
    public void deleteVehicle(String deleteVehicleId) {

    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return null;
    }
}
