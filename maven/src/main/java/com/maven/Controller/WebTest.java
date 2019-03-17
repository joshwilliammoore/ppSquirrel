/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.Controller;

import com.google.gson.Gson;
import com.maven.model.CustomException;
import com.maven.model.SquirrelConstants;
import com.maven.model.TaskList;
import java.io.BufferedInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.maven.model.Task;

/**
 *
 * @author Regory Gregory
 */
public class WebTest {

        private String urlString;


        public WebTest()
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
        public Task[] getWebLists() throws CustomException
        {
            String fetchedString = this.fetch();
            Gson converter = new Gson();
            System.out.println(fetchedString);
            Task[] tList = converter.fromJson(fetchedString, Task[].class);
            return tList;
        }

        public String getUrlString() {
            return urlString;
        }

        public void setUrlString(String urlString) {
            this.urlString = urlString;
        }

    }  
