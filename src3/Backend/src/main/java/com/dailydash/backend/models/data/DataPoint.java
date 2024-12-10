package com.dailydash.backend.models.data;

import com.dailydash.backend.models.sources.Device;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "data_points", indexes = {
        @Index(name = "idx_device_key", columnList = "device_id, key"),
        @Index(name = "idx_timestamp", columnList = "timestamp")
})
public class DataPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @NotBlank(message = "Key cannot be blank")
    private String key;

    @NotBlank(message = "Value cannot be blank")
    private String value;

    private String unit; // optional

    @NotNull(message = "Timestamp cannot be null")
    private long timestamp;
}
