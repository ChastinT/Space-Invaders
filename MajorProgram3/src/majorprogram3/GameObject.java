/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.scene.image.ImageView;

/**
 *
 * @author Chastin
 */
public abstract class GameObject extends ImageView implements Movable
{
    double direction;
    double speed;
    double parentWidth;
    double parentHeight;
    
    public GameObject() 
    {
    direction = 0;
    speed = 0;
    parentWidth = 0;
    parentHeight = 0;
    }
    
     public GameObject(double direction,double speed,double parentWidth,double parentHeight)
    {
    this.direction = direction;
    this.speed = speed;
    this.parentWidth = parentWidth;
    this.parentHeight = parentHeight;
    }
     
     public void setDirection(double enter)
     {
         direction = enter;
     }
     
     public double getDirection()
     {
         return direction;
     }
     
      public void setSpeed(double enter)
     {
         speed = enter;
     }
     
     public double getSpeed()
     {
         return speed;
     }
     
     public void setParentWidth(double enter)
     {
         parentWidth = enter;
     }
     
     public double getParentWidth()
     {
         return parentWidth;
     }
     
      public void setParentHeight(double enter)
     {
         parentHeight = enter;
     }
     
     public double getParentHeight()
     {
         return parentHeight;
     }
     
     public void move()
     {
         double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()));
         double newY = this.getY() + getSpeed() * Math.sin(Math.toRadians(getDirection()));
         this.setX( newX );
         this.setY( newY );
     }
}
