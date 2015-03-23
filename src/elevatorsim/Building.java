/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elevatorsim;

/*The building holds all of the individual objects and the controller for the
 *Elevators  and places the riders on the correct floor
 * @author chris
 */
public class Building {
    
    private Elevator[] elevators;
    private ElevatorController eleController;
    private Floor[] floors;
    
    
    public Building(){
        this.elevators = new Elevator[Config.numElevators];
        this.eleController = new ElevatorController();
        this.floors = new Floor[Config.numFloors];        
    }
    
    //this constr takes the array of people and places them in the building
    public Building(Rider[] riders){
        this.elevators = new Elevator[Config.numElevators];
        this.eleController = new ElevatorController();
        this.floors = new Floor[Config.numFloors];
        for(Rider rdrs : riders){
            floors[rdrs.getStartFlr()].joinLine(rdrs);
        }
        
    }
    
    
    
    
    
    
}
