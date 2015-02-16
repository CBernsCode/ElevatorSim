
package elevatorsim;

/*This class models the button within the elevator
 *
 * @author chris
 */
public class ElevatorButton {
    
    /*array of floors needed, likely replaced with a list or queue but the
    array is a placeholder until the specification are given
    */
    //might enum statuses
   
    private String label;
    private boolean activated;
    
    public ElevatorButton(){
        
    }
    public ElevatorButton (String label)
    {
        this.label = label;
    }
    public void setActive (boolean isOn)
    {
        this.activated = isOn;
    }
    public boolean isActivated () 
    {
        return activated;
    }
    public void setSymbol(String a)
    {
        this.label = a;
    }
    public String getSymbol ()
    {
        return this.label;
    }
    
     public static void main(String[] args) {
     
         ElevatorButton test1 = new ElevatorButton();            
         test1.setActive(true);
         if (!test1.isActivated())
         {
             System.out.print("setActive(active) - FAIL\n");
         }
         test1.setActive(false);
         if (test1.isActivated())
         {
             System.out.print("setActive(deactive) - FAIL\n");
         }     
      
     }
            
    
}
