package com.harshilInfotech.deviceService.dto;

import com.harshilInfotech.deviceService.entity.enums.DeviceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDto {

    private Long id;
    private String name;
    private DeviceType type;
    private String location;
    private Long userId;

}
