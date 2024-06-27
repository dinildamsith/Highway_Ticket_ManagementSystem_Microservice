package lk.ijse.ticket_service.service;

import lk.ijse.ticket_service.dto.TicketDTO;

public interface TicketServices {
    String ticketCreate(TicketDTO ticketDTO);
    String updateTicket(String updateTicketId ,TicketDTO ticketDTO);
    String getTicketDetails(String ticketId);
}
