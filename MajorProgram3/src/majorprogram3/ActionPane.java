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
import javafx.scene.layout.GridPane;
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
    int points = 0;
    
    TheHord hord = new TheHord(this);
    ShipTask shipTask = new ShipTask();
    ShipAnimate shipAnimate = new ShipAnimate();
    Timer timer = new Timer();
    Random rand = new Random();
    int randNum =  rand.nextInt(6)+1;
    Random randLauncher = new Random();
    int launcher =  rand.nextInt(2)+1;
    GridPane grid = new GridPane();
    public ActionPane()
    {
      
        this.setPrefSize(500,700);
        this.setStyle("-fx-background-color: black");
        
       
       timer.scheduleAtFixedRate(shipTask,5000L,randNum * 5000L);

    }
    
   public class ShipTask extends TimerTask
  {

        @Override
        public void run() 
        {
           Random rand = new Random();
                int randNum =  rand.nextInt(5)+1;      
               points = randNum * 50;
                 Random randLauncher = new Random();
                int launcher =  rand.nextInt(1)+1;
                shipAnimate.start();
        }
      
  }
    
  public class ShipAnimate extends AnimationTimer 
  {
      
    
        @Override
        public void handle(long now) 
        {
       if (launcher == 1) // Starting from right to left
       {
      if (ship.isVisible() == false)
            {
                 getChildren().add(ship);
                 ship.setPoints(points);
               ship.setX(500);
               ship.setVisible(true);
            }
        if (ship.isVisible())
        {
           ship.move();
         }
          if (ship.getY() == center.getProjectile().getY()+1 && ship.getX() <= center.getProjectile().getX()+20 && ship.getX() >= center.getProjectile().getX()-50) //To fix the margin of error
                        {
                                  if (ship.isVisible() && center.getProjectile().isVisible())
                                  {
                         ship.setVisible(false);
                        center.getProjectile().setVisible(false);
                         getChildren().remove(center.getProjectile());
                         getChildren().remove(ship);
                         ship.setX(500);
                         this.stop();
                                  }
                        } 
         
           if (ship.getX() < 0)
           {
               ship.setVisible(false);
               getChildren().remove(ship);
               this.stop();
           }
       }
       
       if (launcher == 2) // Starting from left to right
       {
      if (ship.isVisible() == false)
            {
                 getChildren().add(ship);
                 ship.setPoints(points);
               ship.setX(0);
               ship.setDirection(0);
               ship.setVisible(true);
            }
        if (ship.isVisible())
        {
           ship.move();
         }
          if (ship.getY() == center.getProjectile().getY()+1 && ship.getX() <= center.getProjectile().getX()+20 && ship.getX() >= center.getProjectile().getX()-50) //To fix the margin of error
                        {
                                  if (ship.isVisible() && center.getProjectile().isVisible())
                                  {
                         ship.setVisible(false);
                        center.getProjectile().setVisible(false);
                         getChildren().remove(center.getProjectile());
                         getChildren().remove(ship);
                         ship.setX(0);
                         this.stop();
                                  }
                        } 
         
           if (ship.getX() > 500)
           {
               ship.setVisible(false);
               getChildren().remove(ship);
               this.stop();
           }
       }
           
           


         
        }  
          
  }
  
}
  
   
                         
                     

