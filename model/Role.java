/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * Roles should be dealt with later on...
 */
import java.util.ArrayList;
import model.Enums.Rights;

public class Role {
    private String name;
    private ArrayList<Rights> rights;
    
    public Role(String name, ArrayList<Rights> r)
    {
        this.name = name;
        this.rights = r;
    }
    private ArrayList<Rights> returnCEORights()
    {
        ArrayList<Rights> adminRights = new ArrayList<>();
       for (Rights r : Rights.values())
       {
       adminRights.add(r);
       }

        return adminRights;
    }
    
    private ArrayList<Rights> returnTaskManagerRights()
    {
        ArrayList<Rights> assigneeRights = new ArrayList<>();
        assigneeRights.add(Rights.VIEW_OWN_TASKS);
        

        return assigneeRights;
    }
    
    private ArrayList<Rights> returnStaffRights()
    {
         ArrayList<Rights> assigneeRights = new ArrayList<>();
        assigneeRights.add(Rights.VIEW_OWN_TASKS);
        

        return assigneeRights;
    
    }
}
