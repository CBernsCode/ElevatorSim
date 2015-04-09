package elevatorsim;

public class Rider {

    private int startFloor = 0;
    private int destFloor;
    private int startTime = 0;
    private int stopTime = 0;
    private final int id;
    private static int idGen = 0;
    private static int ridersInQueue;

    public Rider() {
        this.id = idGen++;
    }

    public Rider(int startFloor) {
        this.startFloor = startFloor;
        this.id = idGen++;
    }

    public Rider(int startFloor, int destFloor) {
        this.startFloor = startFloor;
        this.destFloor = destFloor;
        this.id = idGen++;
    }

    public void setStartFlr(int a) {
        this.startFloor = a;
    }

    public int getStartFlr() {
        return this.startFloor;
    }

    public void setDestFlr(int a) {
        this.destFloor = a;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void setStartTime(int a) {
        this.startTime = a;
    }

    public int getStopTime() {
        return this.stopTime;
    }

    public void setStopTime(int a) {
        this.stopTime = a;
    }

    public int getDestFloor() {
        return this.destFloor;
    }

    //I wanted to add ability to track total waiting in que
    //MIGHT TOSS
    public void callElevator() {
        ridersInQueue++;
    }

    public void arrive() {
        ridersInQueue--;
    }

    public boolean isGoingUp() {
        boolean retVal = true;
        if (this.destFloor < this.startFloor) {
            retVal = false;
        } else if (this.startFloor == this.destFloor) {
            //to-do same floor handler
        }
        return retVal;
    }

    //can use to update the gui
    public static int getRiderInQue() {
        return ridersInQueue;
    }

    public int getTotalTime() {
        return this.stopTime - this.startTime;
    }
    
    public void riderToString(){
        System.out.println("**********************************");
        System.out.println("Rider Id    is " + this.id);
        System.out.println("Start Floor is " + this.startFloor);
        System.out.println("Dest  Floor is " + this.destFloor);
    }

    public static void main(String[] args) {

        Rider a1 = new Rider();
        Rider a2 = new Rider();
        a1.callElevator();
        a2.callElevator();
        if (Rider.getRiderInQue() != 2) {
            System.out.print("Riders added to Que - FAIL\n");
        }
        a1.setStartFlr(0);
        a1.setDestFlr(2);
        if (!a1.isGoingUp()) {
            System.out.print("isGoingUp(true) - FAIL");
        }
        a1.setStartFlr(2);
        a1.setDestFlr(1);
        if (a1.isGoingUp()) {
            System.out.print("isGoingUp(false) - FAIL");
        }
        a1.arrive();
        a2.arrive();
        if (Rider.getRiderInQue() != 0) {
            System.out.print("Riders remove from Que - FAIL\n");
        }
    }
}
