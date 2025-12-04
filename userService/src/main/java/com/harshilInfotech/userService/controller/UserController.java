package com.harshilInfotech.userService.controller;

import com.harshilInfotech.userService.dto.UserDto;
import com.harshilInfotech.userService.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto) {

        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {

        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserById(
            @PathVariable Long id,
            @RequestBody @Valid UserDto userDto
    ) {

        try {
            return new ResponseEntity<>(userService.updateUserById(id, userDto), HttpStatus.ACCEPTED);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(Long id) {

        try{
            return new ResponseEntity<>(userService.deleteUserById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
