/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Chastin
 */
public class ControlPane extends Pane
{

    private static Class<? extends Application> GamePane;
    Button start = new Button("Start");
    Button restart = new Button("Restart");
    Button exit = new Button("Exit");
    HBox bHolder = new HBox(start,restart,exit);
    
   Stage stage = new Stage();
    
    public ControlPane()
    {
     start.setOnMousePressed(new EventHandler <MouseEvent>() {
         @Override
         public void handle(MouseEvent event) 
         {
             
         
           
          
         }
     });
   
     exit.setOnMousePressed(new EventHandler <MouseEvent>() {
         @Override
         public void handle(MouseEvent event) 
         {
            System.out.println("this should exit");
            System.exit(0);
         }
     });
        this.getChildren().add(bHolder);
        
        
    }
    
  
    
}
