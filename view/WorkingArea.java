/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import model.SquirrelConstants;
import java.awt.Color;
/**
 *
 * @author Regory Gregory
 */
public class WorkingArea extends HorizontalBar{
    
    private int height = SquirrelConstants.getWorkingAreaHeight();
    private String hexaColor = SquirrelConstants.getWorkingAreaBackground();
    
    
    public WorkingArea()
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
