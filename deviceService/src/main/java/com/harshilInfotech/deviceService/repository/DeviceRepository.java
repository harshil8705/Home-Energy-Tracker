package com.harshilInfotech.deviceService.repository;

import com.harshilInfotech.deviceService.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
