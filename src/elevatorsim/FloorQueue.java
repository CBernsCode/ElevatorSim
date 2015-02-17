/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elevatorsim;

/**
 *
 * @author chris
 */
public class FloorQueue<T> implements RiderQ<T>{

    private int size;
    private Node first, last;
    
    private class Node {
        private T ele;
        private Node next;
    }
    
    @Override
    public RiderQ<T> enqueue(T ele) {
        
        return this;
       
    }

    @Override
    public T dequeue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void clear(){
        size = 0;
        first = null;
        last = null;
    }
    
    
}
