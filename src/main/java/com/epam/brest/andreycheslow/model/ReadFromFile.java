package com.epam.brest.andreycheslow.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class ReadFromFile implements Status {

    final Scanner scanner;

    public ReadFromFile(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Status handle() {
        try {
            FileReader fr = new FileReader("file.txt");
            Scanner scan = new Scanner(fr);
            String temp;
            while (scan.hasNextLine()) {
                temp = scan.nextLine();
                dataFromFile.add(BigDecimal.valueOf(Double.parseDouble(temp)));
            }

            fr.close();
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
