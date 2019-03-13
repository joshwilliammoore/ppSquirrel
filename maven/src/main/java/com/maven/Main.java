/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven;

import javax.swing.*;
import java.awt.*;

import other.experimenting_with_java_ui.Experiment;
import com.maven.model.Task;
import com.maven.model.SubTask;
import com.maven.model.TaskList;

import java.util.Date;
import com.maven.view.MainContainer;

import javax.swing.JFrame;
import com.maven.view.TestFrame;
import com.maven.view.RightSideElements.ActionBar;
import com.maven.view.RightSideElements.HorizontalBar;
import com.maven.Controller.Init;
import com.maven.model.User;
import com.maven.view.*;
import com.maven.view.UIElements.TaskListView;

/**
 *
 * @author Gregory
 */
public class Main {
    public static void main(String[] args) {
        Init.init();
        
        
        MainContainer mainWindow = MainContainer.getInstance();
        mainWindow.setVisible(true);
//          JFrame testFrame = new TestFrame();
//         AddTaskListForm tForm = AddTaskListForm.getInstance();
        //gggJPanel test = new TaskListView.SubTaskView();
         // ab.setBackground(Color.RED);
        User tim = new User();
        tim.setGivenName("Tim");
        tim.setSurname("Howard");
        tim.setUserName("thoward37");
        tim.setEmail("timhoward37@hotmail.com");
        tim.setPassword("Something37");
        
        User ben = new User();
        ben.setGivenName("Ben");
        ben.setSurname("Dover");
        ben.setUserName("bDover123");
        ben.setEmail("bdover123@hotmail.com");
        ben.setPassword("SomethingElse123");
        
        User dave = new User();
        dave.setGivenName("Dave");
        dave.setSurname("Walker");
        dave.setUserName("dwalker01");
        dave.setEmail("davewalker@hotmail.com");
        dave.setPassword("Password1");
        
        User tom = new User();
        tom.setGivenName("Tom");
        tom.setSurname("Turner");
        tom.setUserName("tomturner8");
        tom.setEmail("tomTurner12@gmail.com");
        tom.setPassword("BadPassword");
        
        User frank = new User();
        frank.setGivenName("Frank");
        frank.setSurname("Castle");
        frank.setUserName("66franky66");
        frank.setEmail("frank.castle@hotmail.com");
        frank.setPassword("Password2");
        
        SubTask sub1 = new SubTask();
        sub1.setID(1);
        sub1.setTitle("Do something");
        sub1.setDescription("Do something else.");
        sub1.setDateDueString("12/12/2019");
        sub1.setPriority(4);
        sub1.setCompleted(true);
        sub1.setCreator(tim);
        sub1.setAssignee(ben);
        
        SubTask sub2 = new SubTask();
        sub2.setID(2);
        sub2.setTitle("Bake the potato");
        sub2.setDescription("Stab the potato and cook it.");
        sub2.setDateDueString("02/08/2020");
        sub2.setPriority(8);
        sub2.setCompleted(false);
        sub2.setCreator(tim);
        sub2.setAssignee(tim);
        
        SubTask sub3 = new SubTask();
        sub3.setID(3);
        sub3.setTitle("Assassination");
        sub3.setDescription("Assassinate someone");
        sub3.setDateDueString("30/06/2019");
        sub3.setPriority(1);
        sub3.setCompleted(true);
        sub3.setCreator(tim);
        sub3.setAssignee(ben);
        
        
         System.out.println(System.getProperty("user.dir")+"\\src\\main\\java\\com\\maven\\resources\\logo_png_100.png");
         System.out.println();
//          testFrame.add(tForm);
//          testFrame.setVisible(true);
          
    
    }
    
}
