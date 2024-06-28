package lk.ijse.vehicle_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity implements SuperEntity{
    @Id
    private String userId;
    private String userMail;
    private String userName;
    private String password;



    @OneToMany(mappedBy = "users")
    private List<VehicleEntity> vehicles;
}
