package com.example.string;

import org.junit.jupiter.api.Test;

import java.lang.invoke.StringConcatFactory;

public class StringTest {

    @Test
    void concat() {
        String result = "";

        for (int i = 0; i < 100000; i++) {
            result += i;
        }
    }

    @Test
    void concatWithStringBuilder() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 100000; i++) {
            sb.append(i);
        }
    }
}
