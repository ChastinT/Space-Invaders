/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author Chastin
 */
public class Projectile extends GameObject
{
    GameObject object;
    public Projectile(GameObject object)
    {
        this.object = object;
        this.setVisible(false);
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
    Rectangle2D viewportRect = new Rectangle2D(138, 350, 15, 20);

    //As a matter of preference, I scaled the image to make it appear larger.
    this.setScaleX(1.5);
    this.setScaleY(1.5);

    //Set the viewport for this ImageView object (CmdCenter in this case).
    this.setViewport(viewportRect);

    //Set the width and height of the containing pane so that you will know when you
    //have moved the CmdCenter to the edge of the screen.        
    setParentWidth(object.getParentWidth());
    setParentHeight(object.getParentHeight());

    //Give an initial location to the CmdCenter
    this.setX(object.getParentWidth());
    this.setY(object.getParentHeight()+ 50);
    }
    
    public void move()
    {
      
            this.setY(this.getY() - 10);
        
        
    }
  
 
  
 
    public class ProjectileHandler extends AnimationTimer

    {
        public void handle(long now) 
        {
            
            move();
        }
    }
}
    


