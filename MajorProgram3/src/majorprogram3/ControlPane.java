/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Chastin
 */
public class ControlPane extends Pane
{
    Button start = new Button("Start");
    Button restart = new Button("Restart");
    Button exit = new Button("Exit");
    HBox bHolder = new HBox(start,restart,exit);
   
    
    public ControlPane(GamePane gamePane)
    {
     
        this.getChildren().add(bHolder);
    }
    
}
