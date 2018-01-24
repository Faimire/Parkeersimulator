package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logic.Model;
import view.SimulatorView;

import javax.swing.JButton;

public class Controller implements ActionListener{
    public JButton button1, button2, button3, button4;
    public SimulatorView view;
    public Model model;

	public Controller(SimulatorView view) {
		model = new Model();
    	button1 = new JButton("START");
    	button1.addActionListener(this);
    	button2 = new JButton("PAUSE");
    	button2.addActionListener(this);
    	button3 = new JButton("START OVER");
    	button3.addActionListener(this);
    	button4 = new JButton("+ 1");
    	button4.addActionListener(this);
    	view.add(button1);
    	view.add(button2);
    	view.add(button3);
    	view.add(button4);
    	button4.setBounds(500, 900, 150, 40);
    	button3.setBounds(100, 700, 273, 65);
        button2.setBounds(100, 800, 273, 65);
        button1.setBounds(100, 900, 273, 65);
		
	}
	
	public Container getContentPaneSIM() {
		return view.contentPane;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			model.start();
		}
		
		if(e.getSource() == button2) {
		    model.pause();
		}
	}

}
