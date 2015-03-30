
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elevatorsim;

import java.util.Random;

/**
 *
 * @author chris
 */
public class ElevatorController {
    
    public enum direction {DOWN, NONE, UP};
    
   public ElevatorController(){
       
   }
   public static void moveElevator(Elevator ele)
   {
       
       
       
   }
   
   private direction getDirection(Elevator ele){
       direction retVal = direction.NONE;
       for(int i = ele.getCurrentFloor(); i < Config.numFloors; i++){
           if(ele.getButtons()[i].isActivated()){
               retVal = direction.UP;
           }
       }
       for(int i = ele.getCurrentFloor(); i >= 0; i--){
           if(ele.getButtons()[i].isActivated()){
               retVal = direction.DOWN;
           }
       }
       return retVal;
   }
   
  public static void main (String[] args){
      Random rand = new Random(System.currentTimeMillis());
      ElevatorController eleCont = new ElevatorController();
      Config.numElevators =2;
      Config.numFloors = 10;
      Config.numRiders = 20;
      Rider[] riders = Config.generateRiders(1, 7);
      Building building = new Building(riders);
      Rider rdr1 = new Rider(0);
      Elevator[] elevators = building.getElevators();
      elevators[0].isFull();
      elevators[0].moveUp();
      System.out.println(elevators[0].getCurrentFloor());
      
              
  }
    
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
