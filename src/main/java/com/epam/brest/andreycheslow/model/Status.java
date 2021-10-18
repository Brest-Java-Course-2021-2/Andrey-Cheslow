package com.epam.brest.andreycheslow.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Status {

    List<String> messages = new ArrayList<>(Arrays.asList("Please enter weight:", "Please enter distance:"));
    List<BigDecimal> userData = new ArrayList<>();
    List<BigDecimal> dataFromFile = new ArrayList<>();

    Status handle();

    StatusType getType();

}
