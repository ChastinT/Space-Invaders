/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

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
    Projectile projectile = new Projectile(center);
    public ActionPane()
    {
        this.setLayoutX(400);
        this.setLayoutY(200);
        this.setStyle("-fx-background-color: #000000");
       
       
    }
    
 
    
 
    
                     
}
