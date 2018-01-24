package view;

import javax.swing.JFrame;

public class piechartstart {

	public static void main(String[] args) {
		Piechart chart = new Piechart("m");
		JFrame frame = new JFrame();
		frame.add(chart.getContentPane());
		frame.pack();
		frame.setVisible(true);

	}

}
