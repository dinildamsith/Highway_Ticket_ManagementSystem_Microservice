package lk.ijse.ticket_service.service;

import lk.ijse.ticket_service.dto.TicketDTO;

public interface TicketServices {
    String ticketCreate(TicketDTO ticketDTO);
    String updateTicket(TicketDTO ticketDTO);
    TicketDTO getTicketDetails(String ticketId);
}
