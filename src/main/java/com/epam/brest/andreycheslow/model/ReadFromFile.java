package com.epam.brest.andreycheslow.model;

import com.epam.brest.andreycheslow.file.CSVFileReader;
import com.epam.brest.andreycheslow.selector.StandardPriceSelector;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class ReadFromFile implements Status {

    final Scanner scanner;

    public ReadFromFile(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Status handle() {


        try {
            Map<Integer,BigDecimal> pricePerKg = new CSVFileReader().readData("pricePerKg.csv");
            Map<Integer,BigDecimal> pricePerKm = new CSVFileReader().readData("pricePerKm.csv");
            StandardPriceSelector selector = new StandardPriceSelector();
            dataFromFile.add(selector.selectPriceValue(pricePerKg,userData.get(0)));
            dataFromFile.add(selector.selectPriceValue(pricePerKm,userData.get(1)));
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        return new Calc(scanner);
    }

    @Override
    public StatusType getType() {
        return StatusType.READ_DATA_FROM_FILE;
    }
}
