
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

    public static void main(String[] args) {
        Random rand = new Random(System.currentTimeMillis());
        ElevatorController eleCont = new ElevatorController();
        Config.numElevators = 2;
        Config.numFloors = 10;
        Config.numRiders = 20;
        Rider[] riders = Config.generateRiders(1, rand.nextInt(Config.numFloors));
        Building building = new Building(riders);
        System.out.println(building.getFloors()[0].hasRidersGoingUp());
        System.out.println(building.getFloors()[1].hasRidersGoingUp());
        System.out.println(building.getFloors()[2].hasRidersGoingUp());
        Rider rdr1 = new Rider(0, 8);
        Rider rdr2 = new Rider(8, 0);
        Elevator[] elevators = building.getElevators();

        for (int i = 0; i < 20; i++) {
            eleCont.moveElevator(elevators[0], building.getFloors());
            eleCont.moveElevator(elevators[1], building.getFloors());
            System.out.println(elevators[0].getCurrentFloor());
            System.out.println(elevators[1].getCurrentFloor());
        }
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
