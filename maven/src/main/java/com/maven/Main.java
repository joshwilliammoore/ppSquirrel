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

        Init.init();
        
        MainContainer mainWindow = MainContainer.getInstance();
        mainWindow.setVisible(true);

        
        System.out.println(System.getProperty("user.dir")+"\\src\\main\\java\\com\\maven\\resources\\logo_png_100.png");
//        SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        String testee = "02/02/2019 11";
//        try
//        {
//            smf.parse(testee);
//            System.out.println("good");
//        }catch(Exception e)
//        {
//            System.out.println("Wrong");
//        }
//        // [0-3]{}    
          
    
    }
    
}
