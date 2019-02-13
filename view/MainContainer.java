/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import model.SquirrelConstants;
import javax.swing.JOptionPane;
/**
 *
 * @author Regory Gregory
 */
public class MainContainer extends JFrame{
    private int width = SquirrelConstants.getMainContainerWidth();
    private int height = SquirrelConstants.getMainContainerHeight(); 
    
    private int leftSideWidth = SquirrelConstants.getLeftSideWidth();
    
    private int rightSideWidth = SquirrelConstants.getRightSideWidth();
    
    private int innerPanelHeight = SquirrelConstants.getInnerPaneHeight();
    
    private static MainContainer instance;
    //private int innerElementHeight = SquirrelConstants.
    private MainContainer()
    {
        
        super();
        Dimension size = new Dimension (this.width, this.height);
        //Setting default layout
        
        // it is the margin:0px auto equivalent :))) ->center aligning the main window.
        
        //disables resizability
        this.setResizable(false);
        //removes ugly title bar
        this.setUndecorated(SquirrelConstants.isRemoveDefaultMenuBar());
        
        
        this.setLayout(new GridBagLayout());
        this.setSize(size);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setLocationRelativeTo(null);
        //setting the grid for component elements -right and left side
        
        //set elements width and height
        //set background colour
        GridBagConstraints  gbc = new GridBagConstraints();
        
        LeftSide leftSide = LeftSide.getInstance();

        gbc.gridx = 0;
        gbc.gridy = 0;
        //this should be made constant later on so the ui will be totally configurable by editing one file
        gbc.gridwidth=3;
        gbc.gridheight =6;
        
        gbc.fill = GridBagConstraints.BOTH;
        //adding left panel
        this.add(leftSide, gbc);
        
        //configuring right panel
        RightSide rightSide = RightSide.getInstance();
        //This doesn't work. WHYYYY?
        gbc.gridx =1;
        gbc.gridy = 0;
        gbc.gridwidth=7;
        gbc.gridheight =6;
       
        this.add(rightSide, gbc);
        JOptionPane.showMessageDialog(null, rightSide.getWidth());
        
        
       
    }
    public static MainContainer getInstance()
    {
        if(instance==null) {
            instance = new MainContainer();
        }
        return instance;
    }
}
