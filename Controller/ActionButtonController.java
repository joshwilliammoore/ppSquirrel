/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author Regory Gregory
 */
public class ActionButtonController implements ActionListener{
    public  void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        String[] subCommands = command.split(":");
        
        switch(subCommands[0])
        {
            case "NEW":

                   ContentLoader.loadContent(command, null);
                break;
            case "SAVE":

                break;
            case "EDIT":
                break;
            case "SEARCH":
                break;
            case "VIEW":
                break;
            case "CANCEL":
                break;
        
        
        
        }
        
    }
}
