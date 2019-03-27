/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view;

import javax.swing.*;
import java.awt.*;
import com.maven.model.SquirrelConstants;
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
        Logo sLogo = Logo.getInstance();
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill=GridBagConstraints.BOTH;
        gbc.ipadx=0;
        gbc.ipady=20;
        gbc.gridx =0;
        gbc.gridy =0;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        //gbc.insets=new Insets(0, 0, 0, 0);

        panel.add(sLogo, gbc);
        gbc.insets=new Insets(0, 0, 0, 0);
        gbc.gridwidth=1;
        gbc.gridx =0;

        gbc.gridy =1;

        
        label1 = new JLabel();
        label1.setText("Username:");
        label1.setForeground(SquirrelConstants.getColorLight());
        
        panel.add(label1, gbc);
        text1 = new JTextField(15);
        
        gbc.gridx=1;
        gbc.gridwidth=1;

        panel.add(text1, gbc);
        
        
        
        
        label2 = new JLabel();
        
        label2.setText("Password:");
        label2.setForeground(SquirrelConstants.getColorLight());

        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=1;

        panel.add(label2, gbc);
        
        text2 = new JPasswordField(15);
        gbc.gridx=1;
        gbc.gridwidth=1;

        panel.add(text2, gbc);
        
        
        //text2.setText("gggg");
        SUBMIT = new JButton("SUBMIT");
        
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=2;
        
  
       
        panel.add(SUBMIT, gbc);
        this.add(panel);
        //add(panel,BorderLayout.CENTER);
        setTitle("Login Page");
        
        setSize(300,700);
        panel.setBackground(SquirrelConstants.getColorPrimary());
        panel.setForeground(SquirrelConstants.getColorLight());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
