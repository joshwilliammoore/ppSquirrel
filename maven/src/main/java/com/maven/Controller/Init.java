/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.Controller;

import com.maven.view.RightSideElements.ActionBar;
import com.maven.view.RightSideElements.ActionArea;
import com.maven.view.RightSideElements.MessageBar;
import com.maven.view.RightSideElements.TitleBar;
import com.maven.view.RightSideElements.WorkingArea;

import com.maven.view.UIElements.TaskListView;



/**
 *
 * @author Regory Gregory
 */
public class Init {
    public static void init()
    {
                ActionArea.getInstance();
                TaskListView.getInstance();
                ActionBar.getInstance();
                MessageBar.getInstance();
                TitleBar.getInstance();
                WorkingArea.getInstance();
    
    }
}
