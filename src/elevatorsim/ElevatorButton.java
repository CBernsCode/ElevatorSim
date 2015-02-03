/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elevatorsim;

import sun.applet.Main;

/*This class models the button within the elevator
 *
 * @author chris
 */
public class ElevatorButton {
    
    /*array of floors needed, likely replaced with a list or queue but the
    array is a placeholder until the specification are given
    */
    //might enum statuses
   
    private char symbol;
    private boolean activated;
    
    public ElevatorButton(){
        
    }
    public ElevatorButton (char charInput)
    {
        this.symbol = charInput;
    }
    public void setActive (boolean isOn)
    {
        this.activated = isOn;
    }
    public boolean isActivated () 
    {
        return activated;
    }
    public void setSymbol(char a)
    {
        this.symbol = a;
    }
    public char getSymbol ()
    {
        return this.symbol;
    }
    
     public static void main(String[] args) {
     
         ElevatorButton test1 = new ElevatorButton();    
         test1.setSymbol('2');
         if(test1.getSymbol() != '2')
         {
             System.out.print("setSymbol - FAIL\n");
         }
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
