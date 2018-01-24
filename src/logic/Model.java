package logic;

import main.Simulator;

public class Model {
	
	public void start() {
		Simulator.started = true;
	}
	
	public void pause() {
		Simulator.started = false;
	}

}
