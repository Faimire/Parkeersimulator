package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import main.Simulator;

public class Start extends JFrame implements ActionListener {
	public static JTextArea floors, rows, places;
	public static JButton startButton = new JButton("accept");
	
	public Start() {
		Container contentPane= getContentPane();
		floors = new JTextArea("floors");
		rows = new JTextArea("rows");
		places = new JTextArea("places");
		startButton.addActionListener(this);
		contentPane.setLayout(null);
		contentPane.add(floors);
		contentPane.add(rows);
		contentPane.add(places);
		contentPane.add(startButton);
		floors.setBounds(200,400, 150, 25);
		rows.setBounds(400,400, 150, 25);
		places.setBounds(600,400, 150, 25);
		startButton.setBounds(800, 400 ,150,25);
		setVisible(true);
		pack();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			Simulator.initialize = true;
		}
	}
	
	

}
