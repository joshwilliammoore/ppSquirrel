/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other.experimenting_with_java_ui;

/**
 *
 * @author Gregory
 */

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;

public class EventListenerExp {
    
    public static void test(){
            JFrame mainWindow = new JFrame("mainWindow");    
            mainWindow.setLayout(new FlowLayout());
            mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JButton btn = new JButton("Press me");
            BasicButtonAction bba = new BasicButtonAction(mainWindow);
            mainWindow.addMouseListener(bba);
            mainWindow.addMouseMotionListener(bba);
            
            Dimension d = new Dimension (300,300);
            mainWindow.setSize(d);
            mainWindow.add(btn);
            mainWindow.setVisible(true);


    }
    
    public static void main(String[] args)
    {
    test();
        
    }
   
    
    
}
