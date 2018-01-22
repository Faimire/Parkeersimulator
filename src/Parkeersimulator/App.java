package Parkeersimulator;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class App {
	
	public static SimulatorView simulatorview;

	public JFrame frame;
	public static Simulator start;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					App window = new App();
					window.frame.setVisible(true);
					start.run();
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
		start = new Simulator();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		simulatorview = new SimulatorView(3, 6, 30);
		frame.add(simulatorview.getContentPane());
		frame.getContentPane().setPreferredSize(new Dimension(1980, 1080));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static SimulatorView getSimulatorView() {
		return simulatorview;
	}

}
