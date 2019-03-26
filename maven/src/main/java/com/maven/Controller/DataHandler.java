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
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;


/**
 *
 * @author Regory Gregory
 */
public class DataHandler<T extends SubTask> {
    
    private static String s = System.getProperty("file.separator");
    private static String dirPath = "."+s+SquirrelConstants.getSaveDir();
    private static ArrayList<SubTask> children;
    private static Idcounter IDCounter = new Idcounter();
    private static ArrayList<User> users = new ArrayList<User>();
    private static HashSet<SubTask> allEntries;
   
    //This is just a quick fix
    
    public static void quickFixONotation()
   {
       for(SubTask tl : children)
       {
           allEntries.add(tl);

            for(Object t : tl.getSubtasks())
            {
                  Task typecastT = (Task) t;
                  typecastT.setParent(tl);
                  allEntries.add(typecastT);
                  
                  for(Object st : typecastT.getSubtasks())
                    {
                        SubTask typecastST = (SubTask) st;
                        typecastST.setParent(typecastT);
                        allEntries.add(typecastST);
                    }

            }
       
       }
   
   }
    public static boolean updateTaskLists()
    {
        boolean success = true;
        DataHandler.getIDCounter().setIDCounterCounter(SquirrelConstants.getCounter());
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
        boolean saveCounterSuccess = DataHandler.saveCounter(); 
        success =  (success && saveCounterSuccess);
        return success;
    
    }
    public static SubTask getEntryFromAllEntriesByID(int id)
    {
        for(SubTask t: allEntries)
        {
            if (t.getID()==id)
            {
                return t;
            }
        }
       return null; 
    }
    
        public static SubTask getEntryFromAllEntriesByTitle(String title)
    {
        for(SubTask t: allEntries)
        {
            if (t.getTitle().equals(title));
            {
                return t;
            }
        }
       return null; 
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
            allEntries.add(taskList);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return success;
    }
    
    
    public static void loadTasklists()
    {
        
            /*******************************************************************
            ****************** Loading the task lists from files*****************
            *******************************************************************/
            allEntries = new HashSet<>();
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
            
            try
            {
                File[] fileList = saveDir.listFiles();

                for(File f : fileList)
                {
                
                 if(!f.getName().equals("IDCounter"))
                 {
                   children.add(loadTasklist(f.getName()));
                 } else {
                     
                     loadCounter(); 
                     
                     SquirrelConstants.setCounter(DataHandler.getIDCounter().getIDCounterCounter());
                     

                 }

                }
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            
            /*******************************************************************
            ****************** Fetching web service tasks ********************
            *******************************************************************/
            
            
         
            FetchWeb webFetcher = new FetchWeb();
            ArrayList<Task> fetchedList = new ArrayList<>();

            /************** Fetching web service tasks ************************/

            try
            {
             fetchedList = webFetcher.getWebLists();
        
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
            
            /************** If they have not been fetched *********************
              then they are automatically added to the tasklists**************/
            int webId = IDCounter.getWebId();
            
            if(webId<1)
            {
            
                TaskList webTaskList = new TaskList();
                webTaskList.setTitle("Tasklist fetched from JSON webservice");
                webTaskList.setDescription("No further description.");
                webTaskList.setStringDueDate("02/02/2050");
                webTaskList.setUser(users.get(0));
                webTaskList.setCreator(users.get(0));
                
                if(fetchedList.size()>0)
                {
                    webTaskList.setChildren(fetchedList);
                    DataHandler.IDCounter.setWebId(webTaskList.getID());
                    DataHandler.getIDCounter().setIDCounterCounter(SquirrelConstants.getCounter());
                    
                    
                    DataHandler.children.add(webTaskList);
                  
                } else 
                {
                                   JOptionPane.showMessageDialog(null, "Fetching from the webservice was not possible!");

                }

            
            } 
            else 
            {
             /************** If there has been a fetch, local copy has to be 
             checked so that changes made by the user won't be overwritten
             then they are automatically added to the task lists.
             For this purpose the title of the task and subtask is checked. If
             a local copy exists, it wont be overwritten**********************/
                
            TaskList localTasklist = (TaskList)getEntry("TASKLIST", webId);
            
            if(fetchedList.size()>0)
                 {
                 //walking through every single task    
                    for(Task fetchedTask : fetchedList)
                    {
                        //fetchedTask.JSONCorrection();
                        //fixing zero indexed subtask priority
                        fetchedTask.setPriorityOrder(fetchedTask.getPriorityOrder()+1);
                        String fetchedTitle = fetchedTask.getTitle();
                        
                        ArrayList<SubTask> localMatch = getTaskByTitle(fetchedTitle);
                       //as it returns an empty ArrayList if no match
                        if(localMatch.size()>0)
                        {
                        //now you have to go through every single subtask...
                        // it is extremely ineffective, again, loop in a loop and then calls a funciton that uses a loop in a loop
                        ArrayList<SubTask> remoteMatchedSubtasks = fetchedTask.getSubtasks();
                       
                        Task typecast = (Task)localMatch.get(0);
                        
                            for(SubTask stremote : remoteMatchedSubtasks)
                            {
                               // stremote.JSONCorrection();
                            if(containsSubtaskByTitle(typecast, stremote.getTitle()))
                            {
                                  continue;
                            }else 
                            {
                             typecast.addChild(stremote);
                             
                           
                            }
                        }

                        } else 
                        {
                            localTasklist.addChild(fetchedTask);
                           
                           
                        }
                    }      
                 }
            else 
                {
                   //handle error
                }
            }
            saveCounter();
            quickFixONotation();    
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
           if(x.getSubtasks().size()>0)
           {
               ArrayList<Task> y = x.getSubtasks();
               
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
    
     
    public static ArrayList<SubTask> getTaskByTitle(String title)
    {
        ArrayList<SubTask> found = new ArrayList<>();
        
        
        
        for (SubTask tl : children)
        {
           TaskList x = (TaskList) tl;
           if(x.getSubtasks().size()>0)
           {
               ArrayList<Task> y = x.getSubtasks();
               
               for (Task t : y)
               {
                
                if(t.getTitle().equals(title)){
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
           if(x.getSubtasks().size()>0)
           {
               ArrayList<Task> y = x.getSubtasks();
               
               for (Task t : y)
               {
                   if(t.getSubtasks().size()>0)
                   {
                   ArrayList<SubTask> z = t.getSubtasks();
                   
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
    
    public static  ArrayList<SubTask> getSubTasktByTitle(String title)
    {
         ArrayList<SubTask> found = new ArrayList<>();

        for (SubTask tl : children)
        {
           TaskList x = (TaskList) tl;
           if(x.getSubtasks().size()>0)
           {
               ArrayList<Task> y = x.getSubtasks();
               
               for (Task t : y)
               {
                   if(t.getSubtasks().size()>0)
                   {
                   ArrayList<SubTask> z = t.getSubtasks();
                   
                        for(SubTask st : z)
                        {
                            if(st.getTitle().equals(title)){
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
    
    public static  boolean containsSubtaskByTitle(Task parent, String childTitle)
    {

           if(parent.getSubtasks().size()>0)
           {
               ArrayList<SubTask> y = parent.getSubtasks();
               
               for (SubTask t : y)
               {
                   if(t.getTitle().equals(childTitle))
                   {
                   return true;
                   }
  
               }
           }


        return false;
    }


    public static void setChildren(ArrayList<SubTask> children) {
        DataHandler.children = children;
    }
    
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
    
     public static User getUserByUserName(String name)
    {
        if(name.length()<1)
        {
        return null;
        }
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
    
    public static Idcounter getIDCounter() {
        return DataHandler.IDCounter;
    }

    public static void setIDCounter(Idcounter IDCounter) {
        DataHandler.IDCounter = IDCounter;
    }
    
     public static void loadCounter()
    {
        Idcounter loaded = new Idcounter();
        
        String dirPath = "."+s+SquirrelConstants.getSaveDir();
        String filePath = dirPath+s+"IDCounter";
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
        
        DataHandler.IDCounter = loaded;

     
    }
        
    public static boolean saveCounter()
    {
        int currentLargest = SquirrelConstants.getCounter();
        DataHandler.IDCounter.setIDCounterCounter(currentLargest);
        
        String filePath = dirPath+s+"IDCounter";
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
            objectOut.writeObject(DataHandler.IDCounter);
            success = true;
            
            fileOut.close();
            objectOut.close();
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
     return success;
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
                 result += sc.nextLine();
             }
            System.out.println(result); 
            inStream.close();
             sc.close();
            }catch (MalformedURLException e)
            {
              JOptionPane.showMessageDialog(null, "URL is not formatted properly, fetching the WebService tasks was not possible.");
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
        public ArrayList<Task> getWebLists() throws CustomException
        {
            String fetchedString = this.fetch();
            Type typeToken = new TypeToken<ArrayList<Task>>(){}.getType();
            Gson converter = new Gson();
            System.out.println(fetchedString);
            ArrayList<Task> tList = converter.fromJson(fetchedString, typeToken);
            for(Task t : tList)
            {
                t.JSONCorrection();
                User u = t.getUser();
                u.JSONCorection();
                DataHandler.users.add(u);
                DataHandler.getIDCounter().setIDCounterCounter(SquirrelConstants.getCounter());
                ArrayList<SubTask> subtasks = t.getSubtasks();
                if(subtasks.size()>0)
                {
                    for(SubTask st : subtasks)
                    {
                        DataHandler.getIDCounter().setIDCounterCounter(SquirrelConstants.getCounter());
                        st.JSONCorrection();
                        st.setUser(u);
                    }
                }
            
            
            }
            return tList;
        }

        public String getUrlString() {
            return urlString;
        }

        public void setUrlString(String urlString) {
            this.urlString = urlString;
        }

    }    

    public static String getS() {
        return s;
    }

    public static void setS(String s) {
        DataHandler.s = s;
    }

    public static String getDirPath() {
        return dirPath;
    }

    public static void setDirPath(String dirPath) {
        DataHandler.dirPath = dirPath;
    }

    public static HashSet<SubTask> getAllEntries() {
        return allEntries;
    }

    public static void setAllEntries(HashSet<SubTask> allEntries) {
        DataHandler.allEntries = allEntries;
    }
    
    
}
