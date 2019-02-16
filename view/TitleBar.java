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
    private int pHeight = SquirrelConstants.getTitleBarHeight();
    private String hexaColor = SquirrelConstants.getTitleBarBackground();
    private static TitleBar instance = null;
    
    public TitleBar()
    {
    super();
    this.setDim(new Dimension(700, 80));
    this.setSize(this.getDim());
    this.setPreferredSize(this.getDim());
    
    this.setBackground(Color.BLUE);
    }

    public int getpHeight() {
        return pHeight;
    }

    public void setpHeight(int height) {
        this.pHeight = height;
    }

    public String getHexaColor() {
        return hexaColor;
    }

    public void setHexaColor(String hexaColor) {
        this.hexaColor = hexaColor;
    }
    public static TitleBar getInstance()
    {
    if(instance == null) instance = new TitleBar();
    return instance;
    
    }

    
}
