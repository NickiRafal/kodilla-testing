package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPING_TASK = "ShopingTask";
    public static final String PAINTING_TASK = "PaintingTask";
    public static final String DRIVING_TASK = "DrivingTask";
    public final Task createTask(final String taskType) {
        return switch (taskType) {
            case SHOPING_TASK -> new ShoppingTask("Kupowanie", "jabłka", 10.0);
            case PAINTING_TASK -> new PaintingTask("Malowanie", "Niebieski", "ściany");
            case DRIVING_TASK -> new DrivingTask("Jazda do pracy", "Biuro", "samochód");
            default -> throw new IllegalArgumentException("Nieobsługiwany typ zadania: " + taskType);
        };

    }

}
