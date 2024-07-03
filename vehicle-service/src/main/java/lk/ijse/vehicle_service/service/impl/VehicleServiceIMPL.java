package lk.ijse.vehicle_service.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.vehicle_service.convert.DataConvert;
import lk.ijse.vehicle_service.dao.VehicleRepo;
import lk.ijse.vehicle_service.dto.VehicleDTO;
import lk.ijse.vehicle_service.entity.VehicleEntity;
import lk.ijse.vehicle_service.service.VehicleServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional
public class VehicleServiceIMPL implements VehicleServices {

    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    DataConvert dataConvert;

    Logger logger = LoggerFactory.getLogger(VehicleServiceIMPL.class);

    @Override
    public String registerVehicle(@RequestBody  VehicleDTO vehicleDTO) {


        if (vehicleRepo.existsById(vehicleDTO.getVehicleId())){
            logger.info("This Id Have Already register Vehicle");
            return "This Id Have Already register Vehicle";
        }else{
            vehicleRepo.save(dataConvert.vehicleDTOConvertVehicleEntity(vehicleDTO));
            logger.info("Vehicle Register Done");
            return "Vehicle Register Done";
        }
    }

    @Override
    public String updateVehicle(String updateVehicleId, VehicleDTO vehicleDTO) {

        if (vehicleRepo.existsById(updateVehicleId)){
            VehicleEntity updateVehicleEntity = vehicleRepo.findById(updateVehicleId).orElse(null);
            updateVehicleEntity.setVehicleNumber(vehicleDTO.getVehicleNumber());
            updateVehicleEntity.setVehicleType(vehicleDTO.getVehicleType());
            updateVehicleEntity.setUsers(vehicleDTO.getUsers());

            vehicleRepo.save(updateVehicleEntity);
            return "Vehicle Update Success";
        }else{
            logger.info("This Id Have No Vehicles");
            return "This Id Have No Vehicles";
        }
    }

    @Override
    public String deleteVehicle(String deleteVehicleId) {

        if (vehicleRepo.existsById(deleteVehicleId)){
             vehicleRepo.deleteById(deleteVehicleId);
             return "Vehicle Delete Success";
        }else{
            logger.info("This Id Have No Vehicle");
            return "This Id Have No Vehicle";
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        List<VehicleEntity> allVehicles = vehicleRepo.findAll();
        return dataConvert.vehicleEntityListConvertVehicleDTOList(allVehicles);
    }
}
