package com.example.redis;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@RedisHash(value = "people", timeToLive = 360)
public class Person {
    @Id
    private String id;
    private String name;
    private Integer age;
    private LocalDateTime createAt;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.createAt = LocalDateTime.now();
    }
}
