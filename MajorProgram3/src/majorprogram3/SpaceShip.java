/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author Chastin
 */
public class SpaceShip extends Invader
{
    Timer moveTimer;
    Timer launchTimer = new Timer();
    GamePane gamePane;
    Random rand;
    int randNum;
    public SpaceShip()
    {
      
        this.setVisible(false);
        //this.setPointValue(randNum);
         try 
    {           
    Image image = new Image( new FileInputStream("C:\\Users\\Chastin\\COMP167\\MajorProg3\\major-program-3-ChastinT\\img\\spritesheet.jpg"));
    this.setImage(image);
    }
    catch (java.io.FileNotFoundException ex) 
    {
    System.err.println(ex.getMessage());
    System.exit(-1);
    }

    //Specify which portion of the sprite sheet you want displayed. by giving the (x,y)  
    //location of the top-left corner and the width and the height.
    Rectangle2D viewportRect = new Rectangle2D(170, 170, 40, 30); //x,y,length,width

    //As a matter of preference, I scaled the image to make it appear larger.
    this.setScaleX(1.5);
    this.setScaleY(1.5);

    //Set the viewport for this ImageView object (CmdCenter in this case).
    this.setViewport(viewportRect);

    //Set the width and height of the containing pane so that you will know when you
    //have moved the CmdCenter to the edge of the screen.        
    setParentWidth(getParentWidth());
    setParentHeight(getParentHeight());

    //Give an initial location to the CmdCenter
    this.setX(500);
    this.setY(100);
    this.setSpeed(1);
    this.direction = 180;
    
    
    }
    
    public void move()
    {
        
         double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()) );
         this.setX(newX);
    }
    
      public void startLaunchTimer()
      {
          TimerTask launcher = new TimerTask()
          {
              @Override
              public void run() 
              {
                Random rand = new Random();
        int randNum = (rand.nextInt(5) + 1) * 5;
      
                       
        
              }
              
          };
         launchTimer.scheduleAtFixedRate(launcher, System.currentTimeMillis()+1000L, System.currentTimeMillis() + (long)(randNum * 1000L));
        
      }



    
    
 }
    
   
           

