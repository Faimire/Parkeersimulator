package Parkeersimulator;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.getContentPane().setLayout(null);
		simulatorview = new SimulatorView(3, 6, 30);
		frame.getContentPane().add(simulatorview.getRootPane());
		frame.setSize(1300, 800);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static SimulatorView getSimulatorView() {
		return simulatorview;
	}

}
