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
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(actionPane);
    KeyListener holder = null;
    
   
    
    
    
    
    Scene scene = new Scene(borderPane,550,600);
    scene.setOnKeyPressed(new EventHandler <KeyEvent>()
            {
        @Override
        public void handle(KeyEvent event) 
        {
            if (event.getCode() == KeyCode.LEFT)
            {
               
                
                  timer = new AnimationTimer() 
                 {
                     
                    @Override
                    public void handle(long now) 
                    {
                        //actionPane.ship.move();
                        if (actionPane.center.getX()>actionPane.getLayoutX())
                        {
                            actionPane.center.setDirection(180);
                        actionPane.center.move();
                         
                        }
                         if (actionPane.center.getX()<= 0)
                      {
                          
                        actionPane.center.setX(5);
                        timer.start();
                      }

                    }   
        };
        timer.start();
        
    }
          
           if (event.getCode() == KeyCode.RIGHT)
            {
               
               timer = new AnimationTimer() 
                 {
                     
                    @Override
                    public void handle(long now) 
                    {
                        
                      if (actionPane.center.getX()< actionPane.getWidth()-50)
                      {
                          actionPane.center.setDirection(0);
                     actionPane.center.move();
                      
                      }
                      if (actionPane.center.getX()>= actionPane.getWidth()-50)
                      {
                          
                          actionPane.center.setX(actionPane.getWidth() - 55);
                         
                          
                      }
                            
                    }
                   
        };
        timer.start();
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
                        
                        if (now - previous < 2000000000L )
                        {
                          
                            
                           actionPane.center.fireProjectile();  
                           
                           System.out.println(now+"\n"+previous);
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
    
    //KeyReleased
    scene.setOnKeyReleased(new EventHandler <KeyEvent>()
            {
        @Override
        public void handle(KeyEvent event) 
        {
            if (event.getCode() == KeyCode.LEFT)
            {
              
                actionPane.center.setDirection(180);
                 timer = new AnimationTimer() 
                 {
                     
                    @Override
                    public void handle(long now) 
                    {
                        //actionPane.ship.move();
                          if (actionPane.center.getX()>actionPane.getLayoutX())
                        {
                            
                        actionPane.center.setX(actionPane.center.getX()+5);
                         
                        }
                        
                         if (actionPane.center.getX()<= 0)
                      {
                          
                        actionPane.center.setX(5);
                        timer.start();
                      }
                         

                    }
                   
        };
        timer.start();
        
    }
          
           if (event.getCode() == KeyCode.RIGHT)
            {
                 timer = new AnimationTimer() 
                 {
                     
                    @Override
                    public void handle(long now) 
                    {
                        actionPane.center.setX(actionPane.center.getX()-5);
                        
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