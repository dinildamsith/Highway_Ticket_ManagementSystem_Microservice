package lk.ijse.payment_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    private String paymentId;
    private String paymentTime;
    private String status;
    private Double paymentPrice;
    private Double cash;
    private Double balance;

    @OneToOne
    @JoinColumn(name = "ticketId")  // Change the column name here
    private TicketEntity ticket;

}
