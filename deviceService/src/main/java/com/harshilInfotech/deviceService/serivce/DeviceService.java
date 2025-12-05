package com.harshilInfotech.deviceService.serivce;

import com.harshilInfotech.deviceService.dto.DeviceDto;
import jakarta.validation.Valid;

public interface DeviceService {

    DeviceDto getDeviceById(Long id);

    DeviceDto createDevice(@Valid DeviceDto deviceDto);

    DeviceDto updateDeviceById(Long id, @Valid DeviceDto deviceDto);

    String deleteDeviceById(Long id);

}
