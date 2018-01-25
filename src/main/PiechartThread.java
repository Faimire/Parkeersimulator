package main;

import view.SimulatorView;

public class PiechartThread implements Runnable{
	 public Thread thread;
	 public void run() {
		 while(Simulator.started == true) {
			 SimulatorView.updatePie();
			 try {
				 Thread.sleep(1);
			 }
			 catch(InterruptedException e){
				 e.printStackTrace();
			 }
			 while(Simulator.started == false) {
				 System.out.println("piechart stopped");
			 }
		 }
	 }
	 
	 public void start() {
		 if(thread == null) {
			 thread = new Thread(this, "piechart");
			 thread.start();
		 }
	 }

}
