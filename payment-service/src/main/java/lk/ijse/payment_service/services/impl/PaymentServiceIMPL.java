package lk.ijse.payment_service.services.impl;

import jakarta.transaction.Transactional;
import lk.ijse.payment_service.convert.DataConvert;
import lk.ijse.payment_service.dao.PaymentRepo;
import lk.ijse.payment_service.dto.PaymentDTO;
import lk.ijse.payment_service.dto.TicketDTO;
import lk.ijse.payment_service.entity.PaymentEntity;
import lk.ijse.payment_service.entity.TicketEntity;
import lk.ijse.payment_service.services.PaymentServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class PaymentServiceIMPL implements PaymentServices {

    @Autowired
    PaymentRepo paymentRepo;
    @Autowired
    DataConvert dataConvert;
    @Autowired
    RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(PaymentServiceIMPL.class);


    @Override
    public String confirmPayment(PaymentDTO paymentDTO) {

        if (paymentRepo.existsById(paymentDTO.getPaymentId())){
            logger.info("This Id Have Already Payment");
            return "This Id Have Already Payment";
        }else {

            boolean alreadyTicketHaveCheck = restTemplate.getForObject("http://localhost:8082/api/v1/ticketService/ticketHaveCheck/"+paymentDTO.getTicket().getTicketId(), Boolean.class);
            if (alreadyTicketHaveCheck){
                if (paymentDTO.getPaymentPrice() <= paymentDTO.getCash()){
                    PaymentEntity paymentEntity = dataConvert.paymentDTOConvertPaymentEntity(paymentDTO);
                    paymentEntity.setBalance(paymentEntity.getCash() - paymentEntity.getPaymentPrice());
                    paymentRepo.save(paymentEntity);

                    restTemplate.postForObject("http://localhost:8082/api/v1/ticketService/statusUpdate/" + paymentDTO.getTicket().getTicketId(), null, String.class);
                    logger.info("Payment Success and Ticket Status Updated...");
                    return "Payment Success and Ticket Status Updated...";
                }else{
                    logger.info("This amount is insufficient to cover the payment");
                    return "This amount is insufficient to cover the payment";
                }

            }else{
                logger.info("This Id Have No Ticket");
                return "This Id Have No Ticket";
            }


        }
    }
}
