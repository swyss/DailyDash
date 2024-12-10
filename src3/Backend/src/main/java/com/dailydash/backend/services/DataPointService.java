package com.dailydash.backend.services;

import com.dailydash.backend.models.data.DataPoint;
import com.dailydash.backend.repos.DataPointRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DataPointService {

    private final DataPointRepository dataPointRepository;

    public DataPointService(DataPointRepository dataPointRepository) {
        this.dataPointRepository = dataPointRepository;
    }

    public List<DataPoint> getDataPointsByDeviceAndKey(UUID deviceId, String key) {
        return dataPointRepository.findByDeviceIdAndKeyOrderByTimestampAsc(deviceId, key);
    }

    public DataPoint saveDataPoint(DataPoint dataPoint) {
        return dataPointRepository.save(dataPoint);
    }

    public void deleteDataPoint(UUID id) {
        dataPointRepository.deleteById(id);
    }

    public Optional<Object> getDataPointById(UUID deviceId) {
        return dataPointRepository.findByDeviceIdOrderByTimestampAsc(deviceId);
    }
}
