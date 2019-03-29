/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Haseeb
 */
public class Filehandler {
    ArrayList<String> methods= new ArrayList<>();
    
     File absolutepath;
    String classname="";
    BufferedReader reader;
    String filepath;
    int index;
    String ap;
    
     private DefaultMutableTreeNode root;
     private DefaultMutableTreeNode childs;



    private JTree tree;
    String wholefile="";
    
     ArrayList<String> listoffiles = new ArrayList<>();
     HashMap <String ,String > hp= new HashMap<>();
     
     
     public String readsinglefile(String fpath){
         
                    try{
                           BufferedReader   readerf = new BufferedReader(new  FileReader(fpath));

                          String singleline=readerf.readLine();
                          while(singleline!=null){

                              wholefile+="\n"+singleline;
                             singleline= readerf.readLine();
                          }

                    }catch(IOException e){

                           System.out.println(e);
                    }



                    return wholefile;
     }
    public JTree readfile(HashMap<String,String> mp ){
        
//       this.listoffiles=a;
     root=new DefaultMutableTreeNode("java");
      this.hp=mp;
      int i=0;
      String path="";
      for (Object value : hp.values()) {
          childs= new DefaultMutableTreeNode(value.toString());
          root.add(childs);
    System.out.println("Value: "+ value);
    if(i==0){
    path=value.toString();
    
    }
    
    
}
       
      tree=new JTree(root);
//       String index= listoffiles.get(0);
//       
//       filepath+="\\"+index;
try{
    
    reader = new BufferedReader(new  FileReader(path));
    
    
    String line= reader.readLine();
    while(line != null ){
    
//        System.out.println(line);
       
String[] items = line.split(" ");

        for(int j=0;j<items.length;j++){
        
            if(items[j].equalsIgnoreCase("class")){
            
                index=j;
                classname=items[index+1];
            }
        }

       

   line= reader.readLine();
   
   
    }
    
    System.out.println("\nClass name " + classname);
    
  
}       catch(IOException e){

    System.out.println(e);

}
        
    return tree;
    
    }
    
    
    
    public String checkclassName(String pathtoFile){
    
        String cname="";
        
        try{
    
    reader = new BufferedReader(new  FileReader(pathtoFile));
    
    
                    String line= reader.readLine();
                    while(line != null ){

                //        System.out.println(line);

                String[] items = line.split(" ");

                        for(int j=0;j<items.length;j++){

                            //for methods
                            
                            if(items[j].equalsIgnoreCase("public") || items[j].equalsIgnoreCase("private") ||items[j].equalsIgnoreCase("protected"))
                            {
                                    methods.add(items[j+2]);
                            
                            }
                            
                            //
                            
                            if(items[j].equalsIgnoreCase("class")){

                                index=j;
                                cname=items[index+1];
                            }
                        }



                   line= reader.readLine();


                    }

                    System.out.println("\nClass name " + cname);
                    
                    for(String temp:methods){
                    
                   System.out.println("\nMethod name: "+temp);
                    }


                }       catch(IOException e){

                    System.out.println(e);
                 
                   

                }
        return cname ;
        
    
    }

        

    

}
