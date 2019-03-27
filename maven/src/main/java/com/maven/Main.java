/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven;

import com.maven.Controller.DataHandler;
import javax.swing.*;
import com.maven.view.MainContainer;
import com.maven.Controller.Init;
import com.maven.view.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
/**
 *
 * @author Gregory
 */
public class Main {
    public static void main(String[] args) {

        Init.init();
        //ActionListner al = new Actiojn
        LoginPage loginP = LoginPage.getInstance();
        
        loginP.SUBMIT.addActionListener(new ActionListener(){
        String x = "";    
        public void actionPerformed(ActionEvent e){
        String userName = loginP.getText1().getText();
        String password = loginP.getText2().getText();

        if(DataHandler.checkLogin(userName, password)){
          MainContainer mainWindow = MainContainer.getInstance();
          mainWindow.setVisible(true); 
          LoginPage login = LoginPage.getInstance();
          login.setVisible(false);
          
        } else{
            JOptionPane.showMessageDialog(null,"Invalid credentials");
          
        }
        
        
        
        }
        });
        loginP.setVisible(true);
//        MainContainer mainWindow = MainContainer.getInstance();
//        mainWindow.setVisible(true);
//
//        
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
