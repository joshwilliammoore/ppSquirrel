/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other.experimenting_with_java_ui;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;




import javax.swing.border.EmptyBorder;
/**
 *
 * @author Gregory
 */
public class Experiment {
    
    public Experiment()
    {
    //JLayeredPane jp = new JLayeredPane();
    //jp.setLayout(new GridBoxLayout());
        
    Color middleColour = Color.decode("#1a33d5");
    MatteBorder panelBorder = new MatteBorder(1,0,1,1, middleColour);
    MatteBorder panelBorder2 = new MatteBorder(1,1,1,0, middleColour);

    JFrame mainWindow = new JFrame();
    
    mainWindow.setLayout(new GridBagLayout());
    mainWindow.setResizable(false);
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setUndecorated(true);
    
    mainWindow.setBackground(new Color(0f,0f,0f,0f));
    Dimension size = new Dimension(900, 500);
    
    mainWindow.setSize(size);
    
    
    mainWindow.setLocationRelativeTo(null);
    
    
    
    GridBagConstraints gbc = new GridBagConstraints();
    
    
    //left empty panel
    JPanel leftSide = new JPanel();
    Dimension leftSize = new Dimension(200,400);
    Color leftColor = Color.WHITE;
    leftSide.setBorder(panelBorder2);
           leftSide.setBackground(leftColor);
           leftSide.setPreferredSize(leftSize);
           leftSide.setLayout(new GridLayout(2,0));
           
           
           Dimension labelSize = new Dimension(200,50);
           JButton text1 = new JButton();
                  text1.setText("Sign up");
                  text1.setForeground(Color.decode("#1a33d5"));
                  text1.setFont(new Font("Arial", Font.PLAIN, 30));
                  text1.setHorizontalTextPosition(JLabel.CENTER);
                  text1.setPreferredSize(labelSize);
                  text1.setBorder(new EmptyBorder(0,50,0,20));
           JButton text2 = new JButton();
                  text2.setText("Sign in");  
                  text2.setFont(new Font("Arial", Font.PLAIN, 30));
                  text2.setHorizontalTextPosition(JLabel.CENTER);
                  text2.setPreferredSize(labelSize);
                  text2.setBorder(new EmptyBorder(0,50,0,20));
                  text2.setForeground(Color.decode("#1a33d5"));




           leftSide.add(text1);
           leftSide.add(text2);
         
    
    gbc.gridx = 0;
    gbc.gridwidth=2;
    gbc.gridy = 2;
    gbc.gridheight = 8;
    
    mainWindow.add(leftSide, gbc);
    
    
    

       //middle section
       
    JPanel middleSide = new JPanel();
   
    middleSide.addMouseMotionListener(
        new MouseMotionListener ()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
            mainWindow.setLocation(e.getLocationOnScreen());
            }
             public void mouseMoved(MouseEvent e)
            {
           // mainWindow.setLocation(e.getLocationOnScreen());
            }
        
        } 
    
    
    );
    Dimension middleSize = new Dimension(300,500);
    
    
           middleSide.setBackground(middleColour);
           middleSide.setPreferredSize(middleSize);
           middleSide.setLayout(new GridBagLayout());
           
           //It doesn't have any effect on the positioning of the image. Why?
           gbc.gridx = 0;
           gbc.gridwidth=2;
           gbc.gridy = 0;
           gbc.gridheight = 3;
           
           ImageIcon ia;
           ia= new ImageIcon(this.getClass().getResource("logo_png_100.png"));
           JLabel logoContainer = new JLabel( ia); 
                  logoContainer.setText("Squirrel Tasker");
                  logoContainer.setHorizontalTextPosition(JLabel.CENTER);
                  logoContainer.setVerticalTextPosition(JLabel.BOTTOM);
                  logoContainer.setForeground(Color.WHITE);
                  logoContainer.setFont(new Font("Arial", Font.PLAIN, 22));
            myExiter exLis = new myExiter();
            logoContainer.addMouseListener(exLis);
            middleSide.add(logoContainer);      
    
    gbc.gridx = 2;
    gbc.gridwidth=3;
    gbc.gridy = 0;
    gbc.gridheight = 10;
    
    mainWindow.add(middleSide, gbc);
    
  

       //right section
    JPanel rightSide = new JPanel();
    rightSide.setLayout(new GridBagLayout());
    Dimension rightSize = new Dimension(400,400);
    Color rightColour = Color.WHITE;
    rightSide.setBorder(panelBorder);
    GridBagConstraints gbc2 = new GridBagConstraints();
           rightSide.setBackground(rightColour);
           rightSide.setPreferredSize(rightSize);
           
           
           JLabel emailL = new JLabel("Email:");
           JLabel nameL = new JLabel("Name:");

           JLabel userNameL = new JLabel("Username:");
           JLabel passwordL = new JLabel("Password:");
           MatteBorder formBorders =new MatteBorder(0, 0, 2, 0, middleColour);
           
           JLabel title = new JLabel("Sign up");
                  title.setFont(new Font("Arial", Font.PLAIN, 22));
                  
            JTextField name = new JTextField(); 
                       name.setText("Type your name here");
                       name.setBorder(formBorders);
                       name.setForeground(middleColour);
            JTextField userName =  new JTextField(); 
                       userName.setText("Type your username here"); 
                       userName.setBorder(formBorders);
                       userName.setForeground(middleColour); 
            JPasswordField password =  new JPasswordField();
                      password.setText("Type your password here");  
                      password.setBorder(formBorders);
                      password.setForeground(middleColour);
            JTextField email =  new JTextField(); 
                       email.setText("Type your email address here");
                       email.setBorder(formBorders);
                       email.setForeground(middleColour);
            JButton submit = new JButton("Go");
            submit.setBackground(middleColour);
            submit.setForeground(Color.WHITE);
            
            gbc2.gridx=0;
            gbc2.gridy=0;
            gbc2.gridwidth=2;
            gbc2.gridheight=1;
            gbc2.fill = GridBagConstraints.BOTH;
            gbc2.insets = new Insets(10,10,10,10);
            gbc2.ipadx=20;
            gbc2.ipady=20;
            gbc2.anchor = GridBagConstraints.CENTER;
            rightSide.add(title, gbc2);   
            
            gbc2.gridx=0;
            gbc2.gridy=1;
            gbc2.gridwidth=1;
            gbc2.gridheight=1;
            
            rightSide.add(nameL, gbc2);
            
            gbc2.gridx=1;

            rightSide.add(name, gbc2);
            
            gbc2.gridy=2;
            gbc2.gridx=0;
            rightSide.add(userNameL, gbc2);
            gbc2.gridx=1;
            rightSide.add(userName, gbc2);
           
          
            
            gbc2.gridy=3;
            gbc2.gridx=0;
            rightSide.add(passwordL, gbc2);
            gbc2.gridx=1;
            rightSide.add(password, gbc2);
            
            gbc2.gridy=4;
            gbc2.gridx=0;
            rightSide.add(emailL, gbc2);
            gbc2.gridx=1;
            rightSide.add(email, gbc2);
            
            gbc2.gridwidth=2;
            gbc2.gridx=0;
            gbc2.gridy=5;
            rightSide.add(submit, gbc2);
    gbc.gridx = 5;
    gbc.gridwidth=4;
    gbc.gridy = 2;
    gbc.gridheight = 8;
    
    mainWindow.add(rightSide, gbc);
    
    mainWindow.pack();
    mainWindow.setVisible(true);
    
    
    
    }
    class myExiter implements MouseListener
            {
                public void mousePressed(MouseEvent e)
                {
                    System.exit(0);
                }
                
                public void mouseReleased(MouseEvent e)
                {
                }
                
                public void mouseEntered(MouseEvent e)
                {
                }
                
                public void mouseExited(MouseEvent e)
                {
                }
                
                public void mouseClicked(MouseEvent e)
                {
                }
                
                
            } 
    
    
    
    
    
}
