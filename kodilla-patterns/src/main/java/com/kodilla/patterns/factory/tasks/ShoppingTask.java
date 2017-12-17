package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task{
   private String taskName;
   private String whatToBuy;
   private double quantity;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        System.out.println("Shopping...");
    }

    @Override
    public String getTaskName() {
        return this.taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return true;
    }
}
