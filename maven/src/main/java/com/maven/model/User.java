/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.model;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author joshw
 */
public class User implements Serializable{
    private String name;
    private String surname;
    private int userLevel;
    private String userName;
    private String email;
    private String password;
    
    public User(){}
    
    
    public void JSONCorection()
    {
    this.setSurname(this.getName());
    this.setUserName(this.getName());
    this.setPassword(this.getName());
    this.setEmail(this.getName()+"@unknown.com");
    }
    public User(String name, String password, int userLevel){
       setName(name);
       setSurname(name);
       setUserName(name);
       setPassword(password);
       setEmail(name+"@hotmail.com");
       setUserLevel(userLevel);
    }
    
    
    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    
    public void setName(String g){
        this.name = g;
    }
    
    public String getName(){
        return name;
    }
    
    public void setSurname(String s){
        this.surname = s;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public String getFullName(){
        return name + " " + surname;
    }
    
    public void setUserName(String u){
        this.userName = u;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setEmail(String e){
        this.email = e;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setPassword(String p){
        this.password = p;
    }
    
    public String getPassword(){
        return password;
    }
    
    
    
}
