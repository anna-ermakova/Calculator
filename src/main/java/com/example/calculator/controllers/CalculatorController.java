package com.example.calculator.controllers;

import com.example.calculator.services.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }


    @GetMapping
    public String greeting() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer x, @RequestParam(value = "num2",required = false) Integer y) {
        if (Objects.isNull(x) || Objects.isNull(y)) {
            return "Оба параметра должны быть переданы!";
        }
        return String.format("%d+%d=%d", x, y, service.add(x, y));
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value="num1", required = false) Integer x, @RequestParam(value="num2", required = false) Integer y) {
        if (Objects.isNull(x) || Objects.isNull(y)) {
            return "Оба параметра должны быть переданы!";
        }
        return String.format("%d-%d=%d", x, y, service.sub(x, y));
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value="num1", required = false) Integer x, @RequestParam(value="num2", required = false) Integer y) {
        if (Objects.isNull(x) || Objects.isNull(y)) {
            return "Оба параметра должны быть переданы!";
        }
        return String.format("%d*%d=%d", x, y, service.mul(x, y));
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value="num1", required = false) Integer x, @RequestParam(value="num2", required = false) Integer y) {
        if (Objects.isNull(x) || Objects.isNull(y)) {
            return "Оба параметра должны быть переданы!";
        }
        return String.format("%d/%d=%d", x, y, service.div(x, y));
    }
}
