/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.model;

/**
 *
 * @author Regory Gregory
 */
public class Idcounter {
    private static int count;
    
    public Idcounter()
    {
    this.count = 1;
    }
    
    
    
    public Idcounter(int count)
    {
    this.count = count;
    }
    public static int getCounter() {
        return count;
    }

    public static void setCounter(int count) {
        Idcounter.count = count;
    }
}
