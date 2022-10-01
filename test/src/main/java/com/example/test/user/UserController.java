package com.example.test.user;

import com.example.test.user.dto.UserRequestDto;
import com.example.test.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Long> signUp(@RequestBody UserRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.signUp(request));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.findAll());
    }
}