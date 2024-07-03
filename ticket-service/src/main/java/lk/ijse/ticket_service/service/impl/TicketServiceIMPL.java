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
            return "This Id Have already Ticket";
        }else {
            TicketEntity ticket = dataConvert.ticketDTOConvertTicketEntity(ticketDTO);
            ticket.setPrice(ticket.getOneKmPrice() * ticket.getTotalKm());
            ticketRepo.save(ticket);
            return  "Ticket ID: " + ticket.getTicketId() + "\n" +
                    "Entrance Location: " + ticket.getEntranceLocation() + "\n" +
                    "Exit Location: " + ticket.getExitLocation() + "\n" +
                    "Status: " + ticket.getStatus() + "\n" +
                    "Ticket Issue Time: " + ticket.getTicketIssueTime() + "\n" +
                    "One Km Price: " + ticket.getOneKmPrice() + "\n" +
                    "Total Km: " + ticket.getTotalKm() + "\n" +
                    "Price: " + ticket.getPrice();
        }
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
            return  "Ticket ID: " + updateTicket.getTicketId() + "\n" +
                    "Entrance Location: " + updateTicket.getEntranceLocation() + "\n" +
                    "Exit Location: " + updateTicket.getExitLocation() + "\n" +
                    "Status: " + updateTicket.getStatus() + "\n" +
                    "Ticket Issue Time: " + updateTicket.getTicketIssueTime() + "\n" +
                    "One Km Price: " + updateTicket.getOneKmPrice() + "\n" +
                    "Total Km: " + updateTicket.getTotalKm() + "\n" +
                    "Price: " + updateTicket.getPrice();
        }else{
            logger.info("This Id Have No Ticket");
            return "This Id Have No Ticket";
        }
    }

    @Override
    public String getTicketDetails(String ticketId) {

        if (ticketRepo.existsById(ticketId)){
            TicketEntity ticket = ticketRepo.findById(ticketId).orElse(null);
            return "Ticket ID: " + ticket.getTicketId() + "\n" +
                    "Entrance Location: " + ticket.getEntranceLocation() + "\n" +
                    "Exit Location: " + ticket.getExitLocation() + "\n" +
                    "Status: " + ticket.getStatus() + "\n" +
                    "Ticket Issue Time: " + ticket.getTicketIssueTime() + "\n" +
                    "One Km Price: " + ticket.getOneKmPrice() + "\n" +
                    "Total Km: " + ticket.getTotalKm() + "\n" +
                    "Price: " + ticket.getPrice();
        }else{
            logger.info("This Id Have No Ticket");
            return "This Id Have No Ticket";
        }
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
