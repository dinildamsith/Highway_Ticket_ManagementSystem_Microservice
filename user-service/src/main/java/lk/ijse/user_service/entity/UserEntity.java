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

    @OneToMany(mappedBy = "users")
    private List<TicketEntity> tickets;
}
