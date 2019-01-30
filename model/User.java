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
    private String familyName;
    private Role role;
    private String username;
    private String email;
    private String password;
    private ArrayList<String> createdTasks = new ArrayList<String>();
    private ArrayList<String> ownedTasks = new ArrayList<String>();
    private ArrayList<String> assignedTasks = new ArrayList<String>();
    
    
}
