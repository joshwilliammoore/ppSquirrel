/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JButton;
import javax.swing.JTextField;
import model.SquirrelConstants;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.GridBagConstraints;
/**
 *
 * @author Regory Gregory
 */
public class ActionBar extends HorizontalBar{
    private int pHeight = SquirrelConstants.getActionBarHeight();
    private String hexaColor = SquirrelConstants.getActionBarBackground();
    private static ActionBar instance = null;
    public ActionBar()
    {
        super();
        this.setDim(new Dimension(this.getpWidth(), this.getpHeight()));
        this.setSize(this.getDim());
        this.setPreferredSize(this.getDim());
        this.setBackground(Color.RED);
        this.getGbc().fill = GridBagConstraints.HORIZONTAL;
        
        this.getGbc().gridx=0;
        this.getGbc().gridy=0;
        this.getGbc().gridwidth=2;
        this.getGbc().gridheight=1;
        
        JButton jb = new JButton("Add new");
        this.add(jb, this.getGbc());
        
        JButton jb2 = new JButton("Search");
        this.getGbc().gridx=2;
        this.add(jb2, this.getGbc());
        
        
        JTextField jtf = new JTextField();
        jtf.setSize(new Dimension(300, 50));
        jtf.setPreferredSize(new Dimension(300, 50));

        this.getGbc().gridx = 4;
        this.getGbc().gridwidth = 5;
        this.add(jtf, this.getGbc());
    }
    public static ActionBar getInstance()
    {
    if(instance == null) instance = new ActionBar();
    return instance;
    
    }
}
