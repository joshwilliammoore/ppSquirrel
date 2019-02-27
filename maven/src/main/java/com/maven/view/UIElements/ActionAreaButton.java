/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.UIElements;
import com.maven.Controller.ActionButtonController;
import javax.swing.JButton;
/**
 *
 * @author Regory Gregory
 */
public class ActionAreaButton extends JButton{
    public ActionAreaButton(String text)
    {
        super(text);
        this.addActionListener(new ActionButtonController());
    }
}
