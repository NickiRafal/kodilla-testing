package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public class ForumUser {
    private final int idUser;
    private final String username;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int post;

    public ForumUser(int idUser, String username, char sex, LocalDate dateOfBirth, int post) {
        this.idUser = idUser;
        this.username = username;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.post = post;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getUserName() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPost() {
        return post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return idUser == forumUser.idUser && sex == forumUser.sex && post == forumUser.post && Objects.equals(username, forumUser.username) && Objects.equals(dateOfBirth, forumUser.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, username, sex, dateOfBirth, post);
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "idUser=" + idUser +
                ", userName='" + username + '\'' +
                ", sex=" + sex +
                ", data=" + dateOfBirth +
                ", post=" + post +
                '}';
    }
}
