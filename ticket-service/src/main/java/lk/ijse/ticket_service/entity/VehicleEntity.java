package lk.ijse.ticket_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class VehicleEntity implements SuperEntity{
    @Id
    private String vehicleId;
    private String vehicleNumber;
    private String vehicleType;


}
