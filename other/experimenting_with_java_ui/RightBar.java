package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Image;


public class RightBar extends JPanel{
	public RightBar() 
	{
		float redChannel = Utils.RGBto1(255);
		float greenChannel = Utils.RGBto1(255);
		float blueChannel = Utils.RGBto1(255);
		
		Color bgColour = new Color(redChannel, greenChannel, blueChannel);
		this.setBackground(bgColour);
                
                
	
		Dimension preferredSize = new Dimension(800, 600);
		this.setPreferredSize(preferredSize);
		
	}
	
}
