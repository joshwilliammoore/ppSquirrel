/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import model.SquirrelConstants;
/**
 *
 * @author Regory Gregory
 */
public class MainContainer extends JFrame{
    public MainContainer()
    {
        super();
        Dimension size = SquirrelConstants.getMainContainerWidth();
        this.setPreferredSize();
    
    
    }
}
