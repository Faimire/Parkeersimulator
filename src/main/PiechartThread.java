package main;

import view.SimulatorView;

public class PiechartThread implements Runnable{
	 public Thread thread;
	 public static int whatchart = 0;
	 public void run() {
		 while(Simulator.started == true) {
			 if(whatchart == 0) {
			 SimulatorView.updatePie();
			 }
			 
			 if(whatchart == 1) {
			 SimulatorView.updatePie2();	 
			 }
			 
			 if(whatchart == 2) {
		     SimulatorView.updatePie3();	 
			 }
			 
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
