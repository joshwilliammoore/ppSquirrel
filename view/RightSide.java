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
import javax.swing.JOptionPane;
/**
 *
 * @author Regory Gregory
 */
public class RightSide extends GeneralPanel{
    private static RightSide instance = null;
    private static HorizontalBar[] bars= new HorizontalBar[3];
    private static HorizontalBar actionBar;
    private static HorizontalBar workingArea;
    public RightSide()
    {
        super(SquirrelConstants.getRightSideWidth(), SquirrelConstants.getInnerPaneHeight());
      
        this.setBackground(SquirrelConstants.getRightSideBg());
        
        
        int size = SquirrelConstants.getHorizontalPaneHeight().length;
        int[] hHeights = SquirrelConstants.getHorizontalPaneHeight();
        String[] hColors = SquirrelConstants.getHorizontalPaneColor();
        
        
        this.bars[0] = TitleBar.getInstance();
        
        this.bars[1] = ActionBar.getInstance();
        
        this.bars[2] = WorkingArea.getInstance();
        
        int offset=0;
        
        
        for(int i =0; i<this.bars.length; i++ )
        {
        HorizontalBar temp = this.bars[i];
        this.gbc.gridx=0;
        
        this.gbc.gridy= offset;
        
        this.gbc.gridheight=temp.getHeight()/10;
        
        
        this.add(temp, this.gbc);
        
        offset+=temp.getHeight()/10;
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
