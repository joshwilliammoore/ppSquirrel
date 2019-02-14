/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.SquirrelConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
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
        
 
        int size = SquirrelConstants.getHorizontalPaneHeight().length;
        int[] hHeights = SquirrelConstants.getHorizontalPaneHeight();
        String[] hColors = SquirrelConstants.getHorizontalPaneColor();
        int offset=0;
        for(int i =0; i<size; i++ )
        {
        JPanel temp = new JPanel();
        temp.setBackground(Color.decode(hColors[i]));
        temp.setPreferredSize(new Dimension(700, hHeights[i]));
        
        this.gbc.gridx=0;
        
        this.gbc.gridy= offset;
        
        this.gbc.gridheight=hHeights[i]/10;
        this.add(temp, this.gbc);
        offset+=hHeights[i]/10;
        }
       
        
     
    }
    
        //making it a singleton class

    public static  RightSide getInstance()
    {
    if(instance==null)
    {
        instance = new RightSide();
    }

        return instance;
    }
   
}
