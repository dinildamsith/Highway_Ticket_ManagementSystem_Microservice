package lk.ijse.user_service.entity;

import jakarta.persistence.*;
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

    @ManyToMany
    @JoinTable(
            name = "user_vehicles", // Name of the join table
            joinColumns = @JoinColumn(name = "user_id"), // Foreign key column for UserEntity
            inverseJoinColumns = @JoinColumn(name = "vehicle_id") // Foreign key column for VehicleEntity
    )
    private List<VehicleEntity> vehicles;
}
