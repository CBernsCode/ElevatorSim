/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elevatorsim;

/*The building holds all of the individual objects and the controller for the
 *Elevators *
 * @author chris
 */
public class Buillding {
    
    private Elevator[] elevators;
    private ElevatorController eleController;
    private Floor[] floors;
    
    
    public Buillding(){
        this.elevators = new Elevator[Config.numElevators];
        this.eleController = new ElevatorController();
        this.floors = new Floor[Config.numFloors];        
    }
    
    public Buillding(Rider[] riders){
        this.elevators = new Elevator[Config.numElevators];
        this.eleController = new ElevatorController();
        this.floors = new Floor[Config.numFloors];
        for(Rider rdrs : riders){
            //to-do place riders on floors
        }
        
    }
    
    
    
    
    
    
}
