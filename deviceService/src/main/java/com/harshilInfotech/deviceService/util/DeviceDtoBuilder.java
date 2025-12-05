package com.harshilInfotech.deviceService.util;

import com.harshilInfotech.deviceService.dto.DeviceDto;
import com.harshilInfotech.deviceService.entity.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceDtoBuilder {

    public DeviceDto buildDeviceDtoFromDevice(Device device) {

        return DeviceDto.builder()
                .id(device.getId())
                .name(device.getName())
                .type(device.getType())
                .location(device.getLocation())
                .userId(device.getUserId())
                .build();

    }

    public Device buildDeviceFromDeviceDto(DeviceDto dto) {

        return Device.builder()
                .userId(dto.getUserId())
                .name(dto.getName())
                .type(dto.getType())
                .location(dto.getLocation())
                .build();

    }

}
