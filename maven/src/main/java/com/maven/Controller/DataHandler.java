/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.maven.model.TaskList;
import com.maven.model.SquirrelConstants;
/**
 *
 * @author Regory Gregory
 */
public class DataHandler {
    
    private static String s = System.getProperty("file.separator");
    private static String dirPath = "."+s+SquirrelConstants.getSaveDir();
    private static ArrayList<TaskList> taskLists;

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
            fileOut.close();
            objectOut.close();
            
            
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
        
        try (FileInputStream fileIn = new FileInputStream(newFile);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                )
        {
            
            
            
           loaded = (TaskList) objectIn.readObject();
            
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        } 
        return loaded;
     
    }
    
      public static boolean deleteTaskList(String id)
    {
       
        
        String dirPath = "."+s+SquirrelConstants.getSaveDir();
        String filePath = dirPath+s+"taskList_id-"+id;
        DataHandler.getTaskLists().remove(DataHandler.getTaskListByID(Integer.parseInt(id)));
        File newFile = new File(filePath);

        return newFile.delete();
      
     
    }
    
    public static ArrayList<TaskList> loadTaskLists()
    {
            taskLists = new ArrayList<TaskList>();
            File saveDir = new File(dirPath);
            if(!saveDir.exists()){
                try{
                        saveDir.mkdir();
                } catch (Exception e)
                {
                 System.out.println(e.getMessage());

                }
            
            }
            try{
            File[] fileList = saveDir.listFiles();

            for(File f : fileList)
            {

            taskLists.add(loadTasklist(f.getName()));
            }
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
    return taskLists;
    }
    
      public static TaskList getTaskListByID(int id)
      {
          for (TaskList tl : taskLists)
          {
          if(tl.getID()==id) return tl;
          
          }
          return null;
      }  
      public static ArrayList<TaskList> getTaskLists() {
        return taskLists;
        }

    public static void setTaskLists(ArrayList<TaskList> taskLists) {
        DataHandler.taskLists = taskLists;
    }
}
