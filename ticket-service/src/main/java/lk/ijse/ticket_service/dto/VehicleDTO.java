package lk.ijse.ticket_service.dto;

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
