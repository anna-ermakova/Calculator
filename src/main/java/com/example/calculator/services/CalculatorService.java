package com.example.calculator.services;

import com.example.calculator.exceptions.DivByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int add(int x, int y) {
        return x + y;
    }


    public int sub(int x, int y) {
        return x - y;
    }


    public int mul(int x, int y) {
        return x * y;
    }


    public double div(int x, int y) {
        if (y == 0) {
            throw new DivByZeroException("Деление на 0 невозможно");
        }
        return (double) x / y;
    }

}
