/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.UIElements;


import javax.swing.JLabel;
import javax.swing.ImageIcon;
import model.SquirrelConstants;
import Controller.MenuController;
/**
 *
 * @author Regory Gregory
 */
public class MenuEntry extends JLabel{
     
    
    public MenuEntry(String title, ImageIcon logo)
    {
    super();
    this.setDefaults();
    this.setText(title);
    this.setIcon(logo);
    this.addMouseListener(new MenuController());
    }
     public MenuEntry(String title)
    {
    super();
    this.setDefaults();

    this.setText(title);
     this.addMouseListener(new MenuController());
    }
     private void setDefaults()
     {
        
         this.setForeground(SquirrelConstants.getMenuEntryForeground());
         this.setFont(SquirrelConstants.getMenuEntryFont());
     }
}
