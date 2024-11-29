package com.dailydash.backend.models.sources;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Plant {
    // Getters and Setters
    private String name;
    private String location;
    private List<Device> devices;

}
