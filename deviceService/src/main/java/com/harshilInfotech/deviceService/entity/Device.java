package com.harshilInfotech.deviceService.entity;

import com.harshilInfotech.deviceService.entity.enums.DeviceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "device")
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 50)
    private DeviceType type;

    @Column(name = "location")
    private String location;

    @Column(name = "user_id")
    private Long userId;

}