package lk.ijse.ticket_service.controller;

import lk.ijse.ticket_service.dto.TicketDTO;
import lk.ijse.ticket_service.service.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticketService")
public class TicketController {

    @Autowired
    TicketServices ticketServices;

    @PostMapping
    public void checkHealth(){
        System.out.println("Ticket Worked...");
    }

    @PostMapping
    @RequestMapping("/createTicket")
    public String createTicket(@RequestBody TicketDTO ticketDTO){
        String ticket = ticketServices.ticketCreate(ticketDTO);
        return ticket;
    }
}