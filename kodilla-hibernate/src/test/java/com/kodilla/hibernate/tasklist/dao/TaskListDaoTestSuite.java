package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.TaskListDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName(){
        //Given
        TaskList taskList = new TaskList("ToDo list","ToDo task");
        //When
        List <TaskList> taskLists = taskListDao.findByListName("ToDo list");
        //Then
        Assertions.assertEquals(1,taskLists.size());
        Assertions.assertEquals("ToDo list",taskLists.get(0).getListName());
        //CleanUp
        taskListDao.deleteAll();
    }
}
