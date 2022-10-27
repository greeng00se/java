package com.example.string.concat;

public class StringConcat {
    public static void main(String[] args) {

        String result = "";
        for (int i = 0; i < 10000; i++) {
            result += "c";
        }
    }
}
