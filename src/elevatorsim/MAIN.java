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
        // TODO code application logic here
        Clock clock = new Clock();
        
        //need to set up signal from GUI before Builing is run
        ConfigGUI gui = new ConfigGUI();
        Building building = new Building(Config.initRiders());
        
    }
    
}
