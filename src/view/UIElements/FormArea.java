/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.UIElements;
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
