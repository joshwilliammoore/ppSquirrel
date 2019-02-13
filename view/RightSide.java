/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.SquirrelConstants;
/**
 *
 * @author Regory Gregory
 */
public class RightSide extends GeneralPanel{
    private static RightSide instance = null;
    public RightSide()
    {
        super(SquirrelConstants.getRightSideWidth(), SquirrelConstants.getInnerPaneHeight());
      
        this.setBackground(SquirrelConstants.getRightSideBg());
     
    }
    public static  RightSide getInstance()
    {
    if(instance==null)
    {
        instance = new RightSide();
    }
//    return instance;
//        instance = new RightSide();
        return instance;
    }
    //making it a singleton class
   
}
