/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import com.maven.model.SquirrelConstants;
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
        this.setLayout(new BorderLayout());
        Dimension size = new Dimension (this.width, this.height);
        this.setSize(size);
        this.setResizable(true);
        //removes ugly title bar
        this.setUndecorated(SquirrelConstants.isRemoveDefaultMenuBar());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
//        MainContainerPane mainPane = MainContainerPane.getInstance();
        this.add(LeftSide.getInstance(), BorderLayout.WEST);
        this.add(RightSide.getInstance(), BorderLayout.CENTER);
     
       
    }
    public static MainContainer getInstance()
    {
        if(instance==null) {
            instance = new MainContainer();
        }
        return instance;
    }
}
