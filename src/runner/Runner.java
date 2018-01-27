package runner;

import main.*;

public class Runner {

	public static void main(String[] args) {
		Simulator simulator = new Simulator();
        simulator.start();
        PiechartThread piechart = new PiechartThread();
        piechart.start();
        Music music = new Music();
        music.run();
	}

}
