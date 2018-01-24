package logic;

import main.Simulator;

public class Model {
	
	public void start() {
		Simulator.started = true;
	}
	
	public void pause() {
		Simulator.started = false;
	}
	
	public void faster() {
		if(Simulator.tickPause < 1000) {
		Simulator.tickPause -= 10;
		}
	}
	
	public void slower() {
		if(Simulator.tickPause > 10) {
		Simulator.tickPause += 10;
		}
	}
	
	

}
