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

import elevatorsim.Config.simType;

/**
 * April 27, 2015
 * @author Chris Berns
 */
public class MAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Config.typeOfSim = querySimType();
        ConfigGUI gui = new ConfigGUI();
    }

    private static simType querySimType() {
    	try {
    		return lookupSimType(getSimMode());
    	} catch (UnknownSimTypeException e) {
    		System.out.println("Invalid - try again");
    		return querySimType();
    	}
    }

    public static simType lookupSimType(int choice) {
    	switch (choice) {

    	case 1:
    		return Config.simType.ASSENT;
    	case 2:
    		return Config.simType.DESCENT;
    	case 3:
    		return Config.simType.NORMAL;
    	}
    	throw new UnknownSimTypeException();
    }

	private static int getSimMode() {
		Scanner scan = new Scanner(System.in); 
		optionMenu();
        int choice = 0;
        try{
         choice = Integer.parseInt(scan.nextLine());
        } catch(Exception e){
            System.out.println("Please input a integer choice");
        }
		return choice;
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
