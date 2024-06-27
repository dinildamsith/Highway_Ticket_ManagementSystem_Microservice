package lk.ijse.payment_service.services;

import lk.ijse.payment_service.dto.PaymentDTO;

public interface PaymentServices {
    String confirmPayment(PaymentDTO  paymentDTO);
}
