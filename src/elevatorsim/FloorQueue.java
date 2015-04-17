package elevatorsim;

import java.util.LinkedList;
import java.util.Queue;

public class FloorQueue {

    Queue<Rider> floorQueue = new LinkedList<>();

    public FloorQueue() {

    }

    void enqueue(Rider rider) {
        floorQueue.add(rider);
    }

    Rider dequeue() {
        Rider returnRider;
        if (!isEmpty()) {
            returnRider = floorQueue.remove();
        } else {
            returnRider = null;
        }
        return returnRider;
    }

    int getSize() {
        return floorQueue.size();
    }

    boolean isEmpty() {
        return floorQueue.isEmpty();
    }

    void clear() {
        while (!floorQueue.isEmpty()) {
            dequeue();
        }
    }

    Rider peek() {
        Rider retRider = null;
        if (!isEmpty()) {
            retRider = floorQueue.peek();
        }
        return retRider;
    }

    public static void main(String[] args) {

        Rider testrider = new Rider(1, 8);
        Rider testrider1;
        System.out.println(testrider.getDestFloor());
        FloorQueue flQue = new FloorQueue();
        flQue.enqueue(testrider);
        testrider1 = flQue.dequeue();
        System.out.println(testrider1.getDestFloor());
        Rider[] riders = new Rider[10];
        Config.numFloors = 30;
        for (int i = 0; i < riders.length; i++) {
            riders[i] = new Rider(i, (int) (Math.random() * Config.numFloors + 1));
            flQue.enqueue(riders[i]);
        }
        for (int i = 0; i < riders.length; i++) {
            Rider holder;
            holder = flQue.dequeue();
            System.out.println(holder.getStartFlr());
            System.out.println(holder.getDestFloor());

        }

    }
}
