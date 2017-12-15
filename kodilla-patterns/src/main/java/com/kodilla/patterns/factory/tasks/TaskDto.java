package com.kodilla.patterns.factory.tasks;

public class TaskDto {
    private boolean isExecute;
    private Task task;

    public boolean isExecute() {
        return isExecute;
    }

    public Task getTask() {
        return task;
    }

    public TaskDto(boolean isExecute, Task task) {
        this.isExecute = isExecute;

        this.task = task;
    }
}
