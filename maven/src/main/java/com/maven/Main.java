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
import com.maven.view.*;

/**
 *
 * @author Gregory
 */
public class Main {
    public static void main(String[] args) {
        MainContainer mainWindow = MainContainer.getInstance();
        mainWindow.setVisible(true);
//          JFrame testFrame = new TestFrame();
//         AddTaskListForm tForm = AddTaskListForm.getInstance();
        
         // ab.setBackground(Color.RED);
         System.out.println(System.getProperty("user.dir")+"\\src\\main\\java\\com\\maven\\resources\\logo_png_100.png");
         System.out.println();
//          testFrame.add(tForm);
//          testFrame.setVisible(true);
          
    
    }
    
}
