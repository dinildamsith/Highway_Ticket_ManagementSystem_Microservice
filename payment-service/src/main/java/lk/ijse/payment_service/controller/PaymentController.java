package lk.ijse.payment_service.controller;

import lk.ijse.payment_service.dto.PaymentDTO;
import lk.ijse.payment_service.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/paymentService")
public class PaymentController {

    @Autowired
    PaymentServices paymentServices;

    @PostMapping
    public void checkHealth(){
        System.out.println("Payment worked...");
    }

    @PostMapping
    @RequestMapping("/confirmPayment")
    public String confirmPayment(@RequestBody PaymentDTO paymentDTO){
        String confirmPaymentMassage = paymentServices.confirmPayment(paymentDTO);
        return confirmPaymentMassage;
    }
}
