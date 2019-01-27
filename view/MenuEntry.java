import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

public class MenuEntry extends JLabel {
	public MenuEntry(String label) 
	{
		super(label);
		this.setForeground(Color.white);
		this.setHorizontalAlignment(CENTER);
		Dimension d = new Dimension(200,40);
		this.setFont(new Font("Arial", Font.PLAIN, 30));
		//this.setBorder(new EmptyBorder(40,40,40,40));
		this.setMinimumSize(d);
		this.setPreferredSize(d);
	}
	
}
