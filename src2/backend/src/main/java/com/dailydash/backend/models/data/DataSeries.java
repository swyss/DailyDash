package com.dailydash.backend.models.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class DataSeries {

    private UUID deviceId;
    private String key;
    private List<DataPoint> points;

    public DataSeries(UUID deviceId, String key, List<DataPoint> points) {
        this.deviceId = deviceId;
        this.key = key;
        this.points = points;
    }

}