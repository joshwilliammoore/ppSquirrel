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

import com.maven.view.UIElements.ListView;



/**
 *
 * @author Regory Gregory
 */
public class Init {
    public static void init()
    {
                ActionArea.getInstance();
                ListView.getInstance();
                ActionBar.getInstance();
                MessageBar.getInstance();
                TitleBar.getInstance();
    
    }
}
