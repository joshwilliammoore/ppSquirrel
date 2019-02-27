package com.maven.view;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MenuEntry extends JButton {
	public MenuEntry(String label) 
	{
		super(label);
		this.setForeground(Color.white);
		this.setHorizontalAlignment(CENTER);
		Dimension d = new Dimension(200,40);
		this.setFont(new Font("Arial", Font.PLAIN, 24));
                
                float redChannel = Utils.RGBto1(108);
		float greenChannel = Utils.RGBto1(39);
		float blueChannel = Utils.RGBto1(137);
		
		Color bgColour = new Color(redChannel, greenChannel, blueChannel);
                
                this.setOpaque(true);
                this.setBackground(bgColour);
                //this.Button.highlight(new Color(1f,1f,1f));
		//this.setBorder(new EmptyBorder(40,40,40,40));
		this.setMinimumSize(d);
		this.setPreferredSize(d);
                //adds ugly border for the last pressed button around the text box
                this.setFocusPainted(false);
                Color hoverColor = new Color(1f,1f,1f);
                //ugly border around the button box.
                this.setBorder(null);
                
	}
        
        
        
    
	
}
