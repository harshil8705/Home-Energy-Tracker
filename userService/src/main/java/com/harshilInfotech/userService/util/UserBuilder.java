package com.harshilInfotech.userService.util;

import com.harshilInfotech.userService.dto.UserDto;
import com.harshilInfotech.userService.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserBuilder {

    public UserDto buildUserDtoFromUser(User user) {

        return UserDto.builder()
                .userId(user.getId())
                .address(user.getAddress())
                .email(user.getEmail())
                .name(user.getName())
                .alerting(user.getAlerting())
                .surname(user.getSurname())
                .energyAlertingThreshold(user.getEnergyAlertingThreshold())
                .build();

    }

    public User buildUserFromUserDto(UserDto userDto) {

        return User.builder()
                .email(userDto.getEmail())
                .address(userDto.getAddress())
                .name(userDto.getName())
                .alerting(userDto.getAlerting())
                .surname(userDto.getSurname())
                .energyAlertingThreshold(userDto.getEnergyAlertingThreshold())
                .build();

    }

}
