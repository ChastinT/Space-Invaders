/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Chastin
 */
public class TitlePane extends StackPane
{
    TitleGraphic titleGraphic = new TitleGraphic(this);
    Label controls = new Label("Controls"+"\n"+"Shoot: Z");
   
    public TitlePane()
    {
       this.setPrefSize(300, 300);
        controls.setStyle("-fx-text-fill:white");
        controls.setTranslateY(200);
       
        this.setStyle("-fx-background-color: black");
        this.getChildren().add(titleGraphic);
        this.getChildren().add(controls);
        
        
    }
    
}
