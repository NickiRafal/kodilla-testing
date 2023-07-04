package com.kodilla.exception.nullpointer;

import java.util.Optional;

public class NullPointerExceptionRunner {
    public static void main(String[] args) {
        User user = null;
        MessageSender messageSender = new MessageSender();
        try {
            messageSender.sendMesageTo(user, "Hello!");
        }catch (MessageNotSentException e){
            System.out.println("Message is not send," +
                    "but my program still running very well!");
        }
        System.out.println("Processing other logic!");
        User user1 =new User("user1");
        Optional<User> optionalUser = Optional.ofNullable(user1);
        String username = optionalUser.orElse(new User("")).getName();
        optionalUser.ifPresent(u->System.out.println(u.getName()));
    }
}
