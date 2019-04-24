/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import java.util.Timer;
import java.util.TimerTask;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Chastin
 */
public class TheHord 
{
     Alien [][] aliens = new Alien[5][11];
    private double direction;
    private double lastDirection;
    private int numLiving;
    private boolean atEdge = false;
    Timer hordMover = new Timer();
    HordTask hordTask = new HordTask();
    ActionPane actionPane;
  
    private Image alienSprites;
      
     
   public TheHord()
   {
       
   }
    
    public TheHord(ActionPane actionPane)
    {
      this.actionPane = actionPane;
        
        for (int i = 0; i < aliens.length; i++)
        {
            for (int j = 0; j < aliens[i].length;j++)
            {
                
              Alien alien = new Alien(actionPane,null,0);
              if (i == 0)
              {
                  alien = new Alien(actionPane,null,0);
              }
               if (i < 3 && i > 0)
              {
                alien = new Alien(actionPane,null,1);
              }
               else if (i >= 3 )
              {
                   alien = new Alien(actionPane,null,2);
              }
                
              aliens[i][j] = alien;
          
               
            }
        }
        
                   
   
        this.initTheHord();
        hordMover.scheduleAtFixedRate(hordTask,0L,1000L);
        
        
    }

    public void move() 
    { 
        if (getAlien(aliens.length-1,aliens[aliens.length-1].length-1).getX() > 0 && getAlien(aliens.length-1,aliens[aliens.length-1].length-1).getX() < 500)
    {
        for (int i = 0; i < aliens.length;i++)
        {
            for (int j = 0; j < aliens[i].length;j++)
            {
                
                if (getAlien(i,j).getX() > 0 && getAlien(i,j).getX() < 500)
                {
                    getAlien(i,j).move();
            
                }
            }
        }
    }
    
               if(getAlien(aliens.length - 1,aliens[aliens.length-1].length-1).getX() == 500)
                {
                 
                    for (int i = 0; i < aliens.length;i++)
                    {
                        for (int j = 0; j < aliens[i].length;j++)
                        {


                                getAlien(i,j).setDirection(90);
                                getAlien(i,j).setY(getAlien(i,j).getY() + getAlien(i,j).getSpeed() * Math.sin(Math.toRadians(getAlien(i,j).getDirection())));
                                getAlien(i,j).setDirection(180);
                               getAlien(i,j).setX(getAlien(i,j).getX() + getAlien(i,j).getSpeed() * Math.cos(Math.toRadians(getAlien(i,j).getDirection())));

                        }
                    }
        
    
                }
                    
               if(getAlien(0,0).getX() == 0)
                {
                    
                    for (int i = 0; i < aliens.length;i++)
                    {
                        for (int j = 0; j < aliens[i].length;j++)
                        {

                                
                                getAlien(i,j).setDirection(90);
                                getAlien(i,j).setY(getAlien(i,j).getY() + getAlien(i,j).getSpeed() * Math.sin(Math.toRadians(getAlien(i,j).getDirection())));
                                getAlien(i,j).setDirection(0);
                               getAlien(i,j).setX(getAlien(i,j).getX() + getAlien(i,j).getSpeed() * Math.cos(Math.toRadians(getAlien(i,j).getDirection())));

                        }
                    }
        
    
                }
               
                   
                     
                      
                     
                    
                    
                
                    
                
            
        }
        
    



    public void initTheHord()
    {
        for (int i = 0; i < aliens.length;i++)
        {
            for (int j = 0; j < aliens[i].length;j++)
            {
                this.getAlien(i, j).setX(20+(j *40));
                this.getAlien(i, j).setY(150+(i *50));
                
                 
            }
        }
        
          for (int i = 0; i < aliens.length;i++)
        {
            for (int j = 0; j < aliens[i].length;j++)
            {
                actionPane.getChildren().add(getAlien(i,j));
            }
        }
    }
    
    public void resetTheHord()
    {
        
    }
    
    public void changeDirection()
    {
        if (this.direction == 0)
        {
            this.direction = 180;
        }
         if (this.direction == 180)
        {
            this.direction = 0;
        }
    }
    
    public Alien getAlien(int row,int col)
    {
        return  aliens[row][col];    
    }
    
    public class HordTask extends TimerTask
    {
        @Override
        public void run() 
        {
            move();
        }

    
        
    }

}
