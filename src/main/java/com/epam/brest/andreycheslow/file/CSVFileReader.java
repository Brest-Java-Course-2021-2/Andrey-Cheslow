package com.epam.brest.andreycheslow.file;

import java.io.*;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CSVFileReader implements fileReader{
    @Override
    public Map<Integer, BigDecimal> readData(String filePath) throws IOException {
        Map<Integer, BigDecimal> resultMap = new TreeMap<>();
        /*File file = new File(getClass().getResource(filePath).getFile());
        FileReader fr = new FileReader(file);
        Scanner scan = new Scanner(fr);*/
        String temp;
        String[] values;
        InputStream inputStream = getClass().getResourceAsStream("/" + filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while ((temp = bufferedReader.readLine()) != null) {
            //temp = scan.nextLine();
            values = temp.split(",");
            resultMap.put(Integer.valueOf(values[0]), new BigDecimal(values[1]));
        }
        bufferedReader.close();
        return resultMap;
    }
}
