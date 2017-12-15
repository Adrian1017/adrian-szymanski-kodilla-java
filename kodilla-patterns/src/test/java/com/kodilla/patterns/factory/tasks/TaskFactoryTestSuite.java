package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testDrivingTaskName() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task drivingTask = taskFactory.makeTask(taskFactory.DRIVING);
        String taskName = taskFactory.getTaskList().get(0).getTask().getTaskName();
        //Then
        Assert.assertEquals("holiday",taskName);
    }
    @Test
    public void testDrivingTaskExecute() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task drivingTask = taskFactory.makeTask(taskFactory.DRIVING);
        boolean isExecute = taskFactory.getTaskList().get(0).isExecute();
        //Then
        Assert.assertEquals(true,isExecute);
    }
    @Test
    public void testPaintingTaskName() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task paintingTask = taskFactory.makeTask(taskFactory.PAINTING);
        String taskName = taskFactory.getTaskList().get(0).getTask().getTaskName();
        //Then
        Assert.assertEquals("paint1",taskName);
    }
    @Test
    public void testPaintingTaskExecute() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task paintingTask = taskFactory.makeTask(taskFactory.PAINTING);
        boolean isExecute = taskFactory.getTaskList().get(0).isExecute();
        //Then
        Assert.assertEquals(true,isExecute);
    }
    @Test
    public void testShoppingTaskName() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.makeTask(taskFactory.SHOPPING);
        String taskName = taskFactory.getTaskList().get(0).getTask().getTaskName();
        //Then
        Assert.assertEquals("shoes",taskName);
    }
    @Test
    public void testShoppingTaskExecute() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.makeTask(taskFactory.SHOPPING);
        boolean isExecute = taskFactory.getTaskList().get(0).isExecute();
        //Then
        Assert.assertEquals(true,isExecute);
    }
}