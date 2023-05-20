package com.example.calculator;

import com.example.calculator.exceptions.DivByZeroException;
import com.example.calculator.services.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorServiceTests {
    CalculatorService out = new CalculatorService();

    @Test
    void summingTwoPositiveNumbers() {
        Assertions.assertEquals(5, out.add(2, 3));
    }

    @Test
    void summingTwoNegativeNumbers() {
        Assertions.assertEquals(-5, out.add(-2, -3));
    }

    @Test
    void subtractingTwoPositiveNumbers() {
        Assertions.assertEquals(5, out.sub(15, 10));
    }

    @Test
    void subtractingTwoNegativeNumbers() {
        Assertions.assertEquals(-5, out.sub(-15, -10));
    }

    @Test
    void multiplyingTwoPositiveNumbers() {
        Assertions.assertEquals(6, out.mul(2, 3));
        Assertions.assertEquals(0, out.mul(0, 10));
    }

    @Test
    void multiplyingTwoNegativeNumbers() {
        Assertions.assertEquals(8, out.mul(-2, -4));
    }
    @Test
    void dividingTwoPositiveNumbers() {
        Assertions.assertEquals(0.5, out.div(1, 2));
    }
    @Test
    void dividingTwoNegativeNumbers() {
        Assertions.assertEquals(2, out.div(-6, -3));
    }
    @Test
    void dividingByZeroException() {
        Assertions.assertThrows(DivByZeroException.class, () -> out.div(5, 0));
        Assertions.assertThrows(DivByZeroException.class, () -> out.div(-5, -0));
    }
}

