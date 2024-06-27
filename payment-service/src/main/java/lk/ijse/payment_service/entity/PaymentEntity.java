package lk.ijse.payment_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    private String paymentPrice;
    private Double cash;
    private Double balance;

    @OneToOne
    private TicketEntity ticket;

}
