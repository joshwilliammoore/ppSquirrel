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
    private String givenName;
    private String surname;
    private int role;
    private String userName;
    private String email;
    private String password;
    public User(){}
    public User(String name, String password, int userLevel){
       setGivenName(name);
       setSurname(name);
       setUserName(name);
       setPassword(password);
       setEmail(name+"@hotmail.com");
       setRole(userLevel);
    }
    
    
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    
    public void setGivenName(String g){
        this.givenName = g;
    }
    
    public String getGivenName(){
        return givenName;
    }
    
    public void setSurname(String s){
        this.surname = s;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public String getFullName(){
        return givenName + " " + surname;
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
