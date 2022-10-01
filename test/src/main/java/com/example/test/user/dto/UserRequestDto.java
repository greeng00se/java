package com.example.test.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequestDto {

    private String name;
    private Long age;

    @Builder
    public UserRequestDto(String name, Long age) {
        this.name = name;
        this.age = age;
    }
}
