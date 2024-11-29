package com.dailydash.backend.repos;

import com.dailydash.backend.models.data.DataPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DataPointRepository extends JpaRepository<DataPoint, UUID> {
    List<DataPoint> findByDeviceIdAndKeyOrderByTimestampAsc(UUID deviceId, String key);

    Optional<Object> findByDeviceIdOrderByTimestampAsc(UUID attr0);
}
