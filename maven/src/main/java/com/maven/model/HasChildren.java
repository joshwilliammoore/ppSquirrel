/*******************************************************************************
Interface for models that should have a children for type comparison 
* This ensures method implementation purposes as well.

 ******************************************************************************/ 
package com.maven.model;

import java.util.ArrayList;

/**
 *
 * @author Regory Gregory
 */
public interface HasChildren<T> {
   public ArrayList<T> getSubtasks();
}
