package lk.ijse.vehicle_service.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.vehicle_service.convert.DataConvert;
import lk.ijse.vehicle_service.dao.VehicleRepo;
import lk.ijse.vehicle_service.dto.VehicleDTO;
import lk.ijse.vehicle_service.service.VehicleServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VehicleServiceIMPL implements VehicleServices {

    @Autowired
    VehicleRepo vehicleRepo;

    DataConvert dataConvert;

    Logger logger = LoggerFactory.getLogger(VehicleServiceIMPL.class);

    @Override
    public void registerVehicle(VehicleDTO vehicleDTO) {

        if (vehicleRepo.existsById(vehicleDTO.getVehicleId())){
            logger.info("This Id Have Already register Vehicle");
        }else{
            vehicleRepo.save(dataConvert.vehicleDTOConvertVehicleEntity(vehicleDTO));
            logger.info("Vehicle Register Done");
        }
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
