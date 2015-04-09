package elevatorsim;

import java.util.LinkedList;

/**
 *
 * @author chris
 */
public class Floor {

    private int id;

    //first index nuber of elevators, second up/down    
    private ElevatorButton upButton;
    private ElevatorButton downButton;
    private FloorQueue waitUp;
    private FloorQueue waitDown;
    private LinkedList <Rider> onFloor; 

    public Floor() {
        upButton = new ElevatorButton("Up");
        downButton = new ElevatorButton("Down");
        waitUp = new FloorQueue();
        waitDown = new FloorQueue();
        onFloor = new LinkedList<>();
    }

    public Floor(int number) {
        this.id = number;
        upButton = new ElevatorButton("Up");
        downButton = new ElevatorButton("Down");
        waitUp = new FloorQueue();
        waitDown = new FloorQueue();
        onFloor = new LinkedList<>();
    }

    public void joinLine(Rider rider) {
        if (rider.isGoingUp()) {
            waitUp.enqueue(rider);
        } else {
            waitDown.enqueue(rider);
        }
        setButton();
    }
    
    public void addToOnFloor(Rider rdr){
        onFloor.add(rdr);
    }

    private void setButton() {
        if (waitUp.isEmpty()) {
            upButton.setActive(false);
        } else {
            upButton.setActive(true);
        }
        if (waitDown.isEmpty()) {
            downButton.setActive(false);
        } else {
            downButton.setActive(true);
        }
    }

    public boolean hasRidersGoingUp() {
        boolean retBool = false;
        if (upButton.isActivated()) {
            retBool = true;
        }
        setButton();        
        return retBool;
    }

    public boolean hasRidersGoingDown() {
        boolean retBool = false;
        if (downButton.isActivated()) {
            retBool = true;
        }
        setButton();
        return retBool;
    }

    public Rider getFromDownQue() {
        Rider retRider = null;
        if (hasRidersGoingDown()) {
            retRider = waitDown.dequeue();
        }
        setButton();
        return retRider;
    }

    public Rider getFromUpQue() {
        Rider retRider = null;
        if (!waitUp.isEmpty()) {
            retRider = waitUp.dequeue();
        }
        setButton();
        return retRider;
    }
    
    public FloorQueue getUpQue(){
        return this.waitUp;
    }
    
    public FloorQueue getDownQue(){
        return this.waitDown;
    }

    public static void main(String[] args) {

        Rider rider1 = new Rider(1, 4);
        Rider rider2 = new Rider(8, 4);
        Floor floor1 = new Floor(1);

        floor1.joinLine(rider1);
        floor1.setButton();
        if (floor1.hasRidersGoingUp()) {
            System.out.print("Rider Going UP - PASS");
        }

        floor1.joinLine(rider2);
        floor1.setButton();
        if (floor1.hasRidersGoingDown()) {
            System.out.println("Rider Going DOWN - PASS");
        }
        floor1.getFromDownQue().riderToString();
        Rider test;
        test = floor1.getFromDownQue();
        

    }

}
