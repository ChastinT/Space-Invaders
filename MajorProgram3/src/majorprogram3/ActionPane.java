/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Chastin
 */
public class ActionPane extends Pane
{
    
    CmdCenter center = new CmdCenter(this);
    SpaceShip ship = new SpaceShip();
    Projectile projectile = new Projectile(center);
    ShipTimer shipTimer = new ShipTimer();
    Timer timer = new Timer();
    Random rand = new Random();
    int randNum =  rand.nextInt(5)+1;
    public ActionPane()
    {
       this.getChildren().add(ship);
        this.setPrefSize(400,400);
        this.setStyle("-fx-background-color: black");
        
       timer.scheduleAtFixedRate(new TimerTask()
       {
            @Override
            public void run() 
            {
                int randNum =  rand.nextInt(5)+1;      
               
                shipTimer.start();
            }
       },5000L,randNum * 5000L);

    }
    
 
    
  public class ShipTimer extends AnimationTimer 
  {
      
    
        @Override
        public void handle(long now) 
        {
       
      if (ship.isVisible() == false)
            {
                 
               ship.setX(500);
               ship.setVisible(true);
            }
        if (ship.isVisible())
        {
           ship.move();
         }
     
         
           if (ship.getX() < -50)
           {
               ship.setVisible(false);
               getChildren().remove(ship);
               this.stop();
           }

         
        }  
        
  }
        
  
}
  
   
                         
                     

