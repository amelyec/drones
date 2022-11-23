package xyz.codeframeworks.drones.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drones")
public class Drone {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long ID;
    @Column(name = "serial_number", length=100)
    private String serialNumber;
    @Column(name= "model")
    private DroneModel model;
    @Column(name= "weight_limit")
    private Double weightLimit;
    @Column(name= "battery_percentage")
    private Double batteryPercentage;
    @Column(name= "state")
    private DroneState state;

    
}
