/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other.experimenting_with_java_ui;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.Point;
/**
 *
 * @author Gregory
 */
public class BasicButtonAction implements MouseMotionListener, MouseListener{
    
    private boolean thisMousePressed = false;
    private JFrame parent;
    
    public BasicButtonAction (JFrame parenti)
    {
        this.parent = parenti;
    }
    public void mousePressed(MouseEvent e)
    {
        this.thisMousePressed = true;
        //JOptionPane.showMessageDialog(null, "I have been pressed");
        
    }
    public void mouseClicked(MouseEvent e)
    {
    
    }
    public void mouseExited(MouseEvent e)
    {
    
    }
    public void mouseEntered(MouseEvent e)
    {
    
    
    }
    public void mouseReleased(MouseEvent e)
    {
        this.thisMousePressed = false;
    }
    
    public void mouseMoved(MouseEvent e)
    {
                  

    }
    public void mouseDragged(MouseEvent e)
    {
          if(this.thisMousePressed == true)
        {
           // JOptionPane.showMessageDialog(null, "I have been pressed");
             parent.setLocation(e.getLocationOnScreen());
        }
         
    }
}
