package com.harshilInfotech.deviceService.controller;

import com.harshilInfotech.deviceService.dto.DeviceDto;
import com.harshilInfotech.deviceService.serivce.DeviceServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/device")
public class DeviceController {

    private final DeviceServiceImpl deviceService;

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDto> getDeviceById(@PathVariable Long id) {

        return new ResponseEntity<>(deviceService.getDeviceById(id), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<DeviceDto> createDevice(@RequestBody @Valid DeviceDto deviceDto) {

        return new ResponseEntity<>(deviceService.createDevice(deviceDto), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceDto> updateDeviceById(
            @PathVariable Long id,
            @RequestBody @Valid DeviceDto deviceDto
    ) {

        return new ResponseEntity<>(deviceService.updateDeviceById(id, deviceDto), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeviceById(@PathVariable Long id) {

        return new ResponseEntity<>(deviceService.deleteDeviceById(id), HttpStatus.OK);

    }

}
