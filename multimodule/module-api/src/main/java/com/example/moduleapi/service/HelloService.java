package com.example.moduleapi.service;

import com.example.modulecommon.enums.CodeEnum;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String save() {
        System.out.println(CodeEnum.SUCCESS.getCode());
        return "save";
    }

    public String find() {
        return "find";
    }
}
