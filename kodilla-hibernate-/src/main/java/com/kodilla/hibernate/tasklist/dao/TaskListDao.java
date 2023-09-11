package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
//@Transactional
//@Repository
public interface TaskListDao extends CrudRepository <TaskList, Long> {
        List <TaskList> findByListName (String listName);
}
