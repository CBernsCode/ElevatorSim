
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

    private int id;
    private int currentFloor;
    private int destFloor;
    private int capacity;
    private int passengers;
    private ElevatorButton[] buttons;
    private LinkedList<Rider>[] anchors;

    public Elevator() {
        passengers = 0;
        buildLinkAnchor();
    }

    public Elevator(int capacity) {
        passengers = 0;
        currentFloor = 0;
        buildLinkAnchor();
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

    //NOT WORKING YET
    //get a rider, get dest floor, place on propper list
    public void embarkPassengers(Rider rider) {
       anchors[rider.getDestFloor()-1].add(rider);
    }

    public Rider disembarkRider() {
        Rider rider;
        rider = anchors[this.currentFloor -1].removeLast();
        return rider;
    }

    public boolean isFull() {
        boolean retBool = false;
        if (this.capacity == this.passengers) {
            retBool = true;
        }
        return retBool;
    }

    public void nextStop() {
        while (!anchors[this.currentFloor + 1].isEmpty()) {
            destFloor++;
        }
    }

    //most likely refactored out
    private void buildLinkAnchor() {

        this.anchors = new LinkedList[Config.numFloors];
        for (int i = 0; i < anchors.length; i++) {
            anchors[i] = new LinkedList();
        }

    }
    
    public void loadRider(Rider rider, int wantedFloor){
        anchors[wantedFloor - 1].add(rider);
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void elevatorArrive() {

    }

    public static void main(String[] args) {

        Config.numFloors = 10;
        Elevator ele = new Elevator(Config.capOfElevators);
        ele.setCurrentFloor(1);
        Rider testRider = new Rider(1, 8);
        ele.setCurrentFloor(2);
        Rider test1Rider = new Rider(2, 9);
        ele.setCurrentFloor(8);
        Rider nextRider = new Rider(2,8);
        ele.loadRider(nextRider, 8);
        test1Rider = ele.disembarkRider();
        System.out.println(test1Rider.getDestFloor());
        System.out.println(test1Rider.getStartFlr());

    }

}
