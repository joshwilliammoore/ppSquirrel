/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.TaskList;
import model.SquirrelConstants;
import java.util.ArrayList;
/**
 *
 * @author Regory Gregory
 */
public class DataHandler {
    
    private static String s = System.getProperty("file.separator");
    private static String dirPath = "."+s+SquirrelConstants.getSaveDir();
    public static TaskList[] loadTasklists()
    {
     TaskList[] loaded = new TaskList[0];
     
     return loaded;
    }
    
    public static boolean saveTaskList(TaskList taskList)
    {
        
        
        String filePath = dirPath+s+"taskList_id-"+taskList.getID();
        File newDir = new File(dirPath);
        File newFile = new File(filePath);
        boolean success = false;
        try
        {   if(!newDir.exists())
            {
             newDir.mkdirs();

            }
            newFile.createNewFile();
            
            FileOutputStream fileOut = new FileOutputStream(newFile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(taskList);
            success = true;
            
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return success;
    }
    
    public static TaskList loadTasklist(String filename)
    {
        TaskList loaded = new TaskList();
        
        String dirPath = "."+s+SquirrelConstants.getSaveDir();
        String filePath = dirPath+s+filename;
        File newFile = new File(filePath);
        try
        {
            
            
            FileInputStream fileIn = new FileInputStream(newFile);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
           loaded = (TaskList) objectIn.readObject();
            
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return loaded;
     
    }
    
    public static ArrayList<TaskList> loadTaskLists()
    {
        File saveDir = new File(dirPath);
        File[] fileList = saveDir.listFiles();
        ArrayList<TaskList> taskLists = new ArrayList<>();
        
        for(File f : fileList)
        {
        
        taskLists.add(loadTasklist(f.getName()));
        }
    return taskLists;
    }
}
