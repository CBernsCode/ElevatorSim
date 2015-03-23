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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class is based off example from BB and also official Java tutorials and
 * docs
 *
 * Sliders make controlling input so much easier
 *
 * @author chris
 */
public class ConfigGUI extends JFrame {

    public ConfigGUI() {

        setTitle("Elevator Configuration");
        setSize(500, 500);
        setLayout(new GridLayout(8, 2));

        JLabel sliderLabel = new JLabel("Number of Elevators");
        JSlider elevatorSlider = new JSlider(1, 10, 1);
        elevatorSlider.setMajorTickSpacing(1);
        elevatorSlider.setPaintLabels(true);
        elevatorSlider.setPaintTicks(true);
        elevatorSlider.addChangeListener(new ElevatorAdjustmentListener());
        add(sliderLabel);
        add(elevatorSlider);

        JLabel floorsLabel = new JLabel("Number of Floors");
        JSlider floorsSlider = new JSlider(0, 101, 1);
        floorsSlider.setMajorTickSpacing(10);
        floorsSlider.setPaintLabels(true);
        floorsSlider.setPaintTicks(true);
        floorsSlider.addChangeListener(new FloorsAdjustmentListener());
        add(floorsLabel);
        add(floorsSlider);

        JLabel riderLabel = new JLabel("Number of People");
        JSlider riderSlider = new JSlider(0, 500, 5);
        riderSlider.setMajorTickSpacing(50);
        riderSlider.setPaintLabels(true);
        riderSlider.setPaintTicks(true);
        riderSlider.addChangeListener(new RiderAdjustmentListener());
        add(riderLabel);
        add(riderSlider);

        JButton button = new JButton("Commit Changes");
        button.addActionListener(new ActionListener() {

            //States are already saved just need to sucessfully exit
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        add(button);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        JFrame gonfigGUI = new ConfigGUI();
    }

    class RiderAdjustmentListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent ce) {
            JSlider source = (JSlider) ce.getSource();
            if (!source.getValueIsAdjusting()) {
                Config.numRiders = (int) source.getValue();
                System.out.println(Config.numRiders);
            }
        }
    }

    class FloorsAdjustmentListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent ce) {
            JSlider source = (JSlider) ce.getSource();
            if (!source.getValueIsAdjusting()) {
                Config.numFloors = (int) source.getValue();
                if (Config.numFloors < 1) {
                    Config.numFloors = 1;
                }
                System.out.println(Config.numFloors);
            }
        }
    }
}

class ElevatorAdjustmentListener implements ChangeListener {

    @Override
    public void stateChanged(ChangeEvent ce) {
        JSlider source = (JSlider) ce.getSource();
        if (!source.getValueIsAdjusting()) {
            Config.numElevators = (int) source.getValue();
            System.out.println(Config.numElevators);
        }
    }
}
