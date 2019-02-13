/*
 
    Here we should add constants that we will use throughout the application, such as colours, element sizes, file references...etc.

 */
package model;
import java.awt.Color;
import java.awt.Font;
/**
 *
 * @author Gregory
 */
public class SquirrelConstants {

    
    private static final int H1SIZE = 31;
    private static int taskID = 0;
    //currently, these values have to be divisible by 100 without remainder
    //Main panel configuration
    private static final int mainContainerWidth = 1000;
    private static final int mainContainerHeight=600;
    private static final int leftSideWidth = 300;
    private static final int rightSideWidth = 700;
    private static final int innerPaneHeight = 600;
    private static final boolean removeDefaultMenuBar = false;
    

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
}
