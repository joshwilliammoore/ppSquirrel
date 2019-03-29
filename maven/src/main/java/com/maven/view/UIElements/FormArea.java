/*
 This is a customised JTextArea class
 */
package com.maven.view.UIElements;
import javax.swing.JTextArea;
/**
 *
 * @author Regory Gregory
 */
public class FormArea extends JTextArea implements GetUIContent{
    private String label;
    
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
