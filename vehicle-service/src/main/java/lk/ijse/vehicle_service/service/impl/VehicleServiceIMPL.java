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
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
public class VehicleServiceIMPL implements VehicleServices {

    @Autowired
    VehicleRepo vehicleRepo;
    @Autowired
    DataConvert dataConvert;
    @Autowired
    RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(VehicleServiceIMPL.class);

    @Override
    public String registerVehicle(@RequestBody  VehicleDTO vehicleDTO) {

        boolean userExists = restTemplate.getForObject("http://localhost:8082/api/v1/userService/userExists/"+vehicleDTO.getUsers().getUserId(), Boolean.class);

        if (userExists){
            if (vehicleRepo.existsById(vehicleDTO.getVehicleId())){
                logger.info("This Id Have Already register Vehicle");
                return "This Id Have Already register Vehicle";
            }else{
                vehicleRepo.save(dataConvert.vehicleDTOConvertVehicleEntity(vehicleDTO));
                logger.info("Vehicle Register Done");
                return "Vehicle Register Done";
            }
        }else {
            logger.info("There is no user for this id");
            return "There is no user for this id";
        }
    }

    @Override
    public String updateVehicle(String updateVehicleId, VehicleDTO vehicleDTO) {

        boolean userExists = restTemplate.getForObject("http://localhost:8082/api/v1/userService/userExists/"+vehicleDTO.getUsers().getUserId(), Boolean.class);

        if (userExists){
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
        }else{
            logger.info("There is no user for this id");
            return "There is no user for this id";
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

    @Override
    public boolean checkingIfVehicleExists(String id) {
        boolean existsByVehicle = vehicleRepo.existsById(id);
        return existsByVehicle;
    }
}
