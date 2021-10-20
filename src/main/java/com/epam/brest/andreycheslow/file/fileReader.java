package com.epam.brest.andreycheslow.file;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public interface fileReader {
    Map<Integer, BigDecimal> readData(String filePath) throws IOException;
}
