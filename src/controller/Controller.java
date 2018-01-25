package controller;

import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logic.*;
import main.*;
import view.*;

import javax.swing.JButton;
import javax.swing.JMenuBar;

public class Controller implements ActionListener{
    public JButton button1, button2, button3, button4, button5, button6, button7,
    piebutton1, piebutton2;
    public SimulatorView view;
    public static Model model;

	public Controller(SimulatorView view) {
		//Initializing the model
		model = new Model();
		//making the buttons
    	iniButtons();
    	// added to SimulatorView
    	addButtons(view);
    	//settings in the JFrame
        setupButtons();
        //Menubar for style
        JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1980, 21);
		view.getContentPane().add(menuBar);
		
	}
	public void iniButtons() {
    	button1 = new JButton("START");
    	button1.addActionListener(this);
    	button2 = new JButton("PAUSE");
    	button2.addActionListener(this);
    	button3 = new JButton("START OVER");
    	button3.addActionListener(this);
    	button4 = new JButton("+ 1");
    	button4.addActionListener(this);
    	button5 = new JButton("- 1");
    	button5.addActionListener(this);
    	button6 = new JButton("FASTER");
    	button6.addActionListener(this);
    	button7 = new JButton("SLOWER");
    	button7.addActionListener(this);
    	piebutton1 = new JButton("previous");
    	piebutton1.addActionListener(this);
    	piebutton2 = new JButton("next");
    	piebutton2.addActionListener(this);
    	
	}
	public void addButtons(SimulatorView view) {
    	view.add(button1);
    	view.add(button2);
    	view.add(button3);
    	view.add(button4);
    	view.add(button5);
    	view.add(button6);
    	view.add(button7);
    	view.add(piebutton1);
    	view.add(piebutton2);
	}
	
	public void setupButtons() {
		piebutton2.setBounds(1500, 500, 150, 40);
		piebutton1.setBounds(1200, 500, 150, 40);
    	button7.setBounds(700, 700, 150, 40);
    	button6.setBounds(500, 700, 150, 40);
    	button5.setBounds(500, 900, 150, 40);
    	button4.setBounds(700, 900, 150, 40);
    	button3.setBounds(100, 700, 273, 65);
        button2.setBounds(100, 800, 273, 65);
        button1.setBounds(100, 900, 273, 65);
	}
	
	
// give the actions that the buttons are performed a method.
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			model.start();
		}
		
		if(e.getSource() == button2) {
		    model.pause();
		}
		if(e.getSource() == button6) {
			model.faster();
		}
		if(e.getSource() == button7) {
			model.slower();
		}
		
		if(e.getSource() == piebutton1) {
			model.previouschart();
		}
		
        if(e.getSource() == piebutton2) {
			model.nextchart();
		}
	}

}
