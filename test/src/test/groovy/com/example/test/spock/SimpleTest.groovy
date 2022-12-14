package com.example.test.spock

import spock.lang.Specification

class SimpleTest extends Specification {

    def "1 + 2 = 3이다"() {
        given:
        long a = 1L
        long b = 2L

        when:
        def result = a + b

        then:
        result == 3L
        result != 2L

        when:
        def hello = "hello"

        then:
        hello == "hello"
    }

    def "두 숫자중 큰 숫자를 반환한다."() {
        expect:
        Math.max(a, b) == c

        where:
        a | b   || c
        1 | 2   || 2
        7 | 100 || 100
        4 | 5   || 5
    }

    def "0으로 나눌 수 없다"() {
        when:
        1 / 0

        then:
        def e = thrown(ArithmeticException)
        e.message == "Division by zero"
    }
}
