package lk.ijse.vehicle_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    private String ticketId;
    private String entranceLocation;
    private String exitLocation;
    private int oneKmPrice;
    private int totalKm;
    private Double totalPrice;

    @OneToOne
    private VehicleEntity vehicles;
}
