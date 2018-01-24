package Parkeersimulator;

import java.awt.Dimension;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JProgressBar;

public class Simulator implements Runnable{

	private static final String AD_HOC = "1";
	private static final String PASS = "2";
	
	
	private CarQueue entranceCarQueue;
    private CarQueue entrancePassQueue;
    private CarQueue paymentCarQueue;
    private CarQueue exitCarQueue;
    public SimulatorView simulatorView;
    private JProgressBar progressBar1;
    private JMenuBar menuBar;

    private int day = 0;
    private int hour = 0;
    private int minute = 0;
    private int f = 0;

    private int tickPause = 100;

    int weekDayArrivals= 100; // average number of arriving cars per hour
    int weekendArrivals = 200; // average number of arriving cars per hour
    int weekDayPassArrivals= 50; // average number of arriving cars per hour
    int weekendPassArrivals = 5; // average number of arriving cars per hour

    int enterSpeed = 3; // number of cars that can enter per minute
    int paymentSpeed = 7; // number of cars that can pay per minute
    int exitSpeed = 5; // number of cars that can leave per minute
    
    public static boolean started = true;// says if the application is started or not

    public Simulator() {
        entranceCarQueue = new CarQueue();
        entrancePassQueue = new CarQueue();
        paymentCarQueue = new CarQueue();
        exitCarQueue = new CarQueue();
        simulatorView = new SimulatorView(3, 6, 30);
        Controller controller = new Controller(simulatorView);
        simulatorView.pack();
        settingSimulatorView();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1980, 21);
		simulatorView.getContentPane().add(menuBar);
		
		JProgressBar progressBar1 = new JProgressBar();
		progressBar1.setMaximum(168);
		progressBar1.setMinimum(0);
		progressBar1.setBounds(10, 32, 146, 14);
		simulatorView.getContentPane().add(progressBar1);
		
		
    }
    public void settingSimulatorView() {
        simulatorView.setSize(1980,1080);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        simulatorView.setLocation(dim.width/2-simulatorView.getSize().width/2, dim.height/2-simulatorView.getSize().height/2);
		simulatorView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

	public void run() {
		
		while (started == true) {
			tick();
			System.out.println("Days " + day + " Hours " + hour + " Minutes " + minute);
			while(started == false) {
				System.out.println("stopped");
			}
			
				
			}
			

		}
		
		    	
		    
	

    private void tick() {
    	
    	advanceTime();
    	handleExit();
    	updateViews();
    	// Pause.
        try {
            Thread.sleep(tickPause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	handleEntrance();
    	
    	
    }

    private void advanceTime(){
        // Advance the time by one minute.
        minute++;
        while (minute > 59) {
            minute -= 60;
            hour++;
        }
        while (hour > 23) {
            hour -= 24;
            day++;
        }
        while (day > 6) {
            day -= 7;
        }

    }

    private void handleEntrance(){
    	carsArriving();
    	carsEntering(entrancePassQueue);
    	carsEntering(entranceCarQueue);  	
    }
    
    private void handleExit(){
        carsReadyToLeave();
        carsPaying();
        carsLeaving();
    }
    
    private void updateViews(){
    	simulatorView.tick();
        // Update the car park view.
        simulatorView.updateView();	
    }
    
    private void carsArriving(){
    	int numberOfCars=getNumberOfCars(weekDayArrivals, weekendArrivals);
        addArrivingCars(numberOfCars, AD_HOC);    	
    	numberOfCars=getNumberOfCars(weekDayPassArrivals, weekendPassArrivals);
        addArrivingCars(numberOfCars, PASS);    	
    }
    
    private void countPass(Car car) {
    	if(car.getHasToPay() == false) {
    		f++;
    	}
    	
    	if(hour == 12 && minute == 0) {
    		System.out.println(f);
    	}
    }

	private void carsEntering(CarQueue queue) {
		int i = 0;
		Random random = new Random();
		// Remove car from the front of the queue and assign to a parking space.
		while (queue.carsInQueue() > 0 && simulatorView.getNumberOfOpenSpots() > 0 && i < enterSpeed) {
			Car car = queue.removeCar();
			int random1 = random.nextInt(4);
			int random2 = random.nextInt(2);
			if (random1 == 1 || random1 == 2 || random1 == 3 || random2 == 1) {
				countPass(car);
				Location freeLocation = simulatorView.getFirstFreeLocation(car);
				simulatorView.setCarAt(freeLocation, car);
				i++;
			}

			if (random1 == 0 && random2 == 0) {
				i++;
			}
		}
	}
    
    private void carsReadyToLeave(){
        // Add leaving cars to the payment queue.
        Car car = simulatorView.getFirstLeavingCar();
        while (car!=null) {
        	if (car.getHasToPay()){
	            car.setIsPaying(true);
	            paymentCarQueue.addCar(car);
        	}
        	else {
        		carLeavesSpot(car);
        	}
            car = simulatorView.getFirstLeavingCar();
        }
    }

    private void carsPaying(){
        // Let cars pay.
    	int i=0;
    	while (paymentCarQueue.carsInQueue()>0 && i < paymentSpeed){
            Car car = paymentCarQueue.removeCar();
            // TODO Handle payment.
            carLeavesSpot(car);
            i++;
    	}
    }
    
    private void carsLeaving(){
        // Let cars leave.
    	int i=0;
    	while (exitCarQueue.carsInQueue()>0 && i < exitSpeed){
            exitCarQueue.removeCar();
            i++;
    	}	
    }
    
    private int getNumberOfCars(int weekDay, int weekend){
        Random random = new Random();

        // Get the average number of cars that arrive per hour.
        int averageNumberOfCarsPerHour = day < 5
                ? weekDay
                : weekend;

        // Calculate the number of cars that arrive this minute.
        double standardDeviation = averageNumberOfCarsPerHour * 0.3;
        double numberOfCarsPerHour = averageNumberOfCarsPerHour + random.nextGaussian() * standardDeviation;
        return (int)Math.round(numberOfCarsPerHour / 60);	
    }
    
    private void addArrivingCars(int numberOfCars, String type){
        // Add the cars to the back of the queue.
    	switch(type) {
    	case AD_HOC: 
            for (int i = 0; i < numberOfCars; i++) {
            	entranceCarQueue.addCar(new AdHocCar());
            }
            break;
    	case PASS:
            for (int i = 0; i < numberOfCars; i++) {
            	entrancePassQueue.addCar(new ParkingPassCar());
            }
            break;	            
    	}
    }
    
    private void carLeavesSpot(Car car){
    	simulatorView.removeCarAt(car.getLocation());
        exitCarQueue.addCar(car);
    }
    
    public boolean isStarted() {
        return started;
    }

    public boolean setStarted(boolean started) {
        this.started = started;
        return started;
    }
}
