package com.example.calculator.exceptions;

public class DivByZeroException extends IllegalArgumentException {
    public DivByZeroException() {
        super();
    }
    public DivByZeroException(String massage) {
        super(massage);
    }
}
