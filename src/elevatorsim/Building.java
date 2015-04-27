
package elevatorsim;

/*The building holds all of the individual objects and the controller for the
 *Elevators  and places the riders on the correct floor
 *This class initializes all of componesnts of the building
 * @author chris
 */
public class Building {

    private Elevator[] elevators;
    private ElevatorController eleController;
    private Floor[] floors;

    public Building() {
        this.elevators = new Elevator[Config.numElevators];
        for (int i = 0; i < Config.numElevators; i++) {
            elevators[i] = new Elevator();
        }
        this.floors = new Floor[Config.numFloors];
        for (int i = 0; i < Config.numFloors; i++) {
            floors[i] = new Floor();
        }
        this.eleController = new ElevatorController();
    }

    //this constr takes the array of people and places them in the building
    public Building(Rider[] riders) {
        this.elevators = new Elevator[Config.numElevators];
        for (int i = 0; i < Config.numElevators; i++) {
            elevators[i] = new Elevator();
        }
        this.floors = new Floor[Config.numFloors];
        for (int i = 0; i < Config.numFloors; i++) {
            floors[i] = new Floor();
        }
        this.eleController = new ElevatorController();
        for (Rider rdrs : riders) {
            //rdrs.setStartFlr(Clock.getTime());
            floors[rdrs.getStartFlr()].joinLine(rdrs);
        }
    }

    public Floor[] getFloors() {
        return this.floors;
    }

    public Elevator[] getElevators() {
        return this.elevators;
    }
    
    public ElevatorController getController(){
        return this.eleController;
    }
}
