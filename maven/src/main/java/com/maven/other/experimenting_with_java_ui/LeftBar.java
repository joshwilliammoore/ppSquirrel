package com.maven.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class LeftBar extends JPanel{
	public LeftBar(MenuEntry[] menuEntries) 
	{
		FlowLayout componentLayout = new FlowLayout();
		this.setLayout(componentLayout);
		
		Dimension preferredSize = new Dimension(200, 600);
		this.setPreferredSize(preferredSize);
		
		float redChannel = Utils.RGBto1(108);
		float greenChannel = Utils.RGBto1(39);
		float blueChannel = Utils.RGBto1(137);
		
		Color bgColour = new Color(redChannel, greenChannel, blueChannel);
		
		this.setBackground(bgColour);
                
		//HAHAAAA - fixed the relative path - still need to figure out why
                ImageIcon logoImage = new ImageIcon(getClass().getResource("logo_png_100.png"));
                JLabel logo = new  JLabel();
                logo.setVerticalTextPosition(JLabel.BOTTOM);
                logo.setHorizontalTextPosition(JLabel.CENTER);  
                logo.setIcon(logoImage);
                logo.setForeground(Color.white);

                logo.setText("SquirrelTasker");
                logo.setFont(new Font("Arial", Font.PLAIN, 24));
                this.add(logo);
                
		for (int i=0; i<menuEntries.length; i++) 
		{
			
			
			
			this.add(menuEntries[i]);
			

			
		}
		
		
	}

}
