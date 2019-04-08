/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorprogram3;

/**
 *
 * @author Chastin
 */
public abstract class Invader extends GameObject
{
    int pointValue;
    
    public Invader()
    {
        pointValue = 0;
    }
    
    public void setPointValue(int enter)
    {
        pointValue = enter;
    }
    
    public int getPointValue()
    {
        return pointValue;
    }
}
