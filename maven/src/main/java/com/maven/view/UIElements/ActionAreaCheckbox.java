/*
 Checkbox class allowing for custom styling
 */
package com.maven.view.UIElements;

import com.maven.Controller.ActionButtonController;
import com.maven.model.SquirrelConstants;
import javax.swing.JCheckBox;
/**
 *
 * @author Regory Gregory
 */
public class ActionAreaCheckbox extends JCheckBox{
    public ActionAreaCheckbox()
    {
    super();
    this.addActionListener(new ActionButtonController());
    this.setMargin(SquirrelConstants.getCheckBoxPAdding());
    }
    
    
}
