package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task{
    private final String taskName;
    private final String where;
    private final String using;
    private boolean taskExecuted = false;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
    taskExecuted = true;
        System.out.println("Wykonanie zadania " + taskName);
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskExecuted;
    }
}
