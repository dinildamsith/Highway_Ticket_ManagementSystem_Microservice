package lk.ijse.payment_service.services.impl;

import jakarta.transaction.Transactional;
import lk.ijse.payment_service.dto.PaymentDTO;
import lk.ijse.payment_service.services.PaymentServices;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaymentServiceIMPL implements PaymentServices {
    @Override
    public String confirmPayment(PaymentDTO paymentDTO) {
        return null;
    }
}
