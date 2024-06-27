package lk.ijse.payment_service.dto;

import lk.ijse.payment_service.entity.TicketEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private String paymentId;
    private String paymentTime;
    private String status;
    private Double paymentPrice;
    private Double cash;
    private Double balance;
    private TicketEntity ticket;
}
