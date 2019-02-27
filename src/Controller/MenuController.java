/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import view.UIElements.MenuEntry;
/**
 *
 * @author Regory Gregory
 */
public class MenuController implements MouseListener{
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){
    }
    public void mousePressed(MouseEvent e){
     MenuEntry parent = (MenuEntry) e.getSource();
    String text = parent.getText().toUpperCase();
    
    ContentLoader.loadContent(text, null);
    }
    public void mouseReleased(MouseEvent e){}
    
}
