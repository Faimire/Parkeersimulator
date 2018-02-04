/**
 * @author Jonathan, Nick, Rick and Mark
 * @version 1.0
 */

package logic;

import java.awt.*;

public abstract class Car {

    private Location location;
    private int minutesLeft;
    private int amountOfMinutes;
    private boolean isPaying;
    private boolean hasToPay;
    private boolean hasReserved;
    private boolean carReadyToEnterGarage;
    protected int totalHours;

    /**
     * Constructor for objects of class Car
     */
    
    public Car() {

    }
    
   /**
    * 
    * @return returns the total hours
    */
    public int getTotalHours() {
    	return totalHours;
    }

    /**
     * 
     * @return returns the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location The location in the simulator
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * 
     * @return returns the minutes left
     */
    public int getMinutesLeft() {
        return minutesLeft;
    }
    
    /**
     * 
     * @return returns the amount of minutes
     */
    public int getamountOfMinutes() {
    	return amountOfMinutes;
    	
    }
    
    /**
     * 
     * @param time Sets the amount of time in minutes
     */
    public void setamountOfMinutes(int time) {
    	amountOfMinutes = time;
    }

    /**
     * 
     * @param minutesLeft The minutes the car has left
     */
    public void setMinutesLeft(int minutesLeft) {
        this.minutesLeft = minutesLeft;
    }
    
    /**
     * 
     * @return if the car is paying or not
     */
    public boolean getIsPaying() {
        return isPaying;
    }
    
    /**
     * 
     * @return if the car has a reserved spot
     */
    public boolean gethasReserved() {
    	return hasReserved;
    }

    /**
     * 
     * @return if the cars are able to enter the garage
     */
    public boolean carReadyToEnterGarage() {
    	return carReadyToEnterGarage;
    }
    
    /**
     * 
     * @param isPaying Paying for a parking spot
     */
    public void setIsPaying(boolean isPaying) {
        this.isPaying = isPaying;
    }

    /**
     * 
     * @return if there has to be payed
     */
    public boolean getHasToPay() {
        return hasToPay;
    }

    /**
     * 
     * @param hasToPay If it is required to pay
     */
    public void setHasToPay(boolean hasToPay) {
        this.hasToPay = hasToPay;
    }
    
    /**
     * 
     * @param hasReserved If a spot has been reserved
     */
    public void sethasReserved(boolean hasReserved) {
    	this.hasReserved = hasReserved;
    }
    
    /**
     * 
     * @param carReadyToEnterGarage If a car is ready to drive into the garage
     */
    public void setcarReadyToEnterGarage(boolean carReadyToEnterGarage) {
    	this.carReadyToEnterGarage = carReadyToEnterGarage;
    }

    /**
     *  The minutes left
     */
    public void tick() {
        minutesLeft--;
    }
    
    /**
     * 
     * @return returns the color
     */
    public abstract Color getColor();
}