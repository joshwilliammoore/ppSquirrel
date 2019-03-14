/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.UIElements;

import com.maven.Controller.ActionButtonController;
import javax.swing.JCheckBox;
/**
 *
 * @author Regory Gregory
 */
public class ActionAreaCheckbox extends JCheckBox{
    public ActionAreaCheckbox()
    {
    super();
    this.addActionListener(new ActionButtonController());
    
    }
    
    
}
