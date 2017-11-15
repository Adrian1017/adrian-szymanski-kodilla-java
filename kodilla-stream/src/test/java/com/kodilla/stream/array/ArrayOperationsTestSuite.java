package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //Given
        int[] testArray = new int[]{ 2,2,2,2,2};
        double  expectedAverage = 2;
        //Wenn
        double actualAverage = ArrayOperations.getAverage(testArray);
        //Then
        Assert.assertTrue(expectedAverage == actualAverage);
    }
}
