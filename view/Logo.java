/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.SquirrelConstants;
/**
 *
 * @author Regory Gregory
 */
public class Logo extends JLabel{

    private Logo()
    {
           super();
          
                  ImageIcon ia= new ImageIcon(getClass().getResource("../resources/logo_png_100.png"));
                  this.setIcon(ia); 
                  this.setText(SquirrelConstants.getAppName());
                  this.setHorizontalTextPosition(JLabel.CENTER);
                  this.setVerticalTextPosition(JLabel.BOTTOM);
                  this.setForeground(SquirrelConstants.getLogoForeground());
                  this.setFont(SquirrelConstants.getLogoFont());


    }
}
