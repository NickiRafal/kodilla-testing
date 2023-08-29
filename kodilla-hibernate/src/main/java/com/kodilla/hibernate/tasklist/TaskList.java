package com.kodilla.hibernate.tasklist;

import jakarta.persistence.*;

@Entity
@Table(name = "TASKLISTS")
public class TaskList {
    private long id;
    private String listName;
    private String description;
    public TaskList(){

    }

    public TaskList( String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID",unique = true)
    public long getId() {
        return id;
    }
    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
