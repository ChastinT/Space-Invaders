/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import java.awt.geom.Rectangle2D;
import javafx.scene.image.Image;

/**
 *
 * @author Chastin
 */
public class Alien 
{
    int alienType;
    Rectangle2D [] viewportsRects = new Rectangle2D [2];
    int currentImage;
    ActionPane actionPane;
    
    public Alien(ActionPane actionPane,Image sprites,int aType)
    {
        this.actionPane = actionPane;
    }
    
    public void setAlienType(int enter)
    {
        alienType = enter;
    }
    
    public int getAlienType()
    {
       return alienType;
    }
  
}
