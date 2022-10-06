package com.example.moduleapi.controller;

import com.example.moduleapi.response.CommonResponse;
import com.example.moduleapi.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/save")
    public String save() {
        return helloService.save();
    }

    @GetMapping("/find")
    public String find() {
        return helloService.find();
    }

    @GetMapping("/exception")
    public String exception() {
        return helloService.exception();
    }
}
