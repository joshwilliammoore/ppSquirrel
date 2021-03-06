/*
 Class responsible for the logo of the application
 */
package com.maven.view.UIElements;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.maven.model.SquirrelConstants;
/**
 *
 * @author Regory Gregory
 */
public class Logo extends JLabel{
    
    private static Logo instance=null;
    private Logo()
    {
           super();
          
                  ImageIcon ia= new ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\com\\maven\\resources\\logo_png_100.png");
                  this.setIcon(ia); 
                  this.setHorizontalAlignment(JLabel.CENTER);
                  this.setIconTextGap(20);
                  this.setText(SquirrelConstants.getAppName());
                  this.setHorizontalTextPosition(JLabel.CENTER);
                  this.setVerticalTextPosition(JLabel.BOTTOM);
                  this.setForeground(SquirrelConstants.getLogoForeground());
                  this.setFont(SquirrelConstants.getLogoFont());


    }
    public static Logo getInstance()
    {
        if(instance==null){
            instance = new Logo();
        }
        return instance;
    }
}
