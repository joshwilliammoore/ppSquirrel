/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.UIElements;
import javax.swing.JComboBox;
/**
 *
 * @author Regory Gregory
 */
public class FormCombo extends JComboBox implements GetUIContent{
    private String label;
    
    public FormCombo(Object[] s)
    {
    super(s);
    }
    
    
    public String getContent()
    {
    return (String) this.getSelectedItem();
    
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
}
