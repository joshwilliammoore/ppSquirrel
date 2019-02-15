/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Dimension;
/**
 *
 * @author Regory Gregory
 */
public class TestFrame extends JFrame{
    public TestFrame()
    {
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1000,1000));
        this.setPreferredSize(new Dimension(1000,1000));

    }
}
