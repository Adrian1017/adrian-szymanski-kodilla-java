package com.kodilla.spring.portfolio;

import com.sun.javafx.tk.Toolkit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Test
    public void testTaskAddDoneTask(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        board.getDoneList().addTask("drink a lot");
        //When
        String resultDoneTask = board.getDoneList().getTasks().get(0);
        //Then
        Assert.assertEquals("drink a lot", resultDoneTask);
    }
    @Test
    public void testTaskAddProgressTask(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        board.getInProgressList().addTask("looking for a toilet");
        //When
        String resultInProgressTask = board.getInProgressList().getTasks().get(0);
        //Then
        Assert.assertEquals("looking for a toilet", resultInProgressTask);
    }
    @Test
    public void testTaskAddToDoTask(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        board.getToDoList().addTask("do not drink too much");
        //When
        String resultToDoTask = board.getToDoList().getTasks().get(0);
        //Then
        Assert.assertEquals("do not drink too much", resultToDoTask);
    }
    @Test
    public void testTaskAddAllTasks(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        board.getDoneList().addTask("drink a lot");
        board.getInProgressList().addTask("looking for a toilet");
        board.getToDoList().addTask("do not drink too much");
        //When
        String resultDoneTask = board.getDoneList().getTasks().get(0);
        String resultInProgressTask = board.getInProgressList().getTasks().get(0);
        String resultToDoTask = board.getToDoList().getTasks().get(0);
        //Then
        Assert.assertEquals("drink a lot", resultDoneTask);
        Assert.assertEquals("looking for a toilet", resultInProgressTask);
        Assert.assertEquals("do not drink too much", resultToDoTask);
    }


}
