/**
 * @author Jonathan, Nick, Rick and Mark
 * @version 1.0
 */
package runner;

import main.*;

public class Runner {

	public static void main(String[] args) {
		Simulator simulator = new Simulator();
		simulator.start();
		PiechartThread piechart = new PiechartThread();
		piechart.start();
	}

}
