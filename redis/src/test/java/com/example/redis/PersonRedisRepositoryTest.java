package com.example.redis;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PersonRedisRepositoryTest {

    @Autowired
    private PersonRedisRepository personRedisRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void repositoryTest() {
        Person person = new Person("goose", 300);

        Person savedPerson = personRedisRepository.save(person);

        Person findPerson = personRedisRepository.findById(savedPerson.getId()).get();

        System.out.println(personRedisRepository.count());

        assertThat(savedPerson.getName()).isEqualTo(findPerson.getName());

        personRedisRepository.delete(findPerson);
    }

    @Test
    void valueTest() {
        // given
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        String key = UUID.randomUUID().toString();

        // when
        valueOps.set(key, "hello world");

        // then
        String result = valueOps.get(key);
        assertThat(result).isEqualTo("hello world");
    }

    @Test
    void setTest() {
        // given
        SetOperations<String, String> setOps = redisTemplate.opsForSet();
        String key = UUID.randomUUID().toString();

        // when
        setOps.add(key, "h", "i");

        // then
        Set<String> result = setOps.members(key);
        Long size = setOps.size(key);

        assertThat(result).contains("h", "i");
        assertThat(size).isEqualTo(2);
    }

    @Test
    void hashTest() {
        // given
        HashOperations<String, Object, Object> hashOps = redisTemplate.opsForHash();
        String key = UUID.randomUUID().toString();

        // when
        hashOps.put(key, "hello", "world");

        // then
        Map<Object, Object> result = hashOps.entries(key);
        assertThat(result.keySet()).containsExactly("hello");
        assertThat(result.values()).containsExactly("world");

        Long size = hashOps.size(key);
        assertThat(size).isEqualTo(result.size());
    }
}