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
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Haseeb
 */
public class Filehandler {
    
    File absolutepath;
    String classname="";
    BufferedReader reader;
    String filepath;
    int index;
    String ap;
    
     private DefaultMutableTreeNode root;
     private DefaultMutableTreeNode childs;

    private DefaultTreeModel treeModel;

    private JTree tree;
    
    
     ArrayList<String> listoffiles = new ArrayList<>();
     HashMap <String ,String > hp= new HashMap<>();
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
    
    
    
    
   public JTree getjtree(File folderpath){
   
   
       filesshow(folderpath);
       
   
   return  tree;
}
   
   
   
   
   public  void filesshow(File dir) {
        
       
        
            }
        
	
    

}
