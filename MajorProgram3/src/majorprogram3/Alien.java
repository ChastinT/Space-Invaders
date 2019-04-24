/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.Image image = new Image( new FileInputStream("C:\\Users\\Chastin\\COMP167\\MajorProg3\\major-program-3-ChastinT\\img\\spritesheet.jpg"));
    this.setImage(image);
 */
package majorprogram3;


import java.io.FileInputStream;
import java.util.Timer;
import java.util.TimerTask;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author Chastin
 */
public class Alien extends Invader
{
    private int alienType;
    Rectangle2D [] viewportsRects = new Rectangle2D [2];
    int currentImage = 0;
    Timer alienMover = new Timer();
    AlienTask alienTask = new AlienTask();
    
    ActionPane actionPane;
    
    public Alien(ActionPane actionPane,Image sprites,int aType)
    {
        
         try 
    { 
        
    sprites = new Image( new FileInputStream("C:\\Users\\Chastin\\COMP167\\MajorProg3\\major-program-3-ChastinT\\img\\spritesheet.jpg"));
    this.setImage(sprites);
    }
    catch (java.io.FileNotFoundException ex) 
    {
    System.err.println(ex.getMessage());
    System.exit(-1);
    }
        this.actionPane = actionPane;
        alienType = aType;
        if (alienType == 0) //First row of aliens
        {
       viewportsRects[0] = new Rectangle2D(300, 380, 80, 60);
       viewportsRects[1] = new Rectangle2D(380, 380, 80, 60);
       this.setPointValue(40);
        }
          if (alienType == 1) //Second row of aliens
        {
       viewportsRects[0] = new Rectangle2D(300, 460, 80, 60);
       viewportsRects[1] = new Rectangle2D(380, 460, 80, 60);
       this.setPointValue(20);
        }
             if (alienType == 2) //Last row of aliens
        {
       viewportsRects[0] = new Rectangle2D(300, 520, 80, 100);
       viewportsRects[1] = new Rectangle2D(390, 520, 80, 100);
       this.setPointValue(10);
        }
             
        
         //Specify which portion of the sprite sheet you want displayed. by giving the (x,y)  
    //location of the top-left corner and the width and the height.
    this.setViewport(viewportsRects[currentImage]);

    //As a matter of preference, I scaled the image to make it appear larger.
    this.setScaleX(.4);
    this.setScaleY(.4);

    //Set the viewport for this ImageView object (CmdCenter in this case).
    

    //Set the width and height of the containing pane so that you will know when you
    //have moved the CmdCenter to the edge of the screen.        
    setParentWidth(getParentWidth());
    setParentHeight(getParentHeight());
    
     //Give an initial location to the CmdCenter
    this.setX(getParentWidth() + 350);
    this.setY(getParentWidth() + 200);
    this.setDirection(0); 
    this.setSpeed(5);
    this.setVisible(true);
   
   //alienMover.scheduleAtFixedRate(alienTask,0L,2000L);

    }
    

    public void setAlienType(int enter)
    {
        alienType = enter;
    }
    
    public int getAlienType()
    {
       return alienType;
    }

   
    public void move() 
    {
       
       double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()) );
          if (!(newX < 0 || newX > 500))
        {
        this.setX( newX );
         toggleImage();  
        }
            
           
    }
    
    public Alien getAlien()
    {
        return this;
    }
    
    public void toggleImage()
    {
        if (this.getViewport() == viewportsRects[1])
        {
           
            this.setViewport(viewportsRects[0]);
            
        }
        else
        if (this.getViewport() == viewportsRects[0])
        {
          
            this.setViewport(viewportsRects[1]);
            
        }
         
    }
    
    
    public class AlienTask extends TimerTask
    {
        @Override
        public void run() 
        {
            move();
        }

    
        
    }
  
}
