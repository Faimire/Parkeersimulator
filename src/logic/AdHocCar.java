package logic;

import java.util.Random;
import java.awt.*;

public class AdHocCar extends Car {
	private static final Color COLOR=Color.red;
	
    public AdHocCar() {
    	Random random = new Random();
    	this.sethasReserved(false);
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
    	totalHours = Math.round(stayMinutes/60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
    }
    
    // return the color
    public Color getColor(){
    	return COLOR;
    }
}
