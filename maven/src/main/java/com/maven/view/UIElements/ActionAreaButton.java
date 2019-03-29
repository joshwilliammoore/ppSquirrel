/*
This package is intended to contain UI elements that could be used throughout the application
Where only one component of the UI uses an element, it has been moved to an inner class
such as ListEntry and MenuEntry
 */
package com.maven.view.UIElements;
import com.maven.Controller.ActionButtonController;
import com.maven.model.SquirrelConstants;
import javax.swing.JButton;
/**
 *
 * @author Regory Gregory
 */
public class ActionAreaButton extends JButton{
    public ActionAreaButton(String text)
    {
        super(text);
        this.addActionListener(new ActionButtonController());
        this.setBackground(SquirrelConstants.getActionAreaButtonBackground());
        this.setForeground(SquirrelConstants.getActionAreaButtonForeground());
        this.setMargin(SquirrelConstants.getActionBarButtonPadding());
    }
}
