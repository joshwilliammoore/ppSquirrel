/*
 Class responsible for listing tasklists, tasks and subtasks
Inner class: ListEntry
 */
package com.maven.view.UIElements;

import com.maven.Controller.DataHandler;
import com.maven.model.SquirrelConstants;
import com.maven.model.SubTask;
import com.maven.model.Task;
import com.maven.model.TaskList;
import com.maven.model.HasChildren;
import com.maven.view.RightSideElements.HorizontalBar;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.JLabel;
/**
 *
 * @author Regory Gregory
 */
public class ListView {
    private static JPanel viewport = null;    
    private static JScrollPane instance = null;
    private  static FilterBar columnHeader = null;
    private  static SubTask[] taskLists;
    
    
    private ListView()
    {
 
    
    }
    
    public static JScrollPane getInstance()
    {
        if(instance == null){
            instance = new JScrollPane();
            instance.setLayout(new ScrollPaneLayout());
            ListView.setColumnHeader(new FilterBar());
        }

        return instance;
    }

    public static JPanel getViewport()
    {
        if(viewport == null){
            viewport = new JPanel();
            viewport.setLayout(new GridLayout(0,1)); 
            //viewport.setMinimumSize(new Dimension(680,380));
        }
        return viewport;
    }
    

    
    public static void reFresh(SubTask[] taskLists)
    {
    getInstance();
    getViewport().removeAll();
    ListView.setTaskLists(taskLists);
    //instance.removeAll();
    if(ListView.getTaskLists() !=null || ListView.getTaskLists().length>0)
    {
        for(SubTask t : ListView.getTaskLists())
        {
            if(t.isDeleted()==false)
            {
            ListEntry temp = new ListEntry(t);
            viewport.add(temp);
            }
        
        }
    
    } else {
     
         javax.swing.JOptionPane.showMessageDialog(null, "You have children listed!");
            

    }
    //instance.setColumnHeaderView(refreshColumnHeader(taskLists));
    instance.setViewportView(viewport);
    instance.setColumnHeaderView(columnHeader);
    instance.revalidate();
    instance.repaint();

    }
    
    public static FilterBar getColumnHeader() {
        return columnHeader;
    }

    public static void setColumnHeader(FilterBar columnHeader) {
        ListView.columnHeader = columnHeader;
    }

    public static SubTask[] getTaskLists() {
        return taskLists;
    }

    public static void setTaskLists(SubTask[] taskLists) {
        ListView.taskLists = taskLists;
    }
    

    private  static class ListEntry extends HorizontalBar{
        
        public ListEntry (SubTask tal){

        super();
        String type = (tal instanceof TaskList)? "TASKLIST": (tal instanceof Task)?"TASK": "SUBTASK";
        //this.setLayout(new GridLayout(1,0));
        //if(type.equals("SUBTASK")) javax.swing.JOptionPane.showMessageDialog(null, tal.getID());
        //this.setSize(new Dimension(700, 100));
        //this.setPreferredSize(new Dimension(700, 100));

        //this.setLayout(new GridLayout(1,0));
        this.setPreferredSize(new Dimension(900, 100));
        this.setLayout(new GridLayout(1,0));
        JLabel title = new ListEntryLabel("<html>"+tal.getTitle()+"</html>");

        JLabel userName = new ListEntryLabel("<html>"+tal.getUser().getUserName()+"</html>");

        JLabel priorirty = new ListEntryLabel(Integer.toString(tal.getPriorityOrder()));
        JLabel date = new ListEntryLabel(tal.getDateDueString());

        ActionAreaCheckbox done = new ActionAreaCheckbox();
               done.setSelected(tal.isCompleted());   
               done.setActionCommand("DONE:"+type+":"+tal.getID());
               done.setHorizontalAlignment(JLabel.CENTER);

          this.add(done);  
          this.add(title);
          this.add(date);
          this.add(userName);
          this.add(priorirty);
          this.add(new ActionButtonContainer(tal, type));
          this.setBorder(SquirrelConstants.getListEntryButtonBorder());

        }

        private static class ActionButtonContainer extends JPanel
        {
            private ActionButtonContainer(SubTask tal, String type)
            {
            super();
            this.setLayout(new GridLayout(0,1));
            ActionAreaButton view = new ListEntryButton("view");
                            view.setActionCommand("VIEW:"+type+":"+tal.getID());
                            this.add(view);
                            //javax.swing.JOptionPane.showMessageDialog(null, DataHandler.getLoggedIn().getUserLevel());
            if(DataHandler.getLoggedIn().getUserLevel() <2)
            {
                ActionAreaButton edit = new ListEntryButton("edit");
                         edit.setActionCommand("EDIT:"+type+":"+tal.getID());
                         this.add(edit);
            }
            if(DataHandler.getLoggedIn().getUserLevel() == 0){
                ActionAreaButton delete = new ListEntryButton("delete");
                         delete.setActionCommand("DELETE:"+type+":"+tal.getID());
                         this.add(delete);
            }


            }
        }  

           private  static class ListEntryButton extends ActionAreaButton
        {
            public ListEntryButton(String label)
            {
                super(label);
                this.setMargin(SquirrelConstants.getFilterBarButton());
                this.setBackground(SquirrelConstants.getColorDanger());
            }


        }
        private static class ListEntryLabel extends JLabel
        {
            public ListEntryLabel(String label)
            {
            super(label);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setHorizontalTextPosition(JLabel.CENTER);
            this.setVerticalTextPosition(JLabel.BOTTOM);
            this.setBorder(SquirrelConstants.getListEntryLabelBorder());
            }

        }   
    
    }
}
