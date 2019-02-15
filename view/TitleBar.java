/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import model.SquirrelConstants;

/**
 *
 * @author Regory Gregory
 */
public class TitleBar extends HorizontalBar{
    private int height = SquirrelConstants.getTitleBarHeight();
    private String hexaColor = SquirrelConstants.getTitleBarBackground();
    
    public TitleBar()
    {
    super();
    this.setDim(new Dimension(this.getWidth(), this.getHeight()));
    this.setBackground(Color.decode(this.getHexaColor()));
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getHexaColor() {
        return hexaColor;
    }

    public void setHexaColor(String hexaColor) {
        this.hexaColor = hexaColor;
    }

    
}
