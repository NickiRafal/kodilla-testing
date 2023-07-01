package com.kodilla.stream.portfolio;

import java.util.Objects;

public class User {
    private final String usename;
    private final String realName;

    public User(String usename, String realName) {
        this.usename = usename;
        this.realName = realName;
    }

    public String getUsename() {
        return usename;
    }

    public String getRealName() {
        return realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "usename='" + usename + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(usename, user.usename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usename);
    }
}
