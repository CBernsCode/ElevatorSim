/*
This project is the final lab for Computer Science II
This assignment should satisfy all of the requirements
Testing was done incrementally and all possible outcomes were
tested on the final project(sliders made control of input easier)
*/
package elevatorsim;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * April 27, 2015
 * @author Chris Berns
 */
public class MAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int choice = 0;
        boolean done = false;
        while (!done) {
            done = true;
            optionMenu();
            try{
             choice = scan.nextInt();   
            } catch(Exception e){
                System.out.println("Please input a integer choice");
                scan = new Scanner(System.in);
            }
            
            switch (choice) {

                case 1:
                    Config.typeOfSim = Config.simType.ASSENT;
                    done = true;
                    break;
                case 2:
                    Config.typeOfSim = Config.simType.DESSENT;
                    break;
                case 3:
                    Config.typeOfSim = Config.simType.NORMAL;
                    break;
                default:
                    done = false;
                    System.out.println("Invalid - try again");
                    break;
            }
        }
        //DataCollector data = new DataCollector();
        System.out.println("Please use the GUI to set simulation");
        ConfigGUI gui = new ConfigGUI();
//
    }

    public static void optionMenu() {
        System.out.println("What mode would you like?");
        System.out.println("1) for total ascent");
        System.out.println("2) for total descent");
        System.out.println("3) for random start and stop floors");
        
    }

    public static void printResults (DataCollector data) {
        try {
            data.writeOutputFile();
            System.out.println("Simulation Complete");
            System.out.println("The shortest time was : " + data.shortestTime());
            System.out.println("The  longest time was : " + data.longestTime());
            System.out.println("The   total  time was : " + data.getTotalTime());
            System.out.println("The  average time was : "
                    + data.getTotalTime() / Config.numRiders);
        } catch (IOException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void mainLoop() {

        System.out.println("Main Loop");
        DataCollector data = new DataCollector();
        Rider[] testRiders = Config.initRiders();
        Building building = new Building(testRiders);

        Clock clock = new Clock();
        Thread timer = new Thread(clock);
        timer.start();
        while (DataCollector.howManyFinished() != Config.numRiders) {
            building.mainCycle();
        }       
        printResults(data);
        timer.interrupt();
    }

}
