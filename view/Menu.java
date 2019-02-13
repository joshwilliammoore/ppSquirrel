/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JPanel;
import java.awt.GridLayout;
import model.SquirrelConstants;
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
}
