package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public class ForumUser {
    private int idUser;
    private String userName;
    private char sex;
    private LocalDate data;
    private int post;

    public ForumUser(int idUser, String userName, char sex, LocalDate data,int post) {
        this.idUser = idUser;
        this.userName = userName;
        this.sex = sex;
        this.data = data;
        this.post = post;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getData() {
        return data;
    }
    public int getPost(){
        return post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return idUser == forumUser.idUser && sex == forumUser.sex && post == forumUser.post && Objects.equals(userName, forumUser.userName) && Objects.equals(data, forumUser.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, userName, sex, data, post);
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", data=" + data +
                ", post=" + post +
                '}';
    }
}
