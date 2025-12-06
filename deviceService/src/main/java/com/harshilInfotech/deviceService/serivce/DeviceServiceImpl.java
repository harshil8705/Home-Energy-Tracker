package com.harshilInfotech.deviceService.serivce;

import com.harshilInfotech.deviceService.dto.DeviceDto;
import com.harshilInfotech.deviceService.entity.Device;
import com.harshilInfotech.deviceService.exception.DeviceNotFoundException;
import com.harshilInfotech.deviceService.repository.DeviceRepository;
import com.harshilInfotech.deviceService.util.DeviceDtoBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService{

    private final DeviceRepository deviceRepository;
    private final DeviceDtoBuilder deviceDtoBuilder;

    private Device getDeviceByDeviceId(Long id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new DeviceNotFoundException("No Device found by deviceId: " + id));
    }

    @Override
    public DeviceDto getDeviceById(Long id) {

        Device device = getDeviceByDeviceId(id);

        return deviceDtoBuilder.buildDeviceDtoFromDevice(device);

    }

    @Override
    public DeviceDto createDevice(DeviceDto deviceDto) {

        Device device = deviceDtoBuilder.buildDeviceFromDeviceDto(deviceDto);

        device = deviceRepository.save(device);

        return deviceDtoBuilder.buildDeviceDtoFromDevice(device);

    }

    @Override
    public DeviceDto updateDeviceById(Long id, DeviceDto deviceDto) {

        Device device = getDeviceByDeviceId(id);

        device.setName(deviceDto.getName());
        device.setType(deviceDto.getType());
        device.setLocation(deviceDto.getLocation());
        device.setUserId(deviceDto.getUserId());

        device = deviceRepository.save(device);

        return deviceDtoBuilder.buildDeviceDtoFromDevice(device);

    }

    @Override
    public String deleteDeviceById(Long id) {

        Device device = getDeviceByDeviceId(id);

        deviceRepository.delete(device);

        return "Device by deviceId: " + id + " deleted Successfully.";

    }
}
