/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other.experimenting_with_java_ui;

/**
 *
 * @author Gregory
 */
public class MySingleton {
    public static MySingleton ms;
    public static int id=0;
    protected MySingleton(){
    this.id++;
    }
    public MySingleton getInstance()
    {
        if(this.ms == null)
        {
        this.ms = new MySingleton();
        
        }
        
        return this.ms;
    
    }
    
    public static void main(String[] args)
    {
        MySingleton myMs = new MySingleton();
        MySingleton myMs2 = new MySingleton();
        MySingleton myMs3 = myMs2.getInstance();
        System.out.println(myMs3.id);
    
    }
}
