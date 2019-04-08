/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Chastin
 */
public class ActionPane extends Pane
{
    CmdCenter ship = new CmdCenter(this);
    public ActionPane()
    {
        this.setLayoutX(500);
        this.setLayoutY(800);
        this.setStyle("-fx-background-color: #000000");
       
       
    }
            
}
