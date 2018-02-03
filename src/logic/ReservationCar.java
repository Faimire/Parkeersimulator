package logic;

import java.util.Random;
import java.awt.*;

public class ReservationCar extends Car {
	private static final Color COLOR=Color.orange;
	
	/**
	 * The constructor for reservation
	 * Creates random numbers
	 */
    public ReservationCar() {
    	
    	Random random = new Random();
    	this.sethasReserved(true);
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
    	totalHours = Math.round(stayMinutes/60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);

    }
    
    /**
     * @return returns the color
     */
    public Color getColor(){
    	return COLOR;
    }
}
