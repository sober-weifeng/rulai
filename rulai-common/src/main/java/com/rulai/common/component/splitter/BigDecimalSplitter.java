package com.rulai.common.component.splitter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/6 13:15
 */
public class BigDecimalSplitter {

    private static final BigDecimal MIN_INCREMENT = new BigDecimal(10000 * Double.MIN_VALUE);
    
    public List<InputSplit> split(String columnName, BigDecimal numSplits, BigDecimal minVal, BigDecimal maxVal) {
        String lowClausePrefix = columnName + " >= ";
        String highClausePrefix = columnName + " < ";
        if (minVal == null && maxVal == null) {
            List<InputSplit> splits = new ArrayList<InputSplit>();
            splits.add(new InputSplit(columnName + " IS NULL", 
                    columnName + " IS NULL"));
            return splits;
        }
        if (minVal == null || maxVal == null) {
            return null;
        }
        List<BigDecimal> splitPoints = split(numSplits, minVal, maxVal);
        List<InputSplit> splits = new ArrayList<>();
        BigDecimal start = splitPoints.get(0);
        InputSplit inputSplit;
        for (int i = 1, len = splitPoints.size(); i < len; i++) {
            BigDecimal end = splitPoints.get(i);
            if (i == len - 1) {
                inputSplit = new InputSplit(lowClausePrefix + start.toString(),
                        columnName + "<= " + end.toString());
            } else {
                inputSplit = new InputSplit(lowClausePrefix + start.toString(),
                        highClausePrefix + end.toString());
            }
            splits.add(inputSplit);
            start = end;
        }
        return splits;
    }
    
    public List<BigDecimal> split(BigDecimal numSplits, BigDecimal minVal, BigDecimal maxVal) {
        List<BigDecimal> splits = new ArrayList<>();
        BigDecimal splitSize = tryDivide(maxVal.subtract(minVal), numSplits);
        if (splitSize.compareTo(MIN_INCREMENT) < 0) {
            splitSize = MIN_INCREMENT;
        }
        BigDecimal curVal = minVal;
        while (curVal.compareTo(maxVal) <= 0) {
            splits.add(curVal);
            curVal = curVal.add(splitSize);
        }
        if (splits.get(splits.size() - 1).compareTo(maxVal) != 0 
                || splits.size() == 1) {
            splits.add(maxVal);
        }
        return splits;
    }
    
    protected BigDecimal tryDivide(BigDecimal numerator, BigDecimal denominator) {
        return numerator.divide(denominator, 4, BigDecimal.ROUND_UP);
    }
    
}