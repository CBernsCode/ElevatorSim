
package elevatorsim;

public class ElevatorController {

    public ElevatorController() {

    }

    public void moveElevators(Elevator[] elevators, Floor[] floors) {

        //need to start some varibles to keep track of things
        //Derive needed moves here
        boolean dispatched = true;
        for(Floor flr : floors){
            if(flr.hasRidersGoingDown() || flr.hasRidersGoingUp()){
                dispatched = false;
            }
        }

        //if it has passengers continue moving. Move one empty one if not
        for (Elevator ele : elevators) {
            if (ele.getCurrentFloor() == 0 && ele.isEmpty()) {
                while (!ele.isFull() && floors[ele.getCurrentFloor()].hasRidersGoingUp()) {
                    //testing here
                    Rider ride;
                    ride = floors[ele.getCurrentFloor()].getFromUpQue();                   
                    ele.embarkRider(ride);
                }
            } else if (ele.hasRidersGoingUp()) {
                ele.moveUp();
                while (ele.disembarkRider() != null) {
                    ele.disembarkRider();
                }
                while (!ele.isFull() && floors[ele.getCurrentFloor()].hasRidersGoingUp()) {
                    ele.embarkRider(floors[ele.getCurrentFloor()].getFromUpQue());
                }
            } else if (ele.hasRidersGoingDown()) {
                ele.moveDown();
                while (ele.disembarkRider() != null) {
                    ele.disembarkRider();
                }
                while (!ele.isFull() && floors[ele.getCurrentFloor()].hasRidersGoingDown()) {
                    ele.embarkRider(floors[ele.getCurrentFloor()].getFromDownQue());
                }
            } else if (ele.isEmpty() && dispatched == false) {
                ele.moveUp();
                dispatched = true;
                while (ele.disembarkRider() != null) {
                    ele.disembarkRider();
                }
                while (!ele.isFull() && floors[ele.getCurrentFloor()].hasRidersGoingUp()) {
                    ele.embarkRider(floors[ele.getCurrentFloor()].getFromUpQue());
                }
            } else {
                ele.moveDown(); // default is to move to bottom
                while (ele.disembarkRider() != null) {
                    ele.disembarkRider();
                }
                while (!ele.isFull() && floors[ele.getCurrentFloor()].hasRidersGoingDown()) {
                    ele.embarkRider(floors[ele.getCurrentFloor()].getFromDownQue());
                }
            }
        }

    }

    public static void main(String[] args) {

        Config.numElevators = 3;
        Config.numRiders = 15;
        Config.numFloors = 4;
        
        Rider[] testRiders = Config.initRiders();
       
        Building building = new Building(testRiders);
        ElevatorController eleContrl = new ElevatorController();
       
        for (Elevator ele : building.getElevators()) {
            ele.eleToString();
        }
        eleContrl.moveElevators(building.getElevators(), building.getFloors());
        for (Elevator ele : building.getElevators()) {
            ele.eleToString();
        }
        eleContrl.moveElevators(building.getElevators(), building.getFloors());
        for (Elevator ele : building.getElevators()) {
            ele.eleToString();
        }
        eleContrl.moveElevators(building.getElevators(), building.getFloors());
        for (Elevator ele : building.getElevators()) {
            ele.eleToString();
        }
        eleContrl.moveElevators(building.getElevators(), building.getFloors());
        for (Elevator ele : building.getElevators()) {
            ele.eleToString();
        }
        eleContrl.moveElevators(building.getElevators(), building.getFloors());
        for (Elevator ele : building.getElevators()) {
            ele.eleToString();
        }
        eleContrl.moveElevators(building.getElevators(), building.getFloors());
        for (Elevator ele : building.getElevators()) {
            ele.eleToString();
        }
        eleContrl.moveElevators(building.getElevators(), building.getFloors());
        for (Elevator ele : building.getElevators()) {
            ele.eleToString();
        }
        eleContrl.moveElevators(building.getElevators(), building.getFloors());
        for (Elevator ele : building.getElevators()) {
            ele.eleToString();
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
