/*
 This is an interface used for UI elements that
the user can enter data into.
It is sued to signpost these fields.
 */
package com.maven.view.UIElements;

/**
 *
 * @author Regory Gregory
 */
public interface GetUIContent {
    public String getContent();
    public String getLabel();
    public void setLabel(String label);
}
