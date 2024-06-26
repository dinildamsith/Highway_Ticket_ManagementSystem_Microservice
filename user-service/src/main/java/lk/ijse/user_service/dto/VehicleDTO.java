package lk.ijse.user_service.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO implements SuperDTO {
    private String vehicleId;
    private String vehicleNumber;
    private String vehicleType;
}
