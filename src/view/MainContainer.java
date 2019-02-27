/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
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
        this.setSize(size);
        this.setResizable(false);
        //removes ugly title bar
        this.setUndecorated(SquirrelConstants.isRemoveDefaultMenuBar());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MainContainerPane mainPane = MainContainerPane.getInstance();
        this.add(mainPane);
        this.setLayout(new FlowLayout());
        this.pack();
        
       
    }
    public static MainContainer getInstance()
    {
        if(instance==null) {
            instance = new MainContainer();
        }
        return instance;
    }
}
