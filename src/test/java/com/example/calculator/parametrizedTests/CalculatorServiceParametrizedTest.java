package com.example.calculator.parametrizedTests;

import com.example.calculator.exceptions.DivByZeroException;
import com.example.calculator.services.CalculatorService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
public class CalculatorServiceParametrizedTest {
    CalculatorService out = new CalculatorService();

    @ParameterizedTest
    @MethodSource("paramsForAdditionTest")
    public void additionTest(int x, int y, int result) {
        assertEquals(result,out.add(x,y));
    }
    public static Stream<Arguments> paramsForAdditionTest() {
        return Stream.of(
                Arguments.of(2, 3, 5),
                Arguments.of(-2,-3,-5),
                Arguments.of(7,-2,5)
        );
    }
    @ParameterizedTest
    @MethodSource("paramsForSubtractionTest")
    public void subtractionTest(int x, int y, int result) {
        Assertions.assertThat(out.sub(x, y));
    }
    public static Stream<Arguments> paramsForSubtractionTest() {
        return Stream.of(
                Arguments.of(7, 3, 4),
                Arguments.of(-2,-3,1),
                Arguments.of(7,-2,9)
        );
    }
    @ParameterizedTest
    @MethodSource("paramsForMultiplicationTest")
    public void multiplicationTest(int x, int y, int result) {
        assertEquals(result,out.mul(x,y));
    }
    public static Stream<Arguments> paramsForMultiplicationTest() {
        return Stream.of(
                Arguments.of(7, 3, 21),
                Arguments.of(-2,-3,6),
                Arguments.of(7,-2,-14)
        );
    }
    @ParameterizedTest
    @MethodSource("paramsForDivisionTest")
    public void divisionTest(int x, int y, int result) {
        assertEquals(result,out.div(x,y));
    }
    public static Stream<Arguments> paramsForDivisionTest() {
        return Stream.of(
                Arguments.of(21, 3, 7),
                Arguments.of(-6,-3,2),
                Arguments.of(14,-2,-7)
        );
    }
    @ParameterizedTest
    @MethodSource("paramsForDividingByZeroTest")
    public void dividingByZeroTest(int x, int y) {
        Assertions.assertThatExceptionOfType(DivByZeroException.class)
                .isThrownBy(() -> out.div(x, y));
    }
    public static Stream<Arguments> paramsForDividingByZeroTest() {
        return Stream.of(
                Arguments.of(0,0),
                Arguments.of(4,0),
                Arguments.of(-10,0)
        );
    }
}
