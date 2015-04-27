package elevatorsim;

import java.util.LinkedList;

public class Elevator {

    public enum elevatorDirections {

        DOWN, NONE, UP
    };
    private static int idGen = 0;
    private final int id;
    private int currentFloor;
    private int capacity;
    private int passengers;
    private ElevatorButton[] buttons;
    private LinkedList<Rider>[] anchors;

    public Elevator() {
        id = idGen++;
        passengers = 0;
        currentFloor = 0;
        init();
        capacity = Config.capOfElevators;
        opperateButtons();
    }

    public Elevator(int capacity) {
        id = idGen++;
        passengers = 0;
        currentFloor = 0;
        init();
        this.capacity = capacity;
        opperateButtons();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    //get a rider, get dest floor, place on propper list
    public void embarkRider(Rider rider) {
        
        try {
            
            anchors[rider.getDestFloor()].add(rider);
            passengers++;
            //rider.riderToString();
        } catch (Exception e) {
            System.out.println("Error in embarkRider");
        }
        opperateButtons();
    }

    public Rider disembarkRider() {
        Rider rider = null;
        try {
            rider = anchors[this.currentFloor].removeLast();
            passengers--;

        } catch (Exception e) {
            //
        }
        opperateButtons();
        if(rider != null){
            rider.setStopTime(Clock.getTime());
            DataCollector.addRiderToList(rider);
            
        }
        
        return rider;
    }

    public boolean isFull() {
        boolean retBool = false;
        if (this.capacity <= this.passengers) {
            retBool = true;
        }
        return retBool;
    }

    public boolean isEmpty() {
        boolean retVal = true;
        if (passengers > 0) {
            retVal = false;
        }
        return retVal;
    }

    public int getPassengers() {
        return this.passengers;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public void setCurrentFloor(int a) {
        this.currentFloor = a;
    }

    public void moveUp() {
        if (this.currentFloor < Config.numFloors - 1) {
            this.currentFloor++;
        }

    }

    public void moveDown() {
        if (this.currentFloor > 0) {
            this.currentFloor--;
        }
    }

    public ElevatorButton[] getButtons() {
        return buttons;
    }

    public boolean hasRidersGoingUp() {
        boolean retVal = false;
        for (int i = this.currentFloor; i < Config.numFloors; i++) {
            if (buttons[i].isActivated()) {
                retVal = true;
            }
        }
        return retVal;
    }

    public boolean hasRidersGoingDown() {
        boolean retVal = false;
        for (int i = this.currentFloor; i >= 0; i--) {
            if (buttons[i].isActivated()) {
                retVal = true;
            }
        }
        return retVal;
    }

    private void init() {

        this.anchors = new LinkedList[Config.numFloors];
        this.buttons = new ElevatorButton[Config.numFloors];
        for (int i = 0; i < Config.numFloors; i++) {
            anchors[i] = new <Rider>LinkedList();
            buttons[i] = new ElevatorButton(Integer.toString(i));
        }
    }

    private void opperateButtons() {
        for (int i = 0; i < Config.numFloors; i++) {
            if (anchors[i].isEmpty()) {
                buttons[i].setActive(false);
            } else {
                buttons[i].setActive(true);
            }
        }
    }

    public void eleToString(){
        System.out.println("***********************");
        System.out.println("Elevator ID   " + this.id);
        System.out.println("Current  Flr  " + this.currentFloor);
        System.out.println("Going    Up   " + hasRidersGoingUp());
        System.out.println("Going    Down " + hasRidersGoingDown());
        System.out.println("# of Riders   " + this.passengers);
    }
    public static void main(String[] args) {

        Config.numFloors = 10;
        Config.capOfElevators = 10;
        Elevator ele = new Elevator(Config.capOfElevators);
        Rider test1 = new Rider(0, Config.numFloors - 1);
        Rider test2 = new Rider(Config.numFloors - 1, 0);
        ele.setCurrentFloor(0);
        System.out.println(ele.hasRidersGoingUp());

        ele.embarkRider(test1);
        ele.setCurrentFloor(Config.numFloors - 2);
        System.out.println(ele.hasRidersGoingUp());

        ele.moveUp();
        System.out.println(ele.hasRidersGoingUp());
    }
}
