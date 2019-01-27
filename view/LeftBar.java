import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		
		for (int i=0; i<menuEntries.length; i++) 
		{
			
			
			
			this.add(menuEntries[i]);
			

			
		}
		
		
	}

}
