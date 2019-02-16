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
/**
 *
 * @author Regory Gregory
 */
public class ActionBar extends HorizontalBar{
    private int height = SquirrelConstants.getActionBarHeight();
    private String hexaColor = SquirrelConstants.getActionBarBackground();
    
    public ActionBar()
    {
        super();
        this.setDim(new Dimension(this.getWidth(), this.getHeight()));
        JOptionPane.showMessageDialog(null, "hello world");
        
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
        this.getGbc().gridx = 4;
        this.getGbc().gridwidth = 5;
        this.add(jtf, this.getGbc());
    }
}
