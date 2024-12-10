package com.dailydash.backend.models.sources;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "devices")
public class Device {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Device name cannot be blank")
    @Size(max = 255, message = "Device name must not exceed 255 characters")
    private String name;

    @NotBlank(message = "Device type cannot be blank")
    private String type; // e.g., "Sensor", "Actuator"

    private String location; // optional

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Property> properties;

}
