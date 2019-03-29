/*******************************************************************************
This class is responsible for initialising singleton classes and loading data to 
* be ready for login checking for instance
 ******************************************************************************/ 
package com.maven.Controller;

import com.maven.model.SquirrelConstants;
import com.maven.view.RightSideElements.ActionBar;
import com.maven.view.RightSideElements.ActionArea;
import com.maven.view.RightSideElements.MessageBar;
import com.maven.view.RightSideElements.TitleBar;
import com.maven.view.UIElements.AddForm;
import com.maven.view.UIElements.EditForm;
import com.maven.view.UIElements.ListView;



/**
 *
 * @author Regory Gregory
 */
public class Init {
    public static void init()
    {
                DataHandler.temp();

                //DataHandler.setUsers(UsersForTesting.getUsers());
                DataHandler.loadTasklists();
                ActionArea.getInstance();
                ListView.getInstance();
                ActionBar.getInstance();
                MessageBar.getInstance();
                TitleBar.getInstance();
             
                AddForm.setUsers(DataHandler.getUsers());
                EditForm.setUsers(DataHandler.getUsers());
    }
}
