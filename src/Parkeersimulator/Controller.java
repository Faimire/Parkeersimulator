package Parkeersimulator;

import java.awt.Container;

import javax.swing.JButton;

public class Controller {
    public SimulatorView simulatorView;
    public JButton button1, button2, button3, button4;


	public Controller(SimulatorView view) {
    	button1 = new JButton("START");
    	button2 = new JButton("PAUSE");
    	button3 = new JButton("START OVER");
    	button4 = new JButton("+ 1");
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
		return simulatorView.contentPane;
	}

}
