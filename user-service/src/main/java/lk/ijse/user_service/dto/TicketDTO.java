package lk.ijse.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO implements SuperDTO {
    private String ticketId;
    private String entranceLocation;
    private String exitLocation;
    private String travelKm;
    private String duration;
}
