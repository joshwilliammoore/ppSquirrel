/*
 
    Here we should add constants that we will use throughout the application, such as colours, element sizes, file references...etc.

 */
package com.maven.model;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;
/**
 *
 * @author Gregory
 */
public class SquirrelConstants {

    private static final String saveDir = "save";
    private static final String[] listMap = {"TASKLISTS", "TASKLIST", "TASK", "SUBTASK" };
    private static final int H1SIZE = 31;
    private static int taskID = 0;
    private static final String webServiceURL = "http://nooblab.com/p2.json";
    //currently, these values have to be divisible by 100 without remainder
    //Main panel configuration
    private static final int mainContainerWidth = 1000;
    private static final int mainContainerHeight=600;
    private static final int leftSideWidth = 300;
    private static final int rightSideWidth = 700;
    private static final int innerPaneHeight = 600;
    private static final boolean removeDefaultMenuBar = false;
    
    private static int subtaskCounter =1;

    private static final Color mainBg = Color.decode("#ffffff");
    private static final Color rightSideBg = Color.decode("#ffffff");
    private static final Color leftSideBg = Color.decode("#1a33d5");
    
    private static final Color mainFore = Color.decode("#1a33d5");
    private static final Color rightSideFore = Color.decode("#1a33d5");
    private static final Color leftSideFore = Color.decode("#ffffff");
    
   
    //Logo configuration
   
    private static final String appName = "Squirrel Tasker";
    private static final Color logoForeground = Color.WHITE;
    private static final Font logoFont = new Font("Arial", Font.PLAIN, 22);
   
    //Menu entry configuration
    
   
    private static final Color menuEntryForeground = Color.WHITE;
    private static final Color menuEntryBg = leftSideBg;
    private static final Font menuEntryFont = new Font("Arial", Font.PLAIN, 30);
    private static  final String[] menuEntries= {"Home", "Tasklists", "Settings" ,"Exit"};

    public static String[] getListMap() {
        return listMap;
    }
    
    
    
    //horizontal pane settings
    
    private static final int[] horizontalPaneHeight =
    {
    80 ,140,380
    };
     private static final String[] horizontalPaneColor =
    {
    "#ffffff","#f442dc","#ffffff"
    };
    
     
     //TitleBar
     private static final int titleBarHeight = 80;
     private static final String titleBarBackground = "#ffffff";
     
    //horizontal panel options
        //middle panel with buttons
     private static final int actionBarHeight = 140;
     private static final String actionBarBackground = "#000000";
     
     //working area
     private static final int workingAreaHeight =380;
     private static final String workingAreaBackground = "#ffffff";

    public static String getSaveDir() {
        return saveDir;
    }
     
    public static int getTitleBarHeight() {
        return titleBarHeight;
    }

    public static String getTitleBarBackground() {
        return titleBarBackground;
    }

    public static int getWorkingAreaHeight() {
        return workingAreaHeight;
    }

    public static String getWorkingAreaBackground() {
        return workingAreaBackground;
    }
     
     
     
    public static int getActionBarHeight() {
        return actionBarHeight;
    }

    public static String getActionBarBackground() {
        return actionBarBackground;
    }
     
     
    public static int[] getHorizontalPaneHeight() {
        return horizontalPaneHeight;
    }

    public static String[] getHorizontalPaneColor() {
        return horizontalPaneColor;
    }
     
     
    
    public static Color getMenuEntryForeground() {
        return menuEntryForeground;
    }

    public static Color getMenuEntryBg() {
        return menuEntryBg;
    }

    public static Font getMenuEntryFont() {
        return menuEntryFont;
    }

    public static String[] getMenuEntries() {
        return menuEntries;
    }
   
    
    
    
    
    
    public static String getAppName() {
        return appName;
    }

    public static Color getLogoForeground() {
        return logoForeground;
    }
     public static Font getLogoFont() {
        return logoFont;
    }
     
     
    public static boolean isRemoveDefaultMenuBar() {
        return removeDefaultMenuBar;
    }
    
    
    public static int getTaskID() {
        return taskID;
    }

    public static int getH1SIZE() {
        return H1SIZE;
    }

    public static int getMainContainerWidth() {
        return mainContainerWidth;
    }

    public static int getMainContainerHeight() {
        return mainContainerHeight;
    }

    public static int getLeftSideWidth() {
        return leftSideWidth;
    }

    public static int getRightSideWidth() {
        return rightSideWidth;
    }

    //reference from outside the class SquirrelConstants.H1SIZE !!!
    public static int getInnerPaneHeight() {
        return innerPaneHeight;
    }
    public static void setTaskID(int taskID) {
        SquirrelConstants.taskID = taskID;
    }
     public static Color getMainBg() {
        return mainBg;
    }

    public static Color getRightSideBg() {
        return rightSideBg;
    }

    public static Color getLeftSideBg() {
        return leftSideBg;
    }

    public static Color getMainFore() {
        return mainFore;
    }

    public static Color getRightSideFore() {
        return rightSideFore;
    }

    public static Color getLeftSideFore() {
        return leftSideFore;
    }

    public static int getSubtaskCounter() {
        incrementSubtaskCounter();
        return subtaskCounter;
    }
    
    
    
    
    public static void incrementSubtaskCounter() {
        SquirrelConstants.subtaskCounter++;
    }
    public static int getCounter() {
        return subtaskCounter;
    }
    
    public static void setCounter(int count) {
       subtaskCounter = count;
    }

    public static String getWebServiceURL() {
        return webServiceURL;
    }
    
}
