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

import com.maven.model.SubTask;
import com.maven.model.Task;
import com.maven.model.TaskList;

import com.maven.model.SquirrelConstants;
/**
 *
 * @author Regory Gregory
 */
public class DataHandler {
    
    private static String s = System.getProperty("file.separator");
    private static String dirPath = "."+s+SquirrelConstants.getSaveDir();
    private static ArrayList<SubTask> taskLists;

    public static boolean saveTaskList(SubTask taskList)
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
    
    public static SubTask loadTasklist(String filename)
    {
        SubTask loaded = new TaskList();
        
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
    
    public static SubTask loadTaskLists(String type, int id)
    {
        taskLists = new ArrayList<SubTask>();

        if(type.equals("TASKLISTS"))
        {
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
        }  else if(type.equals("TASKLIST"))
        {
                    
          return getTaskListByID(id);
        
        } else if(type.equals("TASK"))
        {
            return getTasktByID(id);

        }else if(type.equals("SUBTASK")){
            return getSubTasktByID(id);

        }
 
       
    return null;
    }
    
    public static SubTask getTaskListByID(int id)
    {
        for (SubTask tl : taskLists)
        {
        if(tl.getID()==id) return tl;

        }
        return null;
    }  
    
    public static SubTask getTasktByID(int id)
    {
        //it is very ineffective
        
        for (SubTask tl : taskLists)
        {
           TaskList x = (TaskList) tl;
           if(x.getChildren().size()>0)
           {
               ArrayList<Task> y = x.getChildren();
               
               for (Task t : y)
               {
                if(t.getID()==id) return t;
               }
           }

        }
        return null;
    }
      public static SubTask getSubTasktByID(int id)
    {
        for (SubTask tl : taskLists)
        {
           TaskList x = (TaskList) tl;
           if(x.getChildren().size()>0)
           {
               ArrayList<Task> y = x.getChildren();
               
               for (Task t : y)
               {
                   if(t.getChildren().size()>0)
                   {
                   ArrayList<SubTask> z = t.getChildren();
                   
                        for(SubTask st : z)
                        {
                            if(st.getID()==id) return st;
                        }

                   }
  
               }
           }

        }
        return null;
    }
    
    public static ArrayList<SubTask> getTaskLists() {
      return taskLists;
      }

    public static void setTaskLists(ArrayList<SubTask> taskLists) {
        DataHandler.taskLists = taskLists;
    }
}
