/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven;

import com.maven.Controller.DataHandler;
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
import com.maven.view.UIElements.Menu;
import com.maven.Controller.WebTest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author Gregory
 */
public class Main {
    public static void main(String[] args) {
//     Date result = null;  
//     SimpleDateFormat smf = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa");
//     try{
//        result = smf.parse("Mar 4, 2019 4:27:05 PM");
// 
//     } catch (ParseException e)
//     {
//         e.getStackTrace();
//     }
//         System.out.println("Parsed dateTime:");
//
//     System.out.println(result.getTime());
//        
        
////        
//        Task[] result = null;
//        System.out.println(result);
//            WebTest w = new WebTest();
//            try{
//                
//            
//            result = w. getWebLists();
//            }
//            catch(Exception e)
//            {
//            e.printStackTrace();
//            }
//            System.out.println("Test output:");
//            result[1].getSubtasks().get(0).JSONCorrection();
//            System.out.println(result[1].getSubtasks().get(0).getDateDueString());
//           
        Init.init();
        
        MainContainer mainWindow = MainContainer.getInstance();
        mainWindow.setVisible(true);
        //javax.swing.JOptionPane.showMessageDialog(null, DataHandler.getUsers().size());

//          JFrame testFrame = new TestFrame();
//         AddTaskListForm tForm = AddTaskListForm.getInstance();
        //gggJPanel test = new TaskListView.SubTaskView();
         // ab.setBackground(Color.RED);
       
//        
//        SubTask sub1 = new SubTask();
//        sub1.setTitle("Do something");
//        sub1.setDescription("Do something else.");
//        sub1.setDateDueString("12/12/2019");
//        sub1.setPriority(4);
//        sub1.setCompleted(true);
//        sub1.setCreator(tim);
//        sub1.setAssignee(ben);
//        
//        SubTask sub2 = new SubTask();
//        sub2.setTitle("Bake the potato");
//        sub2.setDescription("Stab the potato and cook it.");
//        sub2.setDateDueString("02/08/2020");
//        sub2.setPriority(8);
//        sub2.setCompleted(false);
//        sub2.setCreator(tim);
//        sub2.setAssignee(tim);
//        
//        SubTask sub3 = new SubTask();
//        sub3.setTitle("Assassination");
//        sub3.setDescription("Assassinate someone");
//        sub3.setDateDueString("30/06/2019");
//        sub3.setPriority(1);
//        sub3.setCompleted(true);
//        sub3.setCreator(tim);
//        sub3.setAssignee(ben);
        
        
         System.out.println(System.getProperty("user.dir")+"\\src\\main\\java\\com\\maven\\resources\\logo_png_100.png");
         System.out.println();
//          testFrame.add(tForm);
//          testFrame.setVisible(true);
          
    
    }
    
}
