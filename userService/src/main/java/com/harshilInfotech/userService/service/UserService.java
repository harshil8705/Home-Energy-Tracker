package com.harshilInfotech.userService.service;

import com.harshilInfotech.userService.dto.UserDto;
import jakarta.validation.Valid;

public interface UserService {

    UserDto createUser(@Valid UserDto userDto);

    UserDto getUserById(Long id);

    UserDto updateUserById(Long id, @Valid UserDto userDto);

    String deleteUserById(Long id);

}
