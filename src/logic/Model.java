package logic;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.Simulator;

public class Model {
	
	public void start() {
		Simulator.started = true;
	}
	
	public void pause() {
		Simulator.started = false;
	}
	
	public void faster() {
		if(Simulator.tickPause > 10) {
		Simulator.tickPause -= 10;
		}
		
		if(Simulator.tickPause == 10) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame,
				    "can't go faster.");
		}
	}
	
	public void slower() {
		Simulator.tickPause += 10;
		
	}
	
	public void startover() {
		
	}
	
	

}
