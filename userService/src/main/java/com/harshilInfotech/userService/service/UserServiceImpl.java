package com.harshilInfotech.userService.service;

import com.harshilInfotech.userService.dto.UserDto;
import com.harshilInfotech.userService.entity.User;
import com.harshilInfotech.userService.repository.UserRepository;
import com.harshilInfotech.userService.util.UserBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserBuilder userBuilder;

    private User findUserById(Long userId) {

        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("No User found by userId: " + userId));

    }

    @Override
    public UserDto createUser(UserDto userDto) {

//        log.info("Creating User: {}", userDto);

        User user = User.builder()
                .email(userDto.getEmail())
                .address(userDto.getAddress())
                .name(userDto.getName())
                .alerting(userDto.getAlerting())
                .surname(userDto.getSurname())
                .energyAlertingThreshold(userDto.getEnergyAlertingThreshold())
                .build();

        user = userRepository.save(user);

//        log.info("Created User: {}", user);

        return userBuilder.buildUserDtoFromUser(user);

    }

    @Override
    public UserDto getUserById(Long id) {

//        log.info("Getting user by id: {}", id);

        User user = findUserById(id);

        return userBuilder.buildUserDtoFromUser(user);

    }

    @Override
    public UserDto updateUserById(Long id, @Valid UserDto userDto) {

//        log.info("Updating User with userId: {}", id);
        User user = findUserById(id);

        user.setAddress(userDto.getAddress());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAlerting(userDto.getAlerting());
        user.setSurname(userDto.getSurname());
        user.setEnergyAlertingThreshold(userDto.getEnergyAlertingThreshold());

        user = userRepository.save(user);

//        log.info("User with userId: {} got updated Successfully.", id);

        return userBuilder.buildUserDtoFromUser(user);

    }

    @Override
    public String deleteUserById(Long id) {

        User user = findUserById(id);

//        log.info("Deleting User with userId: {}", id);

        userRepository.delete(user);

//        log.info("User with userId: {} deleted Successfully.", id);

        return "User with userId: " + id + " deleted Successfully.";

    }

}
