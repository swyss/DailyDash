package com.dailydash.backend.repos;

import com.dailydash.backend.models.sources.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
}
