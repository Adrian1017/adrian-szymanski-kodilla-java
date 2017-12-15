package com.kodilla.patterns.factory.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";
    private final List<TaskDto> taskList = new ArrayList<>();

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case DRIVING:
                DrivingTask drivingTask = new DrivingTask("holiday","Warsaw","train");
                taskList.add(new TaskDto(drivingTask.isTaskExecuted(),drivingTask));
                return drivingTask;
            case PAINTING:
                PaintingTask paintingTask = new PaintingTask("paint1","red","flowers");
                taskList.add(new TaskDto(paintingTask.isTaskExecuted(),paintingTask));
                return paintingTask;
            case SHOPPING:
                ShoppingTask shoppingTask = new ShoppingTask("shoes","boots",1);
                taskList.add( new TaskDto(shoppingTask.isTaskExecuted(),shoppingTask));
                return shoppingTask;
            default:
                return null;
        }

    }

    public List<TaskDto> getTaskList() {
        List<TaskDto> taskListCopy = this.taskList;
        return taskListCopy;
    }
}

