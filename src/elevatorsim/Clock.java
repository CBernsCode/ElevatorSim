package elevatorsim;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The clock class ticks to provide a data set The clock is run on a separate
 * thread
 *
 * @author Chris Berns
 */
public class Clock extends Thread {

    static int time;
    static boolean isTicking = false;

    public Clock() {
        time = 1;
    }

    public static int getTime() {
        return time;
    }

    public static void tick() {
        time++;
    }

    public void startClock() {
        isTicking = true;
        while (isTicking) {
            tick();
        }
    }

    public static void stopClock() {
        isTicking = false;
    }

    @Override
    public void run() {
        isTicking = true;

        while (isTicking) {
            try {
                if (isTicking) {
                    Thread.sleep(5);
                    tick();
                }
            } catch (InterruptedException ex) {
                isTicking = false;
            }
            //System.out.println(Clock.getTime());
        }
    }

    public static void main(String[] argc) {
        System.out.println("The time is: " + time);
        Clock.tick();
        System.out.println("The time is: " + time);
        for (int i = 0; i < 2999; i++) {
            Clock.tick();
        }
        System.out.println("The time is: " + time);
        Clock clock = new Clock();
        Thread timer = new Thread(clock);
        timer.start();
        for (int i = 0; i < 10000; i++) {

        }

        try {
            Clock.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
        }
        timer.interrupt();
    }
}
