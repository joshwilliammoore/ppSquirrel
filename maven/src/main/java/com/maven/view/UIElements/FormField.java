/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.view.UIElements;
import javax.swing.JTextField;
/**
 *
 * @author Regory Gregory
 */
public class FormField extends JTextField implements GetUIContent{
    private String label;
    
    public FormField()
    {
    super();
    }
    
    
    public FormField(String s)
    {
    super(s);
    }
    public String getContent()
            {
            return this.getText();
            
            }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
}
