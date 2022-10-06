package com.example.modulecommon.enums;

import lombok.Getter;

@Getter
public enum CodeEnum {
    SUCCESS("0000", "SUCCESS"),
    UNKNOWN_ERROR("9999", "UNKNOWN_ERROR");

    private String code;
    private String message;

    CodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
