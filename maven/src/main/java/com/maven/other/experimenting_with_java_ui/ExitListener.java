/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other.experimenting_with_java_ui;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
/**
 *
 * @author Gregory
 */
public class ExitListener implements MouseListener{
   
    public void mousePressed(MouseEvent e){}
    public void mouseClicked(MouseEvent e){
    System.exit(0);
    }
    public void mouseReleased(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    
}
