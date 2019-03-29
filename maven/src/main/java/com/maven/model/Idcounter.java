/*******************************************************************************
The purpose of this class is to keep track of assigned IDs for Tasklists, tasks
* and subtasks.
* It also logs the webId which is the Id of the tasklist fetched from nooblab's
* JSON file (nooblab.com/p2.json
* Note: it is currently incremented at a humongous scale after every running of the program
* due to the fact that the WEB json service fetches every time (comparing already saved entries)
* and  Subtask and its descendants having incrementing the counter in their constructor 
 ******************************************************************************/ 
package com.maven.model;

import java.io.Serializable;

/**
 *
 * @author Regory Gregory
 */
public class Idcounter implements Serializable{
    private  int count;
    private  int webId;

   
    public  int getWebId() {
        return this.webId;
    }

    public  void setWebId(int webId) {
        this.webId = webId;
    }
    
    
    
    public Idcounter()
    {
        this.count=1;
        this.webId=-1;
        
    }
    
    public Idcounter(int count)
    {
    this.count = count;
    }
    public  int getIDCounterCounter() {
        return this.count;
    }

    public  void setIDCounterCounter(int count) {
        this.count = count;
    }
}
