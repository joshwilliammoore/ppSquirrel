/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
