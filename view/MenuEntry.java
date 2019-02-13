/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import javax.swing.JLabel;
import javax.swing.ImageIcon;
import model.SquirrelConstants;
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
    }
     public MenuEntry(String title)
    {
    super();
    this.setDefaults();

    this.setText(title);
    }
     private void setDefaults()
     {
         this.setBackground(SquirrelConstants.getMenuEntryBg());
         this.setForeground(SquirrelConstants.getMenuEntryForeground());
         this.setFont(SquirrelConstants.getMenuEntryFont());
     }
}
