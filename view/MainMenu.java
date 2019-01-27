import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class MainMenu extends JFrame{
	
	public MainMenu() {
		this.setResizable(true);
		GridBagLayout gl = new GridBagLayout();
		this.setLayout(gl);
		
	
		
		
		
		
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	MenuEntry[] menuEntries = {new MenuEntry("Home"), new MenuEntry("TaskLists"), new MenuEntry("About")};
	
	LeftBar lb = new LeftBar(menuEntries);
	
	
	GridBagConstraints c= new GridBagConstraints();
	
	c.gridx=0;
	c.gridwidth=1;
	
	this.add(lb, c);
	
	
	
	
	
	c.gridx=1;
	c.gridwidth=4;
	
	RightBar rb = new RightBar();
	
	
	this.add(rb, c);
	
	this.setMinimumSize(new Dimension(1000,600));
	this.pack();
	this.setVisible(true);
	
	
	
	
	}
	
	
}
