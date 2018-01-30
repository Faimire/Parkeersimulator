package logic;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.PiechartThread;
import main.Simulator;

public class Model {
	
	public static boolean addHour;
	public static boolean addMinute;
	public static int TempTickPause;

	public void start() {
		Simulator.started = true;
	}

	public void pause() {
		Simulator.started = false;
	}

	public void faster() {
		if (Simulator.tickPause > 10) {
			Simulator.tickPause -= 10;
		}

		if (Simulator.tickPause == 10) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "can't go faster.");
		}
		
	}

	public void slower() {
		Simulator.tickPause += 10;

	}

	public void startover() {

	}

	public void nextchart() {

		if (PiechartThread.whatchart < 2) {
			PiechartThread.whatchart += 1;
		}

		else {
			PiechartThread.whatchart = 0;
		}

	}

	public void previouschart() {

		if (PiechartThread.whatchart > 0) {
			PiechartThread.whatchart -= 1;
		}

		else {
			PiechartThread.whatchart = 2;
		}
	}
	
	public void addhour() {
		Simulator.started = false;
		TempTickPause = Simulator.tickPause;
		Simulator.tickPause = 1;
		addHour = true;
	}
	
	public void addMinute() {
		Simulator.started = false;
		TempTickPause = Simulator.tickPause;
		Simulator.tickPause = 1;
		addMinute = true;
	}

}
