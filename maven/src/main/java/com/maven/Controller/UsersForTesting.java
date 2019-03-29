/*******************************************************************************
Default users for logging in
 ******************************************************************************/ 
package com.maven.Controller;

import com.maven.model.User;
import java.util.HashSet;
/**
 *
 * @author Regory Gregory
 */
public class UsersForTesting {
    private static HashSet<User> users;
    
    public static void init()
    {
        users = new HashSet<User>();
        User tim = new User();
        tim.setName("Tim");
        tim.setSurname("Howard");
        tim.setUserName("thoward37");
        tim.setEmail("timhoward37@hotmail.com");
        tim.setPassword("Something37");
        tim.setUserLevel(0);
        
        User ben = new User();
        ben.setName("Ben");
        ben.setSurname("Dover");
        ben.setUserName("bDover123");
        ben.setEmail("bdover123@hotmail.com");
        ben.setPassword("SomethingElse123");
        ben.setUserLevel(0);
        
        User dave = new User();
        dave.setName("Dave");
        dave.setSurname("Walker");
        dave.setUserName("dwalker01");
        dave.setEmail("davewalker@hotmail.com");
        dave.setPassword("Password1");
        dave.setUserLevel(2);
        
        User tom = new User();
        tom.setName("Tom");
        tom.setSurname("Turner");
        tom.setUserName("tomturner8");
        tom.setEmail("tomTurner12@gmail.com");
        tom.setPassword("BadPassword");
        tom.setUserLevel(1);
        
        User frank = new User();
        frank.setName("Frank");
        frank.setSurname("Castle");
        frank.setUserName("66franky66");
        frank.setEmail("frank.castle@hotmail.com");
        frank.setPassword("Password2");
        frank.setUserLevel(2);
        
        User webSercvices = new User();
        webSercvices.setName("WEBSERVICES_name");
        webSercvices.setSurname("WEBSERVICES_sur_name");
        webSercvices.setUserName("WEBSERVICES_u_name");
        webSercvices.setEmail("WEBSERVICES@WEBSERVICES.com");
        webSercvices.setPassword("WEBSERVICES");
        
        users.add(webSercvices);
        users.add(tim);
        users.add(ben);
        users.add(dave);
        users.add(tom);
        users.add(frank);
        
    }

    public static HashSet<User> getUsers() {
        return users;
    }

    public static void setUsers(HashSet<User> users) {
        UsersForTesting.users = users;
    }
     
}
