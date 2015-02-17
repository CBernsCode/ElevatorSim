
package elevatorsim;

/**
 *
 * @author Chris Berns
 */
public class Elevator {

    private int id;
    private int capacity;
    private int passengers;
    static int idGen = 0;
    private ElevatorButton[] buttons;

    public Elevator() {
        initButtons();
    }

    public Elevator(int capacity) {
        initButtons();
        this.capacity = capacity;
    }

    public boolean isFull() {
        boolean retBool = false;
        if (this.capacity == this.passengers) {
            retBool = true;
        }
        return retBool;
    }

    private void initButtons() {
        buttons = new ElevatorButton[Config.numFloors];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new ElevatorButton(Integer.toString(i));
        }
    }

}
