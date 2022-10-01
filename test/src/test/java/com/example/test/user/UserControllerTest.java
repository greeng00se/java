package com.example.test.user;

import com.example.test.user.dto.UserRequestDto;
import com.example.test.user.dto.UserResponseDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    @DisplayName("회원 가입 성공")
    void signUpSuccess() throws Exception {
        // given
        UserRequestDto request = UserRequestDto.builder()
                .name("hello")
                .age(10L)
                .build();
        Mockito.doReturn(new UserResponseDto(1L, "hello", 10L)).when(userService)
                .signUp(Mockito.any(UserRequestDto.class));

        String json = new Gson().toJson(request);

        // when
        ResultActions result = mockMvc.perform(
                MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        );

        // then
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("id", 1L).exists())
                .andExpect(jsonPath("name", request.getName()).exists())
                .andExpect(jsonPath("age", request.getAge()).exists());
    }

    @Test
    @DisplayName("사용자 전체 조회")
    void findAll() throws Exception {
        // given
        List<UserResponseDto> users = LongStream.range(0, 5)
                .mapToObj(i -> UserResponseDto.builder()
                        .id(i)
                        .name("foo" + i)
                        .age(i)
                        .build())
                .collect(Collectors.toList());

        Mockito.doReturn(users).when(userService)
                .findAll();

        // expected
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("foo0"))
                .andExpect(jsonPath("$[4].name").value("foo4"))
                .andDo(print());
    }
}
