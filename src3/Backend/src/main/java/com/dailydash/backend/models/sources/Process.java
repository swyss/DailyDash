package com.dailydash.backend.models.sources;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Process {
    // Getters and Setters
    private String name;
    private List<Device> devices;

}
