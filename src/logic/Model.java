/**
 * @author Jonathan, Nick, Rick and Mark
 * @version 1.0
 */
package logic;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.PiechartThread;
import main.Simulator;

public class Model {
	
	public static boolean addHour;
	public static boolean addMinute;
	public static int TempTickPause;

	/**
	 * Starts the simulator
	 */
	public void start() {
		Simulator.started = true;
	}

	/**
	 * Pauses the simulator
	 */
	public void pause() {
		Simulator.started = false;
	}

	/**
	 * Speeds up the simulator
	 */
	public void faster() {
		if (Simulator.tickPause > 10) {
			Simulator.tickPause -= 10;
		}

		if (Simulator.tickPause == 10) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "can't go faster.");
		}
		
	}

	/**
	 * Slows down the simulator
	 */
	public void slower() {
		Simulator.tickPause += 10;

	}
	
	/**
	 * Resets the simulator
	 */
	public void startover() {

	}

	/**
	 * Continues to the next chart
	 */
	public void nextchart() {

		if (PiechartThread.whatchart < 3) {
			PiechartThread.whatchart += 1;
		}

		else {
			PiechartThread.whatchart = 0;
		}

	}
	
	/**
	 * Go back to the previous chart
	 */
	public void previouschart() {

		if (PiechartThread.whatchart > 0) {
			PiechartThread.whatchart -= 1;
		}

		else {
			PiechartThread.whatchart = 3;
		}
	}
	
	/**
	 * Adds one hour
	 */
	public void addhour() {
		Simulator.started = false;
		TempTickPause = Simulator.tickPause;
		Simulator.tickPause = 1;
		addHour = true;
	}
	
	/**
	 * Adds one minute
	 */
	public void addMinute() {
		Simulator.started = false;
		TempTickPause = Simulator.tickPause;
		Simulator.tickPause = 1;
		addMinute = true;
	}

}
