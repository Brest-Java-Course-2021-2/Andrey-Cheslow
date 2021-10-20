package com.epam.brest.andreycheslow.selector;

import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class StandardPriceSelector {

    public BigDecimal selectPriceValue(Map<Integer, BigDecimal> valueMap, BigDecimal targetValue) {
        SortedSet<Integer> sortedKeys = new TreeSet<>(valueMap.keySet());
        BigDecimal resultValue = valueMap.get(sortedKeys.first());
        for (Integer key : sortedKeys) {
            if(key >= targetValue.doubleValue()){
                resultValue = valueMap.get(key);
                break;
            }
        }

        System.out.println("Selected value: " + resultValue);
        return resultValue;
    }
}
