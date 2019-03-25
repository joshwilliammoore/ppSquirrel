/*
 
    Here we should add constants that we will use throughout the application, such as colours, element sizes, file references...etc.

 */
package com.maven.model;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.util.ArrayList;


/**
 *
 * @author Gregory
 */
public class SquirrelConstants {
/******************************************************************************
 * ***************************** Default settings   ***************************
 * ****************************************************************************/
    
    private static final String saveDir = "save";
    private static final String[] listMap = {"TASKLISTS", "TASKLIST", "TASK", "SUBTASK" };
    private static final int H1SIZE = 31;
    private static int taskID = 0;
    private static final String webServiceURL = "http://nooblab.com/p2.json";
    //currently, these values have to be divisible by 100 without remainder
    //Main panel configuration
    private static final int mainContainerWidth = 1200;
    private static final int mainContainerHeight=600;
    private static final int leftSideWidth = 300;
    private static final int rightSideWidth = 900;
    private static final int innerPaneHeight = 600;
    private static final boolean removeDefaultMenuBar = false;
    
    private static int subtaskCounter =1;

/******************************************************************************
 * ************************* Color settings ************************************
 * ****************************************************************************/
    
    
    
    public static final Color colorPrimary = Color.decode("#007090");
    public static final Color colorSecondary = Color.decode("#01A7C2");
    public static final Color colorOdd = Color.decode("#01A7C2");
    public static final Color colorLight = Color.WHITE;
    public static final Color colorDark = Color.BLACK;
    public static final Color colorWarning = Color.decode("#ECD444");
    public static final Color colorDanger = Color.decode("#A11D5A");
    
    
    private static final Color mainBg =colorLight;
    private static final Color rightSideBg = colorLight;
    private static final Color leftSideBg = colorPrimary;
    
    private static final Color mainFore = colorSecondary;
    private static final Color rightSideFore = colorSecondary;
    private static final Color leftSideFore = colorLight;
    
    public static final Color MessageBarColour = colorLight;
    public static final Color ActionBarColour = colorLight;
    public static final Color ActionAreaColour = colorLight;
    public static final Color ActionButtonForeground = colorLight;
    public static final Color ActionButtonBackground = colorSecondary;
    
    public static final Color ActionAreaButtonBackground = colorSecondary;
    public static final Color ActionAreaButtonForeground = colorLight;

    
   
    
    private static final Color menuEntryForeground = colorLight;
    private static final Color menuEntryBg = colorPrimary;
   
    private static final Color logoForeground = colorLight;
    
/******************************************************************************
 * ************************* Menu configuration *******************************
 * ****************************************************************************/
    
    private static final Font menuEntryFont = new Font("Arial", Font.PLAIN, 30);
    
    private static final String[] menuEntries= {"Home", "Tasklists", "Admin" ,"Exit"};
    
/******************************************************************************
 * ******************************* Paddings ** *******************************
 * ****************************************************************************/
    
    public static final Insets ActionButtonPadding = new Insets(20, 20, 20, 20);
    public static final Insets ActionBarButtonPadding = new Insets(20, 20, 20, 20);
    public static final Insets FilterBarButton = new Insets(10, 3, 10, 3);
    public static final Insets ListEntryButton = new Insets(0, 0, 0, 0);
    public static final Insets CheckBoxPAdding = new Insets(20, 20, 20, 20);

    public static final Border searchDropDownPadding = BorderFactory.createEmptyBorder(20, 20, 20, 20);
    public static final Border HeaderPadding = BorderFactory.createEmptyBorder(50, 20, 20, 20);

/******************************************************************************
 * ************************* Border configuration *******************************
 * ****************************************************************************/
   public static final Border ListEntryButtonBorder = BorderFactory.createMatteBorder(1,1,1,1, colorLight);
   public static final Border ListEntryLabelBorder = BorderFactory.createMatteBorder(0,0,0,0, colorLight);

    
/******************************************************************************
 * ************************* Logo configuration *******************************
 * ****************************************************************************/
   
   
    private static final String appName = "Squirrel Tasker";
    
/******************************************************************************
 * ************************* Fonts *******************************
 * ****************************************************************************/
      
    
    
    private static final Font logoFont = new Font("Arial", Font.PLAIN, 22);
    private static final Font HeaderFont = new Font("Arial", Font.PLAIN, 40);
    private static final Font SubHeaderFont = new Font("Arial", Font.PLAIN, 22);
    private static final Font DetailEntryFont = new Font("Arial", Font.PLAIN, 22);

/******************************************************************************
 * **********************Horizontal pane settings******************************
 * ****************************************************************************/
    
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
    
    

/******************************************************************************
 * ************************* Getters and setters*******************************
 * ****************************************************************************/
   
       
    
    public static Color getColorPrimary() {
        return colorPrimary;
    }

    public static Color getColorSecondary() {
        return colorSecondary;
    }

    public static Color getColorLight() {
        return colorLight;
    }

    public static Color getColorDark() {
        return colorDark;
    }

    public static Color getColorWarning() {
        return colorWarning;
    }

    public static Color getColorDanger() {
        return colorDanger;
    }

    public static Color getColorOdd() {
        return colorOdd;
    }

    public static Color getActionAreaButtonBackground() {
        return ActionAreaButtonBackground;
    }

    public static Color getActionAreaButtonForeground() {
        return ActionAreaButtonForeground;
    }

    public static Insets getListEntryButton() {
        return ListEntryButton;
    }

    public static Border getListEntryButtonBorder() {
        return ListEntryButtonBorder;
    }

    public static Border getListEntryLabelBorder() {
        return ListEntryLabelBorder;
    }
    
    
    
    
    public static Color getActionButtonForeground() {
        return ActionButtonForeground;
    }

    public static Color getActionButtonBackground() {
        return ActionButtonBackground;
    }

    public static Insets getActionButtonPadding() {
        return ActionButtonPadding;
    }

    public static Border getSearchDropDownPadding() {
        return searchDropDownPadding;
    }

    public static Insets getActionBarButtonPadding() {
        return ActionBarButtonPadding;
    }

    public static Insets getFilterBarButton() {
        return FilterBarButton;
    }

    public static Border getHeaderPadding() {
        return HeaderPadding;
    }

    public static Font getSubHeaderFont() {
        return SubHeaderFont;
    }
    
    
    
    
    public static Color getMessageBarColour() {
        return MessageBarColour;
    }

    public static Color getActionBarColour() {
        return ActionBarColour;
    }

    public static Color getActionAreaColour() {
        return ActionAreaColour;
    }
    
    
    public static String[] getListMap() {
        return listMap;
    }

    public static Insets getCheckBoxPAdding() {
        return CheckBoxPAdding;
    }

    public static Font getHeaderFont() {
        return HeaderFont;
    }
    
    
    
  

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

    public static Font getDetailEntryFont() {
        return DetailEntryFont;
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
