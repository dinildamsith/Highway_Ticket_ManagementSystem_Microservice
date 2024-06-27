package lk.ijse.ticket_service.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.ticket_service.convert.DataConvert;
import lk.ijse.ticket_service.dao.TicketRepo;
import lk.ijse.ticket_service.dto.TicketDTO;
import lk.ijse.ticket_service.entity.TicketEntity;
import lk.ijse.ticket_service.service.TicketServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TicketServiceIMPL implements TicketServices {

    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    DataConvert dataConvert;

    Logger logger = LoggerFactory.getLogger(TicketServiceIMPL.class);


    @Override
    public String ticketCreate(TicketDTO ticketDTO) {

        if (ticketRepo.existsById(ticketDTO.getTicketId())){
            logger.info("This Id Have already Ticket");
        }else {
            TicketEntity ticket = dataConvert.ticketDTOConvertTicketEntity(ticketDTO);
            ticket.setPrice(ticket.getOneKmPrice() * ticket.getTotalKm());
            ticketRepo.save(ticket);
            return  ticket.getTicketId() + "\n" +
                    ticket.getEntranceLocation() + "\n" +
                    ticket.getExitLocation() + "\n" +
                    ticket.getStatus() + "\n" +
                    ticket.getTicketIssueTime() + "\n" +
                    ticket.getOneKmPrice() + "\n" +
                    ticket.getTotalKm() + "\n" +
                    ticket.getPrice();
        }
        return null;
    }

    @Override
    public String updateTicket(TicketDTO ticketDTO) {
        return null;
    }

    @Override
    public TicketDTO getTicketDetails(String ticketId) {
        return null;
    }
}
