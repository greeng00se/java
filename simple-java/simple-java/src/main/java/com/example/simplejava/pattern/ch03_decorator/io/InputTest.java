package com.example.simplejava.pattern.ch03_decorator.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {

    private static final String INPUT_FILE = "src/main/java/com/example/simplejava/pattern/ch03_decorator/io/hello.txt";

    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream(INPUT_FILE);
                BufferedInputStream bis = new BufferedInputStream(fis);
                InputStream in = new LowerCaseInputStream(bis);
        ) {
            int c;
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
