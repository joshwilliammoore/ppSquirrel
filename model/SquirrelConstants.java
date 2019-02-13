/*
 
    Here we should add constants that we will use throughout the application, such as colours, element sizes, file references...etc.

 */
package model;

/**
 *
 * @author Gregory
 */
public class SquirrelConstants {

    
    private static final int H1SIZE = 31;
    private static int taskID = 0;
    private static final int mainContainerWidth = 1000;
    private static final int mainContainerHeight=1000;
    private static final int leftSideWidth = 300;
    private static final int rightSideWith = 700;
    private static final int innerPaneHeight = 1000;
    
    
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

    public static int getRightSideWith() {
        return rightSideWith;
    }

    //reference from outside the class SquirrelConstants.H1SIZE !!!
    public static int getInnerPaneHeight() {
        return innerPaneHeight;
    }
    public static void setTaskID(int taskID) {
        SquirrelConstants.taskID = taskID;
    }

}
