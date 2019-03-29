/*
 This is a customised JTExtField class
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
    public String getText()
    {
        return super.getText();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
}
