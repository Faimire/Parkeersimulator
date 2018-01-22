package Parkeersimulator;

import java.awt.Dimension;
import java.awt.Toolkit;

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
		frame.pack();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static SimulatorView getSimulatorView() {
		return simulatorview;
	}

}
