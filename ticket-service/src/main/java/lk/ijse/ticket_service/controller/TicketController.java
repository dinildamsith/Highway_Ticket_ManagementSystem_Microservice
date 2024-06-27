package lk.ijse.ticket_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticketService")
public class TicketController {

    @PostMapping
    public void checkHealth(){
        System.out.println("Ticket Worked...");
    }
}
