    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author Chastin
 */
public class StatusPane extends Pane
{
    private int points = 0;
      Label score = new Label("SCORE: "+getPoints());
    public StatusPane()
    {
        score.setStyle("-fx-text-fill:red");
        score.setFont(new Font(score.getText(),20));
        this.getChildren().add(score);
        this.setStyle("-fx-background-color: black");
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) 
    {
        
        this.points += points;
        this.score.setText("SCORE: "+this.points);
    }
}
