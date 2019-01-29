/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Color;

/**
 *
 * @author Gregory
 */
public class GridBagEx {
    public GridBagEx()
    {
        JFrame mainWindow = new JFrame("Grid Bag Experiment");
        
        mainWindow.setLayout(new GridBagLayout());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.ipadx = 50;
        gbc.ipady=50;
        gbc.insets = new Insets(10,10,10,10);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        JButton jb1 = new JButton("NORTH");
        JButton jb2 = new JButton("WEST");
        JButton jb3 = new JButton("EAST");
        JButton jb4 = new JButton("SOUTH");
        JButton jb5 = new JButton("DOUBLED");
        
                gbc.gridx=1;
                gbc.gridy=0;
                gbc.gridwidth =1;
                gbc.gridheight=1;
                
            mainWindow.add(jb1, gbc);
                gbc.gridx=0;
                gbc.gridy=1;
                gbc.gridwidth =1;
                gbc.gridheight=1;
            mainWindow.add(jb2, gbc);
                gbc.gridx=2;
                gbc.gridy=1;
                gbc.gridwidth =1;
                gbc.gridheight=1;
            mainWindow.add(jb3, gbc);
                gbc.gridx=1;
                gbc.gridy=2;
                gbc.gridwidth =1;
                gbc.gridheight=1;
            mainWindow.add(jb4, gbc);
                gbc.gridx=0;
                gbc.gridy=3;
                gbc.gridwidth =3;
                gbc.gridheight=1;
                gbc.fill=GridBagConstraints.BOTH;
            mainWindow.add(jb5, gbc);
            
            Dimension mainSize = new Dimension(600,600);
            
            mainWindow.setSize(mainSize);
            mainWindow.setResizable(false);
            
            
            mainWindow.setVisible(true);

    
    }
}
