/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
/**
 *
 * @author joshw
 */
public class LoginPage extends JFrame
{
    
    public JButton SUBMIT;
    JPanel panel;
    JLabel label1,label2;
    private JTextField text1,text2;
    private static LoginPage instance = null;
    
    public LoginPage(){
        super();
        label1 = new JLabel();
        label1.setText("Username:");
        text1 = new JTextField(15);
        
        label2 = new JLabel();
        label2.setText("Password:");
        text2 = new JTextField(15);
        //text2.setText("gggg");
        SUBMIT = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(3,1));
        panel.add(label1);
        panel.add(text1);
        panel.add(label2);
        panel.add(text2);
        panel.add(SUBMIT);
        add(panel,BorderLayout.CENTER);
        setTitle("Login Page");
        
        setSize(700,100);
        this.setLocationRelativeTo(null);
        
    }
    public static LoginPage getInstance()
    {
    if(instance== null)
    {
    instance = new LoginPage();
    }
    return instance;
    
    }

    public JButton getSUBMIT() {
        return SUBMIT;
    }

    public void setSUBMIT(JButton SUBMIT) {
        this.SUBMIT = SUBMIT;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }

    public JTextField getText1() {
        return text1;
    }

    public void setText1(JTextField text1) {
        this.text1 = text1;
    }

    public JTextField getText2() {
        return text2;
    }

    public void setText2(JTextField text2) {
        this.text2 = text2;
    }
    
}
