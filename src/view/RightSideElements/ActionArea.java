/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.RightSideElements;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
/**
 *
 * @author Regory Gregory
 */
public class ActionArea extends HorizontalBar {
    private static ActionArea instance = null;
    private ActionArea()
    {
        super();
        this.setBackground(Color.PINK);
        this.setDim(new Dimension(700, 300));
        this.setSize(this.getDim());
        this.setPreferredSize(this.getDim());
        
    
    }
    
    public static ActionArea getInstance(){
        if(instance == null) instance = new ActionArea();
        return instance;
    }
    public static void reFresh(Component c)
    {
    instance.removeAll();
    instance.add(c);    
    instance.revalidate();
    instance.repaint();
    }
            
}
