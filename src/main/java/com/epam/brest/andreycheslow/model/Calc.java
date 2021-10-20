package com.epam.brest.andreycheslow.model;

import com.epam.brest.andreycheslow.calc.CalcImpl;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.epam.brest.andreycheslow.model.StatusType.CALC;

public class Calc implements Status {

    Scanner scanner;

    public Calc(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Status handle() {
        if (dataFromFile.size() == 0) return new ReadFromFile(scanner);
        try {
            System.out.println("Result: " + new CalcImpl().handle(userData.get(0),dataFromFile.get(0),userData.get(1),dataFromFile.get(1)));
        } finally {
            userData.clear();
            dataFromFile.clear();
        }

        return new ReadData(scanner);
    }

    @Override
    public StatusType getType() {
        return CALC;
    }
}