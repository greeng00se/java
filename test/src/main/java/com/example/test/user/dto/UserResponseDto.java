package com.example.test.user.dto;

import com.example.test.user.User;
import lombok.Builder;
import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;
    private String name;
    private Long age;

    @Builder
    public UserResponseDto(Long id, String name, Long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static UserResponseDto from(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build();
    }
}
