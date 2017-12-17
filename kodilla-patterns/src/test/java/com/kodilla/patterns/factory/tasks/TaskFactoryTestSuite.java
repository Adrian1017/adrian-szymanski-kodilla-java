package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testDrivingTaskName() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task drivingTask = taskFactory.makeTask(taskFactory.DRIVING);
        //When
        String taskName = taskFactory.getTaskList().get(0).getTask().getTaskName();
        //Then
        Assert.assertEquals("holiday",taskName);
    }
    @Test
    public void testDrivingTaskExecute() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task drivingTask = taskFactory.makeTask(taskFactory.DRIVING);
        //When
        boolean isExecute = taskFactory.getTaskList().get(0).isExecute();
        //Then
        Assert.assertEquals(true,isExecute);
    }
    @Test
    public void testPaintingTaskName() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task paintingTask = taskFactory.makeTask(taskFactory.PAINTING);
        //When
        String taskName = taskFactory.getTaskList().get(0).getTask().getTaskName();
        //Then
        Assert.assertEquals("paint1",taskName);
    }
    @Test
    public void testPaintingTaskExecute() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task paintingTask = taskFactory.makeTask(taskFactory.PAINTING);
        //When
        boolean isExecute = taskFactory.getTaskList().get(0).isExecute();
        //Then
        Assert.assertEquals(true,isExecute);
    }
    @Test
    public void testShoppingTaskName() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task shoppingTask = taskFactory.makeTask(taskFactory.SHOPPING);
        //When
        String taskName = taskFactory.getTaskList().get(0).getTask().getTaskName();
        //Then
        Assert.assertEquals("shoes",taskName);
    }
    @Test
    public void testShoppingTaskExecute() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task shoppingTask = taskFactory.makeTask(taskFactory.SHOPPING);
        //When
        boolean isExecute = taskFactory.getTaskList().get(0).isExecute();
        //Then
        Assert.assertEquals(true,isExecute);
    }
}