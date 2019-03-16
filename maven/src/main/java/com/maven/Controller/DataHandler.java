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
import com.maven.model.User;
import com.maven.model.Task;
import com.maven.model.TaskList;
import com.maven.model.Idcounter;
import com.maven.model.SquirrelConstants;
import com.maven.model.CustomException;


import java.io.BufferedInputStream;
import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;


/**
 *
 * @author Regory Gregory
 */
public class DataHandler {
    
    private static String s = System.getProperty("file.separator");
    private static String dirPath = "."+s+SquirrelConstants.getSaveDir();
    private static ArrayList<SubTask> children;
    private static Idcounter IDCounter;
    private static ArrayList<User> users = new ArrayList<User>();
    private static int webServicesID = 0;
    
    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        DataHandler.users = users;
    }
    
    
    //may not be necessary, but this is the "parent" of TaskLists
    public static ArrayList<SubTask> getChildren(){
        return children;
    }
    
    public static boolean updateTaskLists()
    {
        boolean success = true;

        for(SubTask taskList : children)
        {
                String filePath = dirPath+s+"taskList_id-"+taskList.getID();
                File newDir = new File(dirPath);
                File newFile = new File(filePath);
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
                    //saving the id's current state
                    
                        
                }catch(Exception e)
                {
                    success = false;
                    e.printStackTrace();
                }
              
        }
        boolean saveCounterSuccess = saveCounter(); 
        success =  (success && saveCounterSuccess);
        
        return success;
    
    }
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
            children.add(taskList);
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return success;
    }
    
    
    public static void loadTasklists()
    {
        children = new ArrayList<SubTask>();

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
             if(!f.getName().equals("IDCounter1"))
             {
               children.add(loadTasklist(f.getName()));
             } else {
                 IDCounter=(loadCounter(f.getName()));  
             }
            
            }
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            
            FetchWeb webFetcher = new FetchWeb();
            TaskList[] fetchedList = null;
            try
            {
                fetchedList = webFetcher.getWebLists();
                if(webServicesID ==0)
                {
                webServicesID = fetchedList.getID();     
                children.add(fetchedList);
                } else 
                {
                
                
                }
                
            }catch(CustomException e)
            {
                e.printStackTrace();
            }catch (JsonParseException e) {
               e.printStackTrace();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        
 
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
           fileIn.close();
           objectIn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        } 
        return loaded;
     
    }
       
    
    public static SubTask getEntry(String type, int id)
    {
        if(type.equals("TASKLIST"))
        {
                    
          return getTaskListByID(id);
        
        } else if(type.equals("TASK"))
        {
            return getTasktByID(id).get(0);

        }else if(type.equals("SUBTASK")){
            return getSubTasktByID(id).get(0);

        }
        return null;
    }
    //deprecated. Instead of actually deleting anything the attribute of each entity is set to deleted and it is not displayed.
    //This way, if the user have decided to delete one task from the webservices, the it is still in the list and can
    //if the app tries to download the list, it won't reinstate an already deleted tasklist due to not being in the list anymore.
      public static boolean deleteTaskList(String id)
    {
       
        String dirPath = "."+s+SquirrelConstants.getSaveDir();
        String filePath = dirPath+s+"taskList_id-"+id;
        DataHandler.getChildren().remove(DataHandler.getTaskListByID(Integer.parseInt(id)));
        File newFile = new File(filePath);

        return newFile.delete();
      
    }
    

    public static SubTask getTaskListByID(int id)
    {
        for (SubTask tl : children)
        {
        if(tl.getID()==id) return tl;

        }
        return null;
    }  
    
    public static ArrayList<SubTask> getTasktByID(int id)
    {
        ArrayList<SubTask> found = new ArrayList<>();
        
        
        
        for (SubTask tl : children)
        {
           TaskList x = (TaskList) tl;
           if(x.getChildren().size()>0)
           {
               ArrayList<Task> y = x.getChildren();
               
               for (Task t : y)
               {
                
                if(t.getID()==id){
                found.add(t);
                found.add(tl);
                return found;
                } 
               }
           }

        }
        return found;
    }
    
     
    
    
    
      public static  ArrayList<SubTask> getSubTasktByID(int id)
    {
         ArrayList<SubTask> found = new ArrayList<>();

        for (SubTask tl : children)
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
                            if(st.getID()==id){
                               found.add(st);
                               found.add(t);
                               found.add(tl);
                               return found;
                            }
                        }

                   }
  
               }
           }

        }
        return found;
    }
    
   

    public static void setChildren(ArrayList<SubTask> children) {
        DataHandler.children = children;
    }

    public static Idcounter getIDCounter() {
        return IDCounter;
    }

    public static void setIDCounter(Idcounter IDCounter) {
        DataHandler.IDCounter = IDCounter;
    }
    
     public static Idcounter loadCounter(String filename)
    {
        Idcounter loaded = new Idcounter();
        
        String dirPath = "."+s+SquirrelConstants.getSaveDir();
        String filePath = dirPath+s+filename;
        File newFile = new File(filePath);
        
        try (FileInputStream fileIn = new FileInputStream(newFile);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                )
        {

           loaded = (Idcounter) objectIn.readObject();
           fileIn.close();
           objectIn.close();
            
        }catch(Exception e)
        {
            e.printStackTrace();
        } 
        SquirrelConstants.setCounter(DataHandler.getIDCounter().getCounter());

        return loaded;
     
    }
        
    public static boolean saveCounter()
    {
        String filePath = dirPath+s+"IDCounter1";
        File newDir = new File(dirPath);
        File newFile = new File(filePath);
        boolean success = false;
        try
        {   if(!newDir.exists())
            {
             newDir.mkdirs();

            }
            if(newFile.exists())
            {
                newFile.delete();
            }
            newFile.createNewFile();
            
            FileOutputStream fileOut = new FileOutputStream(newFile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(IDCounter);
            success = true;
            
            fileOut.close();
            objectOut.close();
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
     return success;
    }    
    public static User getUserByUserName(String name)
    {
        User returnable = null;
        if(getUsers().size()==0)
        {
            return returnable;
        }
        for(User u: getUsers())
        {
            if(u.getUserName().equals(name)) returnable = u;
        
        }
        return returnable;
    }
    
    public static class FetchWeb {

        private String urlString;


        public FetchWeb()
        {
            this.setUrlString(SquirrelConstants.getWebServiceURL());

        }
        public String fetch() throws CustomException
        {

            String result = "";
            try
            {
              URL address = new URL(this.urlString);

             BufferedInputStream inStream=new BufferedInputStream(address.openStream());
             Scanner sc = new Scanner(inStream);

             while(sc.hasNext())
             {
                 result = sc.nextLine();
             }
            }catch (MalformedURLException e)
            {
                javax.swing.JOptionPane.showMessageDialog(null, "URL is not formatted properly, fetching the WebService tasks was not possible.");
            }catch (Exception e)
            {
              e.printStackTrace();

            }

            if(result.length()<1)
            {
             throw new CustomException("Something went wrong. Gson.fetch returned an empty String");

            }
        return result;    
        }
        public TaskList[] getWebLists() throws CustomException
        {
            String fetchedString = this.fetch();
            Gson converter = new Gson();
            TaskList[] tList = converter.fromJson(fetchedString, TaskList[].class);
            return tList;
        }

        public String getUrlString() {
            return urlString;
        }

        public void setUrlString(String urlString) {
            this.urlString = urlString;
        }

    }    
    
}
