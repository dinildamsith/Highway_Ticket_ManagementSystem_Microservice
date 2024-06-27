package lk.ijse.payment_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class TicketEntity implements SuperEntity{
    @Id
    private String ticketId;
    private String entranceLocation;
    private String exitLocation;
    private String status;
    private String ticketIssueTime;
    private Double oneKmPrice;
    private int totalKm;
    private Double price;


}
