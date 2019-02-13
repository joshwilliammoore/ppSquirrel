/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JPanel;
import model.SquirrelConstants;

/**
 *
 * @author Regory Gregory
 */
public class LeftSide extends JPanel{
    
    private static LeftSide instance;
    private LeftSide()
    {
        super();
        int width =SquirrelConstants.getLeftSideWidth();
        int height =SquirrelConstants.getInnerPaneHeight();
    }
    
    //making it a singleton class
    public static LeftSide getInstance()
    {
    if(instance==null)
    {
        instance = new LeftSide();
    }
    return instance;
    }
}
