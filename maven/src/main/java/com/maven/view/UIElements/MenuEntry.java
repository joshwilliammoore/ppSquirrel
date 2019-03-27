/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.UIElements;


import com.maven.Controller.ContentLoader;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import com.maven.model.SquirrelConstants;
import com.maven.Controller.MenuController;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
/**
 *
 * @author Regory Gregory
 */
public class MenuEntry extends JLabel{
     
    private String commandLabel;
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
    this.setCommandLabel("LISTVIEW:"+title.toUpperCase()+":0");

    this.setText(title);
     this.addMouseListener(new MouseAdapter(){
      public void mousePressed(MouseEvent e){
        MenuEntry parent = (MenuEntry) e.getSource();
        String text = parent.getCommandLabel().toUpperCase();
        ContentLoader.loadContent(text, null);
    }
     
     });
    }
     private void setDefaults()
     {
        
         this.setForeground(SquirrelConstants.getMenuEntryForeground());
         this.setFont(SquirrelConstants.getMenuEntryFont());
     }

    public String getCommandLabel() {
        return commandLabel;
    }

    public void setCommandLabel(String commandLabel) {
        this.commandLabel = commandLabel;
    }
     
}
