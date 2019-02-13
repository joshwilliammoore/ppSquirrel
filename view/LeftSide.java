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
public class LeftSide extends GeneralPanel{
    
    private static LeftSide instance = null;
    public LeftSide()
    {
      super(SquirrelConstants.getLeftSideWidth(), SquirrelConstants.getInnerPaneHeight());

//     super(SquirrelConstants.getLeftSideWidth(), SquirrelConstants.getInnerPaneHeight());
     this.setBackground(SquirrelConstants.getLeftSideBg());
        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        this.gbc.gridwidth = 1;
        this.gbc.gridheight = 1;
        this.add(Logo.getInstance(), this.gbc);
    }
    
    
    
    
     public static  LeftSide getInstance()
    {
    if(instance==null)
    {
        instance = new LeftSide();
    }
    return instance;
      
    }
    //making it a singleton class
 
}
