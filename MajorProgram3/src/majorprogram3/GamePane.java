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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
    StatusPane statusPane = new StatusPane();
    ControlPane controlPane = new ControlPane();
    BorderPane borderPane = new BorderPane();
    GameHandler gameHandler = new GameHandler();
 AnimationTimer timer = new AnimationTimer() 
 {
        @Override
        public void handle(long now) 
        {
          
        }
    }; 
 long previous = 0; //Used for projectile 
    public void start(Stage stage)
    {
        
    TitlePane stackPane = new TitlePane();
    stackPane.setPrefSize(300, 300);

    borderPane.setCenter(stackPane);
    borderPane.setBottom(controlPane);
   
    
    Scene scene = new Scene(borderPane,550,600);
    
    
    controlPane.start.setOnMousePressed(new EventHandler<MouseEvent>() //Setting controlPane Buttons
    {
        @Override
        public void handle(MouseEvent event) 
        {
            
            borderPane.setCenter(actionPane);
            borderPane.setTop(statusPane);
            scene.setOnKeyPressed(gameHandler);
        }
        
    });
    controlPane.restart.setOnMousePressed(new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent event) 
        {
            actionPane = new ActionPane();
          statusPane = new StatusPane();
          borderPane.setTop(statusPane);
          borderPane.setCenter(actionPane);
          scene.setOnKeyPressed(gameHandler);
        }
        
    });
    
    
    stage.setScene(scene);
    stage.setTitle("Invaders");
    stage.show();
    
    }
    
   
  
    
    public void addGameObject(GameObject object)
    {
        this.actionPane.getChildren().add(object);
    }

  
    public class GameHandler implements EventHandler<KeyEvent>
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
           
           if (event.getCode() == KeyCode.Z && actionPane.center.getProjectile().isVisible() ==  false)
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
                        
                         if (actionPane.ship.getY() == actionPane.center.getProjectile().getY()+1 && actionPane.ship.getX() <= actionPane.center.getProjectile().getX()+20 && actionPane.ship.getX() >= actionPane.center.getProjectile().getX()-50) //To fix the margin of error
                        {
                                  if (actionPane.ship.isVisible() && actionPane.center.getProjectile().isVisible())
                                  {
                         actionPane.ship.setVisible(false);
                         actionPane.center.getProjectile().setVisible(false);
                         actionPane.getChildren().remove(actionPane.center.getProjectile());
                        
                         actionPane.ship.setX(500);
                         statusPane.setPoints(actionPane.ship.getPoints());
                         actionPane.shipTimer.stop();
                          timer.stop();
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
        }
    
     public static void main(String[] args) 
    {
       launch(args);
    }
     

    

    
     

    
    

}
    
    


    

    

    

    
