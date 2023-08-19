package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import static org.testng.AssertJUnit.*;

public class TaskFactoryTestSuite {
    @Test
    void testShoppingTaskCreation(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.createTask(TaskFactory.SHOPING_TASK);
        //Then
        assertNotNull(shoppingTask);
        assertEquals("Kupowanie",shoppingTask.getTaskName());
        assertFalse(shoppingTask.isTaskExecuted());

    }
    @Test
    void testDrivingTaskCreation(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.createTask(TaskFactory.DRIVING_TASK);
        //Then
        assertNotNull(shoppingTask);
        assertEquals("Jazda do pracy",shoppingTask.getTaskName());
        assertFalse(shoppingTask.isTaskExecuted());

    }
    @Test
    void testPaintingTaskCreation(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.createTask(TaskFactory.PAINTING_TASK);
        //Then
        assertNotNull(shoppingTask);
        assertEquals("Malowanie",shoppingTask.getTaskName());
        assertFalse(shoppingTask.isTaskExecuted());

    }
}
