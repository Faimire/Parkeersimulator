package logic;

import java.util.Random;
import java.awt.*;

public class ReservationCar extends Car {
	private static final Color COLOR=Color.orange;
	
    public ReservationCar() {
    	
    	Random random = new Random();
    	this.sethasReserved(true);
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(false);
    }
    
    public Color getColor(){
    	return COLOR;
    }
}
