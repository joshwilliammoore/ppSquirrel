/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.UIElements;


import javax.swing.JButton;
import com.maven.model.SquirrelConstants;
/**
 *
 * @author Regory Gregory
 */
public class ActionBarButton extends JButton{
    
   //default formatting should be done here later on...
    
    
    public ActionBarButton (String label)
    {
    this.setText(label);
    this.setBackground(SquirrelConstants.getActionButtonBackground());
    this.setForeground(SquirrelConstants.getActionButtonForeground());
    this.setMargin(SquirrelConstants.getActionButtonPadding());
   
    }
  
}
