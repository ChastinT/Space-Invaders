/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.io.FileInputStream;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Chastin
 */
public class TitleGraphic extends GameObject
{
    public TitleGraphic(StackPane stackPane)
    {

      
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
    Rectangle2D viewportRect = new Rectangle2D(130, 0, 200, 140);
     //Destroyed fort 2: Rectangle2D viewportRect = new Rectangle2D(300, 150, 30, 50);
    //As a matter of preference, I scaled the image to make it appear larger.
    this.setScaleX(1.5);
    this.setScaleY(1.5);

    //Set the viewport for this ImageView object (CmdCenter in this case).
    this.setViewport(viewportRect);

    //Set the width and height of the containing pane so that you will know when you
    //have moved the CmdCenter to the edge of the screen.        
    setParentWidth(stackPane.getPrefWidth());
    setParentHeight(stackPane.getPrefHeight());

    //Give an initial location to the CmdCenter
    this.setX(getParentWidth() +270);
    this.setY(getParentHeight() + 450);
    
 
    
}

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}