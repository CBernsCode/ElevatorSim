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
public class MAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ConfigGUI gui = new ConfigGUI();

    }

    public static void mainLoop() {

        System.out.println("Main Loop");
        Rider[] testRiders = Config.initRiders();
        Building building = new Building(testRiders);
        
        System.out.println(building.getFloors()[0].hasRidersGoingUp());
        
        while(DataCollector.howManyFinished() != Config.numRiders){
            
            building.getController().moveElevators(building.getElevators(),
                    building.getFloors());
            for(Elevator ele : building.getElevators()){
                ele.eleToString();
            }
            System.out.println(DataCollector.howManyFinished());
        }
        
    }

}
