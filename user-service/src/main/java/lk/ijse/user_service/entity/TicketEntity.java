package lk.ijse.user_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class TicketEntity implements SuperEntity {
    @Id
    private String ticketId;
    private String entranceLocation;
    private String exitLocation;
    private String travelKm;
    private String duration;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity users;
}
