package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Forum {


    public List<ForumUser> getUserList() {
        ForumUser forumUser1 = new ForumUser(001, "Rafał", 'M', LocalDate.of(1979, 01, 06), 10);
        ForumUser forumUser2 = new ForumUser(002, "Tomek", 'M', LocalDate.of(1985, 02, 21), 0);
        ForumUser forumUser3 = new ForumUser(003, "Kasia", 'F', LocalDate.of(2000, 05, 12), 2);
        ForumUser forumUser4 = new ForumUser(004, "Magda", 'F', LocalDate.of(1960, 11, 30), 5);
        ForumUser forumUser5 = new ForumUser(005, "Ola", 'F', LocalDate.of(1999, 10, 04), 31);
        ForumUser forumUser6 = new ForumUser(006, "Krzysiek", 'M', LocalDate.of(2018, 05, 22), 4);
        List<ForumUser> userList = new ArrayList<>();
        userList.add(forumUser1);
        userList.add(forumUser2);
        userList.add(forumUser3);
        userList.add(forumUser4);
        userList.add(forumUser5);
        userList.add(forumUser6);
        return userList;
    }


    }

