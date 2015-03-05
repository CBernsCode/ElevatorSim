package elevatorsim;

import java.util.LinkedList;

/*This is the elevator for the simulator, is passed Riders from
 Floor queues depending on capcity and direction. The riders are
 stored in linked list anchored to an array so that the current floor
 will point to the anchor with the right linked list.
 *
 * @author Chris Berns
 */
public class Elevator {

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
        initAnchors();
        capacity = Config.capOfElevators;
    }

    public Elevator(int capacity) {
        id = idGen++;
        passengers = 0;
        currentFloor = 0;
        initAnchors();
        this.capacity = capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setNumPassengers(int passengers) {
        this.passengers = passengers;
    }

    //get a rider, get dest floor, place on propper list
    public void embarkRider(Rider rider) {
        try {
            anchors[rider.getDestFloor() - 1].add(rider);
        } catch (Exception e) {
            System.out.println("Error in embarkRider");
        }
    }

    public Rider disembarkRider() {
        Rider rider = null;
        try {
            rider = anchors[this.currentFloor - 1].removeLast();

        } catch (Exception e) {
            System.out.println("Error in disembark");
        }
        return rider;
    }

    public boolean isFull() {
        boolean retBool = false;
        if (this.capacity == this.passengers) {
            retBool = true;
        }
        return retBool;
    }

    //most likely refactored out
    private void initAnchors() {

        this.anchors = new LinkedList[Config.numFloors];
        for (int i = 0; i < anchors.length; i++) {
            anchors[i] = new LinkedList();
        }
    }

    //testing function
    private void loadRider(Rider rider, int wantedFloor) {
        anchors[wantedFloor - 1].add(rider);
    }

    //testing function, will be handled by controller
    private void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public static void main(String[] args) {

        Config.numFloors = 10;
        Config.capOfElevators = 10;
        Elevator ele = new Elevator(Config.capOfElevators);
        ele.setCurrentFloor(0);
        Rider testRider = new Rider(0, 8);
        ele.setCurrentFloor(2);
        Rider test1Rider;
        ele.setCurrentFloor(8);
        Rider nextRider = new Rider(2, 8);
        //ele.loadRider(nextRider, 8);
        ele.embarkRider(nextRider);
        ele.embarkRider(testRider);
        test1Rider = ele.disembarkRider();
        System.out.println(test1Rider.getDestFloor());
        System.out.println(test1Rider.getStartFlr());
        System.out.println(ele.disembarkRider().getStartFlr());
        //make sure it throws error here
        ele.disembarkRider();

    }

}
