/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorsim;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author chris
 */
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
    
    void clear(){
        while(!floorQueue.isEmpty()){
           dequeue();
        }
    }
    
    Rider peek(){
        Rider retRider = null;
        if(!isEmpty()){
            retRider = floorQueue.peek();
        }
        return retRider;
    }

}
