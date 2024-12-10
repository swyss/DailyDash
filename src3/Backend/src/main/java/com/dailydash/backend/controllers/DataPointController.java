package com.dailydash.backend.controllers;
import com.dailydash.backend.models.data.DataPoint;
import com.dailydash.backend.services.DataPointService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/data-points")
public class DataPointController {

    private final DataPointService dataPointService;

    public DataPointController(DataPointService dataPointService) {
        this.dataPointService = dataPointService;
    }

    @GetMapping("/device/{deviceId}/key/{key}")
    public List<DataPoint> getDataPointsByDeviceAndKey(
            @PathVariable UUID deviceId,
            @PathVariable String key
    ) {
        return dataPointService.getDataPointsByDeviceAndKey(deviceId, key);
    }

    @PostMapping
    public DataPoint createDataPoint(@RequestBody DataPoint dataPoint) {
        return dataPointService.saveDataPoint(dataPoint);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDataPoint(@PathVariable UUID id) {
        if (dataPointService.getDataPointById(id).isPresent()) {
            dataPointService.deleteDataPoint(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
