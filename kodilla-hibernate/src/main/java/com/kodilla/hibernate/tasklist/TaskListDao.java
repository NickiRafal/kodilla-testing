package com.kodilla.hibernate.tasklist;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskListDao extends CrudRepository <TaskList , Long> {
        List <TaskList> findByListName (String listName);
}
