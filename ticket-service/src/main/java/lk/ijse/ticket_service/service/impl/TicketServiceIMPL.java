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
    public String updateTicket(String updateTicketId , TicketDTO ticketDTO) {

        if (ticketRepo.existsById(updateTicketId)){
            TicketEntity updateTicket = ticketRepo.findById(updateTicketId).orElse(null);
            updateTicket.setEntranceLocation(ticketDTO.getEntranceLocation());
            updateTicket.setExitLocation(ticketDTO.getExitLocation());
            updateTicket.setStatus(ticketDTO.getStatus());
            updateTicket.setTicketIssueTime(ticketDTO.getTicketIssueTime());
            updateTicket.setOneKmPrice(ticketDTO.getOneKmPrice());
            updateTicket.setTotalKm(ticketDTO.getTotalKm());
            updateTicket.setPrice(ticketDTO.getOneKmPrice() * ticketDTO.getTotalKm());
            updateTicket.setVehicle(ticketDTO.getVehicle());
            ticketRepo.save(updateTicket);
            return  updateTicket.getTicketId() + "\n" +
                    updateTicket.getEntranceLocation() + "\n" +
                    updateTicket.getExitLocation() + "\n" +
                    updateTicket.getStatus() + "\n" +
                    updateTicket.getTicketIssueTime() + "\n" +
                    updateTicket.getOneKmPrice() + "\n" +
                    updateTicket.getTotalKm() + "\n" +
                    updateTicket.getPrice();
        }else{
            logger.info("This Id Have No Ticket");
        }
        return null;
    }

    @Override
    public String getTicketDetails(String ticketId) {

        if (ticketRepo.existsById(ticketId)){
            TicketEntity ticket = ticketRepo.findById(ticketId).orElse(null);
            return  ticket.getTicketId() + "\n" +
                    ticket.getEntranceLocation() + "\n" +
                    ticket.getExitLocation() + "\n" +
                    ticket.getStatus() + "\n" +
                    ticket.getTicketIssueTime() + "\n" +
                    ticket.getOneKmPrice() + "\n" +
                    ticket.getTotalKm() + "\n" +
                    ticket.getPrice();
        }else{
            logger.info("This Id Have No Ticket");
        }
        return null;
    }

    @Override
    public boolean alreadyTicketHaveCheck(String ticketId) {
        boolean ticektHaveCheck = ticketRepo.existsById(ticketId);
        return ticektHaveCheck;
    }

    @Override
    public void ticketStatusUpdate(String ticketId) {
        TicketEntity ticketEntity = ticketRepo.findById(ticketId).orElse(null);
        ticketEntity.setStatus("PAID");
        ticketRepo.save(ticketEntity);
    }
}
