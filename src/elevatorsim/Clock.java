/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorsim;

/**
 *
 * @author Chris Berns
 */
public class Clock {

    static int time = 0;

    public static int getTime() {
        return time;
    }

    public static void tick() {
        time++;
    }

    public static void main(String[] argc) {
        System.out.println("The time is: " + time);
        Clock.tick();
        System.out.println("The time is: " + time);
        for (int i = 0; i < 2999; i++) {
            Clock.tick();
        }
        System.out.println("The time is: " + time);

    }
}
