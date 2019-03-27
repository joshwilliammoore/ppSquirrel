/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.UIElements;
import com.maven.Controller.ContentLoader;
import com.maven.Controller.MenuController;
import javax.swing.JPanel;
import java.awt.GridLayout;
import com.maven.model.SquirrelConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author Regory Gregory
 */
public class Menu extends JPanel{
    private static Menu instance=null;
    private Menu()
    {
    super();
    this.setLayout(new GridLayout(0,1));
    String[] menuEntries = SquirrelConstants.getMenuEntries();
    this.setBackground(SquirrelConstants.getMenuEntryBg());
    for(String m : menuEntries)
    {
        MenuEntry temp = new MenuEntry(m);
        this.add(temp);
    }
    
    
    }
    public static Menu getInstance()
    {
    if(instance==null)
    {
    instance = new Menu();
    }
    return instance;
    
    }
    
    
    
public class MenuEntry extends JLabel{
     
    private String commandLabel;
    public MenuEntry(String title, ImageIcon logo)
    {
    super();
    this.setDefaults();
    this.setText(title);
    this.setIcon(logo);
    
    }
       private MenuEntry(String title)
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
}
