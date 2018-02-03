package main;

import view.SimulatorView;

public class PiechartThread implements Runnable {
	public Thread thread;
	public static int whatchart = 0;

	/**
	 * Starts the simulator with charts
	 */
	public void run() {
		while (Simulator.started == true) {
			if (whatchart == 0) {
				SimulatorView.updatePie();
			}

			if (whatchart == 1) {
				SimulatorView.updatePie2();
			}

			if (whatchart == 2) {
				SimulatorView.updateLine();
			}
			
			if (whatchart == 3) {
				SimulatorView.updateLine2();
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (Simulator.started == false) {
				if (whatchart == 0) {
					SimulatorView.updatePie();
				}

				if (whatchart == 1) {
					SimulatorView.updatePie2();
				}

				if (whatchart == 2) {
					SimulatorView.updateLine();
				}
				
				if (whatchart == 3) {
					SimulatorView.updateLine2();
				}

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Starts the thread
	 */
	public void start() {
		if (thread == null) {
			thread = new Thread(this, "piechart");
			thread.start();
		}
	}

}
