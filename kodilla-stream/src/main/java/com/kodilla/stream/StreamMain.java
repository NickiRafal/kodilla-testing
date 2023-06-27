package com.kodilla.stream;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {
    public static void main(String[] args) {

        Forum forum = new Forum();
        Map<Integer,ForumUser> resultMap = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex()=='M')
                .filter(forumUser ->forumUser.getDateOfBirth().isBefore(LocalDate.now().minusYears(20)))
                .filter(forumUser -> forumUser.getPost()>0)
                .collect(Collectors.toMap(ForumUser::getIdUser,forumUser -> forumUser));
        resultMap.entrySet().forEach(System.out::println);


        Map<Integer,ForumUser>resultMap1 = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getUserName().equals("Kasia"))
                .filter(forumUser -> forumUser.getUserName().length()>4)
                .filter(forumUser -> forumUser.getPost()>1)
                .filter(forumUser -> forumUser.getDateOfBirth().isBefore(LocalDate.now().minusYears(20)))
                .collect(Collectors.toMap(ForumUser::getIdUser,forumUser -> forumUser));
        resultMap1.entrySet().forEach(System.out::println);

    }

}
