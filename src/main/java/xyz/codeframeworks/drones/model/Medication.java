package xyz.codeframeworks.drones.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medications")
public class Medication {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Pattern(regexp = "^[a-zA-Z0-9\\-_]+", message = "allowed only letters, numbers, ‘-‘, ‘_’")
    @Column(name = "name")
    private String name;
    @Column(name = "weight")
    private Double weight;
    @Pattern(regexp = "^[A-Z0-9_]+", message = "allowed only upper case letters, underscore and numbers")
    @Column(name = "code")
    private String code;
    @Column(name = "image")
    private String image;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "drone_id", nullable = true)
    private Drone drone;

}
