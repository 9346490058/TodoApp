package com.qacart.com.utils;

import com.github.javafaker.Faker;
import com.qacart.com.objects.User;

public class UserUtils {
    public static User generateRandomUser()
    {
        String firstName=new Faker().name().firstName();
        String lastName=new Faker().name().lastName();
        String email=new Faker().internet().emailAddress();
        String password=new Faker().number().digits(8).toString();
        User user=new User(firstName,lastName,email,password);
        return user;
    }
}
