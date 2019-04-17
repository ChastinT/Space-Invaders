/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.scene.layout.StackPane;

/**
 *
 * @author Chastin
 */
public class TitlePane extends StackPane
{
    TitleGraphic titleGraphic = new TitleGraphic(this);
    public TitlePane()
    {
        this.setStyle("-fx-background-color: black");
        this.getChildren().add(titleGraphic);
    }
    
}
