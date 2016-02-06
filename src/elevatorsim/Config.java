package elevatorsim;

import java.util.Random;

/**
 *
 * @author Chris Berns
 */
public class Config {

    public  enum simType {

        NORMAL, ASSENT, DESCENT
    }
    public static String title = "Elevator Sim";
    public static int numFloors = 2;
    public static int numElevators = 1;
    public static int numRiders = 1;
    public static int capOfElevators = 10;
    public static simType typeOfSim = simType.NORMAL;

    public static void setNumFloors(int a) {
        numFloors = a;
    }

    public static void setNumElevators(int a) {
        numElevators = a;
    }

    public static void setNumRiders(int a) {
        numRiders = a;
    }

    public static Rider[] generateRiders() {
        Rider[] riders = new Rider[numRiders];
        for (int i = 0; i < numRiders; i++) {
            riders[i] = new Rider();
        }
        return riders;
    }

    public static Rider[] generateRiders(int startFloor) {
        Rider[] riders = new Rider[numRiders];
        for (int i = 0; i < numRiders; i++) {
            riders[i] = new Rider(startFloor);
        }
        return riders;
    }

    public static Rider[] generateRiders(int startFloor, int stopFloor) {
        Rider[] riders = new Rider[numRiders];
        for (int i = 0; i < numRiders; i++) {
            riders[i] = new Rider(startFloor, stopFloor);
        }
        return riders;
    }

    public static Rider[] initRiders() {
        Random rand = new Random(System.currentTimeMillis());
        Rider[] riders = new Rider[numRiders];

        //add different types of generating based off type
        if (Config.typeOfSim == simType.ASSENT) {            
            for (int i = 0; i < riders.length; i++) {
                riders[i] = new Rider(0, rand.nextInt(Config.numFloors - 1) + 1);
            }
        } else if (Config.typeOfSim == simType.DESCENT) {           
            for (int i = 0; i < riders.length; i++) {
                riders[i] = new Rider(rand.nextInt(Config.numFloors - 1) + 1, 0);
            }            
        } else {   
            for (int i = 0; i < riders.length; i++) {
                riders[i] = new Rider(rand.nextInt(Config.numFloors - 1) + 1, rand.nextInt(Config.numFloors - 1) + 1);
            }
        }       
        return riders;
    }

   
    public static void main(String[] argc) {
        Config.numElevators = 10;
        if (Config.numElevators != 10) {
            System.out.print("Number of Elevators not set");
        }
        Config.setNumElevators(20);
        if (Config.numElevators != 20) {
            System.out.print("Number of Elevators not set");
        }
        Config.numFloors = 10;
        if (Config.numFloors != 10) {
            System.out.print("Number of Elevators not set");
        }
        Config.setNumFloors(20);
        if (Config.numFloors != 20) {
            System.out.print("Number of Floors not set");
        }
        Config.numRiders = 10;
        if (Config.numRiders != 10) {
            System.out.print("Number of Elevators not set");
        }
        Config.setNumRiders(20);
        if (Config.numRiders != 20) {
            System.out.print("Number of Floors not set");
        }
        Rider[] riders = Config.generateRiders();
    }

}
