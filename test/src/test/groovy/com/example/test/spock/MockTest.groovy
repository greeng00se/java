package com.example.test.spock

import com.example.test.user.User
import com.example.test.user.UserRepository
import com.example.test.user.UserService
import com.example.test.user.dto.UserResponseDto
import spock.lang.Specification

class MockTest extends Specification {

    def "사용자 전체 조회"() {
        given:
        def userRepository = Mock(UserRepository)
        def userService = new UserService(userRepository)
        userRepository.findAll() >> List.of(
                new User("user01", 10L),
                new User("user02", 15L)
        )

        when:
        List<UserResponseDto> result = userService.findAll()

        then:
        result.size() == 2
        result.get(0).name == "user01"
    }
}
