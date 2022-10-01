package com.example.test.user;

import com.example.test.user.dto.UserRequestDto;
import com.example.test.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto signUp(UserRequestDto request) {
        User user = User.builder()
                .name(request.getName())
                .age(request.getAge())
                .build();
        return UserResponseDto.from(userRepository.save(user));
    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::from)
                .collect(Collectors.toList());
    }

}
