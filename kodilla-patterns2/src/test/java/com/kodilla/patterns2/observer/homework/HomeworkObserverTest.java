package com.kodilla.patterns2.observer.homework;

public class HomeworkObserverTest {
    public static void main(String[] args) {

        //Given
        StudentTaskQueue student1Tasks = new StudentTaskQueue();
        StudentTaskQueue student2Tasks = new StudentTaskQueue();

        Mentor mentor1 = new Mentor("John");
        Mentor mentor2 = new Mentor("Alice");

        //When
        student1Tasks.addObserver(mentor1);
        student2Tasks.addObserver(mentor2);

        student1Tasks.addTask("Task 1 for student 1");
        student2Tasks.addTask("Task 1 for student 2");
        student1Tasks.addTask("Task 2 for student 1");
        student2Tasks.addTask("Task 2 for student 2");

        //Then
        assert mentor1.getUpdateCount() == 2 : "Mentor 1 should have 2 notifications";
        assert mentor2.getUpdateCount() == 2 : "Mentor 2 should have 2 notifications";

        System.out.println("Tests completed successfully.");

    }
}
