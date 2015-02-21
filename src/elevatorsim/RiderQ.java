/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elevatorsim;

/**
 *
 * @author chris
 * @param <T>
 */
public interface RiderQ<T> {
    RiderQ<T> enqueue(T ele);
    T dequeue();
}
