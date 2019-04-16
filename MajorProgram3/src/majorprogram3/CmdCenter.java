/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Chastin
 */
public class CmdCenter extends GameObject 
{
  private Projectile projectile = new Projectile(this);

    public CmdCenter(ActionPane actionPane)
    {

      actionPane.getChildren().add(this);
      //actionPane.getChildren().add(projectile);
        //Read in the entire sprite sheet from disk.
        
        
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
    Rectangle2D viewportRect = new Rectangle2D(220, 150, 30, 50);
     //Destroyed fort 2: Rectangle2D viewportRect = new Rectangle2D(300, 150, 30, 50);
    //As a matter of preference, I scaled the image to make it appear larger.
    this.setScaleX(1.5);
    this.setScaleY(1.5);

    //Set the viewport for this ImageView object (CmdCenter in this case).
    this.setViewport(viewportRect);

    //Set the width and height of the containing pane so that you will know when you
    //have moved the CmdCenter to the edge of the screen.        
    setParentWidth(actionPane.getPrefWidth());
    setParentHeight(actionPane.getPrefHeight());

    //Give an initial location to the CmdCenter
    this.setX(getParentWidth() +300);
    this.setY(getParentHeight() + 500);
    
    
    this.speed = 15;
    this.parentHeight = 10;
    this.parentWidth = 10;
    
 
    
    }
    
    public void move()
    {
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()) );
        if (!(newX < 0 || newX > 525))
        {
        this.setX( newX );
        }
    }
    
    public Projectile getProjectile()
    {
        return this.projectile;
    }
    
    public void fireProjectile()
    {
        if (!(this.getProjectile().isVisible()))
        { 
            
            this.getProjectile().setVisible(true);
       this.getProjectile().setX(this.getX());
       this.getProjectile().setY(this.getY()+ 10);
      
        }
   
       
       
    }
}
