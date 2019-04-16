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
public interface Movable 
{
    
    int east = 0;
    int west = 180;
    int north = 90;
    int south = 270;
    
    
    public void move();
     
}
