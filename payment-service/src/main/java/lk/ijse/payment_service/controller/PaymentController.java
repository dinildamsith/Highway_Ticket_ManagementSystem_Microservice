package lk.ijse.payment_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/paymentService")
public class PaymentController {

    @PostMapping
    public void checkHealth(){
        System.out.println("Payment worked...");
    }
}
