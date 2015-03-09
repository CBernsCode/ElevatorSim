/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorsim;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JFrame;

/**
 *
 * @author chris
 */
public class ConfigGUI {

    public ConfigGUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Elevator Configuration");
        frame.setSize(500, 500);
        
        
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public static void main (String[] args){
        
        ConfigGUI gui = new ConfigGUI();
    }
    
}
