package com.example.test.user;

import com.example.test.user.dto.UserRequestDto;
import com.example.test.user.dto.UserResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @DisplayName("회원 가입")
    @Test
    void signUp() {
        // given
        UserRequestDto request = UserRequestDto.builder()
                .name("hello")
                .age(10L)
                .build();

        Mockito.doReturn(new User(request.getName(), request.getAge())).when(userRepository)
                .save(any(User.class));

        // when
        UserResponseDto user = userService.signUp(request);

        // then
        assertThat(user.getName()).isEqualTo("hello");
        assertThat(user.getAge()).isEqualTo(10L);

        verify(userRepository, times(1)).save(any(User.class));
    }

    @DisplayName("전체 조회")
    @Test
    void findAll() {
        // given
        List<User> userList = LongStream.range(0, 5)
                .mapToObj(i -> User.builder()
                        .name("foo" + i)
                        .age(i)
                        .build())
                .collect(Collectors.toList());

        Mockito.doReturn(userList).when(userRepository)
                .findAll();

        // when
        List<UserResponseDto> result = userService.findAll();

        // then
        assertThat(result.size()).isEqualTo(5);
    }
}
