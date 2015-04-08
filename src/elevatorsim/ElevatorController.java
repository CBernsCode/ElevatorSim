
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

    public enum direction {

        DOWN, NONE, UP
    };

    public ElevatorController() {

    }

    public void moveElevator(Elevator[] elevators, Floor[] floors) {
        direction[] moves = new direction[Config.numElevators];
        for(int i = 0 ; i < elevators.length; i++){
            if(elevators[i].hasRidersGoingUp()){
                moves[i] = direction.UP;
            }else if(elevators[i].hasRidersGoingDown()){
                moves[i] = direction.DOWN;
            }else{
                moves[i] = direction.NONE;
            }
        }
        //make choices for empty elevators here. Figure out their direction or none
        
        for ( int i = 0 ; i < elevators.length; i++){
            if(moves[i] == direction.UP){
                elevators[i].moveUp();
            }else if (moves[i] == direction.DOWN){
                elevators[i].moveDown();
            }
        }
        //After we have moved all elevators run the loaders and unloaders
        //unload all
        //take on all
    } 

    public void moveElevator(Elevator ele, Floor[] floors) {
        direction status = deriveDirection(ele);

        if (status == direction.UP) { //based on buttons in elevator
            ele.moveUp();
            while (floors[ele.getCurrentFloor()].hasRidersGoingUp()) {
                ele.embarkRider(floors[ele.getCurrentFloor()].getUpQue().dequeue());
            }
            System.out.println("UP");

        } else if (status == direction.DOWN) {
            ele.moveDown();
            while (floors[ele.getCurrentFloor()].hasRidersGoingDown()) {
                ele.embarkRider(floors[ele.getCurrentFloor()].getDownQue().dequeue());
            }
            System.out.println("DOWN");
        }
        if (status == direction.NONE) {

            int i, j, upCounter = 0, downCounter = 0; //based off floors
            for (i = ele.getCurrentFloor(); i < Config.numFloors; i++) {
                if (floors[i].hasRidersGoingUp()) {
                    upCounter++;
                }
            }
            for (j = ele.getCurrentFloor(); i > 0; i--) {
                if (floors[j].hasRidersGoingDown()) {
                    downCounter++;
                }
            }
            if (upCounter > downCounter) {
                ele.moveUp();
                while (floors[ele.getCurrentFloor()].hasRidersGoingUp()) {
                    ele.embarkRider(floors[ele.getCurrentFloor()].getUpQue().dequeue());
                }
                System.out.println("UP, based on floor");
            } else if (downCounter > upCounter) {
                ele.moveDown();
                while (floors[ele.getCurrentFloor()].hasRidersGoingDown()) {
                    ele.embarkRider(floors[ele.getCurrentFloor()].getFromDownQue());
                }
                System.out.println("DOWN, based on Floor");
            }
        }
    }

    private direction deriveDirection(Elevator ele) {
        direction retVal = direction.NONE;
        for (int i = ele.getCurrentFloor(); i < Config.numFloors; i++) {
            if (ele.getButtons()[i].isActivated()) {
                retVal = direction.UP;
            }
        }
        for (int i = ele.getCurrentFloor(); i >= 0; i--) {
            if (ele.getButtons()[i].isActivated()) {
                retVal = direction.DOWN;
            }
        }
        return retVal;
    }

    private void embarkRiders(Floor flr, Elevator ele) {
        if (ele.hasRidersGoingUp()) {
            while (flr.hasRidersGoingUp() && !ele.isFull()) {
                ele.embarkRider(flr.getFromUpQue());
            }
        }
    }

    public static void main(String[] args) {

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

 the controller takes a building and breaks it down. It will move all of the 
 elevators that have passengers in the direction the pasengers desire. When 
 all of these moves are completed we will then look at the floors. We mark all 
 the floors and all of the elevators that are not moving for the passengers. We 
 will dispatch and update the list of the elevators not moving and the floors that
 need service and call the appropriate moveUp/ moveDown. This is good because if
 we assume the elevators with passengers is going to intercept and it is full the 
 wait will be worse and the elevator being less efficient. If we are wrong the 
 elevator will already be working and help with volume and also make sure that we
 can move the rider. Also good because it will keep a float constantly. 

 */
