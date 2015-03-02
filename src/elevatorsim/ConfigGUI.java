/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorsim;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.NumberFormat;

/**
 *
 * @author chris
 */
public class ConfigGUI extends JFrame implements ActionListener {
    
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    NumberFormat amountFormat = NumberFormat.getNumberInstance();
    JFormattedTextField numElevators = new JFormattedTextField(amountFormat);

    public ConfigGUI() throws HeadlessException {
        
        frame.setSize(250, 250);
       
        
    }
   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void init(){
        panel.add(numElevators);
        frame.add(panel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public static void main(String[] args){
        
        ConfigGUI gui = new ConfigGUI();
        gui.init();
        
        
    }

}
