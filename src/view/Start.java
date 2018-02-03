package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import main.Simulator;

public class Start extends JFrame implements ActionListener {
	public static JTextArea floors, rows, places, Floorsfor;
	public static JButton startButton = new JButton("accept");
	
	public Start() {
		Container contentPane= getContentPane();
		floors = new JTextArea("floors");
		rows = new JTextArea("rows");
		places = new JTextArea("places");
		Floorsfor = new JTextArea("amount of floors for subscriptions");
		startButton.addActionListener(this);
		contentPane.setLayout(null);
		contentPane.add(floors);
		contentPane.add(rows);
		contentPane.add(places);
		contentPane.add(startButton);
		contentPane.add(Floorsfor);
		Floorsfor.setBounds(200,400,200,25);
		floors.setBounds(500,400, 150, 25);
		rows.setBounds(700,400, 150, 25);
		places.setBounds(900,400, 150, 25);
		startButton.setBounds(1100, 400 ,150,25);
		setVisible(true);
		pack();
	}
	
	/**
	 * @param e Uses an event
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			Simulator.initialize = true;
		}
	}
	
	

}
