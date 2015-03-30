
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elevatorsim;

/**
 *
 * @author chris
 */
public class ElevatorController {
    
   
    
}

/*
Should take an array of elevators and compare which one has riders going up or 
down. If the elevator has riders going up it is going up. If the elevator has no
riders, it will look for buttons pressed above. If there is a button activated 
we will look at the elevator that is closest without riders going in the opposite 
direction. The elevator controller will just make the elevator go up and down

Elevator Controller:
    if the elevator has riders, the direction of riders determines if goign up 
    or down

    if the elevator is empty, the buttons determine the direction of the elevator
    if it is empty.

    if the the a button is pressed and is a dest floor of the rider - STOP,
    if the button of the current floor is activated and the elevator is not full it stops
        
*/
