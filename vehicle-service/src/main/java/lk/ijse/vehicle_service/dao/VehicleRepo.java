package lk.ijse.vehicle_service.dao;

import lk.ijse.vehicle_service.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<VehicleEntity,String> {
}
