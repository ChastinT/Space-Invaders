/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.awt.event.KeyListener;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Chastin
 */
public class GamePane extends Application 
{
    ActionPane actionPane = new ActionPane();

    public void start(Stage stage)
    {
    BorderPane borderPane = new BorderPane();
    //ActionPane actionPane = new ActionPane();
    borderPane.setCenter(actionPane);
    KeyListener holder;
    AnimationTimer timer; 
    
    
    
    
    Scene scene = new Scene(borderPane,550,600);
    
    scene.setOnKeyPressed(new EventHandler <KeyEvent>()
            {
        @Override
        public void handle(KeyEvent event) 
        {
            if (event.getCode() == KeyCode.LEFT)
            {
               
                actionPane.ship.setDirection(180);
                 AnimationTimer timer = new AnimationTimer() 
                 {
                     
                    @Override
                    public void handle(long now) 
                    {
                        //actionPane.ship.move();
                        if (actionPane.ship.getX()>=actionPane.getLayoutX())
                        {
                        actionPane.ship.setX(actionPane.ship.getX()-5);
                        }
                       
                       
                        
                        

                    }
                   
        };
        timer.start();
        
    }
          
           if (event.getCode() == KeyCode.RIGHT)
            {
//                actionPane.ship.setDirection(0);
                 AnimationTimer timer = new AnimationTimer() 
                 {
                     
                    @Override
                    public void handle(long now) 
                    {
                        
                      if (actionPane.ship.getX()<= actionPane.getWidth())
                      {
                        actionPane.ship.setX(actionPane.ship.getX()+5);
                      }
                        

                    }
                   
        };
        timer.start();
    }
              
            }
        });
    
    
    scene.setOnKeyReleased(new EventHandler <KeyEvent>()
            {
        @Override
        public void handle(KeyEvent event) 
        {
            if (event.getCode() == KeyCode.LEFT)
            {
              
                actionPane.ship.setDirection(180);
                 AnimationTimer timer = new AnimationTimer() 
                 {
                     
                    @Override
                    public void handle(long now) 
                    {
                        //actionPane.ship.move();
                        
                        actionPane.ship.setX(actionPane.ship.getX()+5);

                    }
                   
        };
        timer.start();
        
    }
          
           if (event.getCode() == KeyCode.RIGHT)
            {
                 AnimationTimer timer = new AnimationTimer() 
                 {
                     
                    @Override
                    public void handle(long now) 
                    {
                        actionPane.ship.setX(actionPane.ship.getX()-5);

                    }
                   
        };
        timer.start();
    }
              
            }
        });
    
    
    
    stage.setScene(scene);
    stage.setTitle("Invaders");
    stage.show();
    
    }
   
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    public void addGameObject(GameObject object)
    {
        this.actionPane.getChildren().add(object);
    }

   
    

    

    
}