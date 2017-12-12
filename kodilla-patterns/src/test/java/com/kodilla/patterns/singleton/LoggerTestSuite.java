package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void getLastLog() {
        //Given
        Logger.getInstance().log("Test");
        //When
        String logMessage = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("Test", logMessage);
    }
}