package controller;

import java.awt.Color;
import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logic.*;
import main.*;
import view.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Controller implements ActionListener {
	public JButton button1, button2, button3, button4, button5, button6, button7, piebutton1, piebutton2;
	public JPanel GUIpanel;
	public SimulatorView view;
	public static Model model;

	public Controller(SimulatorView view) {
		// Initializing the model
		model = new Model();
		// making the buttons
		iniButtons();
		// added to SimulatorView
		addButtons(view);
		// settings in the JFrame
		setupButtons();
		// Menubar for style
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1980, 21);
		view.getContentPane().add(menuBar);

	}

	public void iniButtons() {
		// Starts the simulator
		button1 = new JButton("START");
		button1.addActionListener(this);
		// sets the simulator on pause
		button2 = new JButton("PAUSE");
		button2.addActionListener(this);
		// Resets the simulator
		button3 = new JButton("START OVER");
		button3.addActionListener(this);
		// Increases the simulator time by one hour
		button4 = new JButton("+ 1 hour");
		button4.addActionListener(this);
		// Increases the simulator time by one minute
		button5 = new JButton("+ 1 minute");
		button5.addActionListener(this);
		// Slows down the simulation
		button6 = new JButton("SLOWER");
		button6.addActionListener(this);
		// Speeds us the simulation
		button7 = new JButton("FASTER");
		button7.addActionListener(this);
		// Go back one chart
		piebutton1 = new JButton("previous");
		piebutton1.addActionListener(this);
		// Move forward one chart
		piebutton2 = new JButton("next");
		piebutton2.addActionListener(this);
		GUIpanel = new JPanel();

	}
	// Adds the GUI buttons to the simulator
	public void addButtons(SimulatorView view) {
		GUIpanel.add(button1);
		GUIpanel.add(button2);
		GUIpanel.add(button3);
		GUIpanel.add(button4);
		GUIpanel.add(button5);
		GUIpanel.add(button6);
		GUIpanel.add(button7);
		view.add(piebutton1);
		view.add(piebutton2);
		view.add(GUIpanel);
	}

	// Initializes the size and position of the buttons
	public void setupButtons() {
        
		GUIpanel.setLayout(null);
		GUIpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		GUIpanel.setBounds(100,700, 900,350);
		piebutton2.setBounds(1500, 500, 150, 40);
		piebutton1.setBounds(1200, 500, 150, 40);
		button7.setBounds(700, 50, 150, 40);
		button6.setBounds(500, 50, 150, 40);
		button5.setBounds(500, 150, 150, 40);
		button4.setBounds(700, 150, 150, 40);
		button3.setBounds(50, 50, 273, 65);
		button2.setBounds(50, 150, 273, 65);
		button1.setBounds(50, 250, 273, 65);
	}

	// give the actions that the buttons are performed a method.
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			model.start();
		}

		if (e.getSource() == button2) {
			model.pause();
		}
		if (e.getSource() == button6) {
			model.slower();
		}
		if (e.getSource() == button7) {
			model.faster();
		}

		if (e.getSource() == piebutton1) {
			model.previouschart();
		}

		if (e.getSource() == piebutton2) {
			model.nextchart();
		}
		
		if (e.getSource() == button4) {
			model.addhour();
		}
		
		if (e.getSource() == button5) {
			model.addMinute();
		}
	}

}
