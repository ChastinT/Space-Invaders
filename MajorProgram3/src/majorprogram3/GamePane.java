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
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Chastin
 */
public class GamePane extends Application 
{
    ActionPane actionPane = new ActionPane();
 AnimationTimer timer;   
 
 long lastShot = 0;
 int shotInterval = 500; 
 long previous = 0;
    public void start(Stage stage)
    {
    StackPane stackPane = new StackPane();
    stackPane.getChildren().add(actionPane);
    KeyListener holder = null;

    
    
    
    
    Scene scene = new Scene(stackPane,550,600);
    scene.setOnKeyPressed(new EventHandler <KeyEvent>()
            {
        @Override
        public void handle(KeyEvent event) 
        {
            if (event.getCode() == KeyCode.LEFT)
            {
               
                
                 actionPane.center.setDirection(180);
                        actionPane.center.move();
                        //actionPane.ship.move();
            }       
                      if (event.getCode() == KeyCode.RIGHT)
                      {
                          actionPane.center.setDirection(0);
                     actionPane.center.move();
                    }
           
           if (event.getCode() == KeyCode.SPACE && actionPane.center.getProjectile().isVisible() ==  false)
            {
               actionPane.getChildren().add(actionPane.center.getProjectile());
                  timer = new AnimationTimer() 
                         
                 {
                     
                    @Override
                    public void handle(long now) 
                    {
                       if (previous == 0)
                       {
                           previous = now;
                       }
                        
                        if (now - previous < 20000000000L )
                        {
                          
                            
                           actionPane.center.fireProjectile();  
                           
                           //System.out.println(now+"\n"+previous);
                        }
                       
                       if (actionPane.center.getProjectile().isVisible()  )
                        {    
                            {
                            actionPane.center.getProjectile().move();
                            previous = now;
                            }
                        }
                        
                           
                             if (actionPane.center.getProjectile().getY()<actionPane.getLayoutY())
                            {
                                
                                actionPane.center.getProjectile().setVisible(false); 
                                actionPane.getChildren().remove(actionPane.center.getProjectile());
                                
                                timer.stop();
                               
                               
                                
                            }
                           
                        }
                       
   
                    
                   
        };

            
            
            } 
            timer.start();
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