/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.ArrayList;
/**
 *
 * @author joshw
 */
public class User {
    private String givenName;
    private String surname;
    private Role role;
    private String username;
    private String email;
    private String password;
    private ArrayList<String> createdTasks = new ArrayList<String>();
    private ArrayList<String> ownedTasks = new ArrayList<String>();
    private ArrayList<String> assignedTasks = new ArrayList<String>();
    
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
    
    public void setUsername(String u){
        this.username = u;
    }
    
    public String getUsername(){
        return username;
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
