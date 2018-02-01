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
    
    public int getTotalHours() {
    	return totalHours;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getMinutesLeft() {
        return minutesLeft;
    }
    
    public int getamountOfMinutes() {
    	return amountOfMinutes;
    	
    }
    
    public void setamountOfMinutes(int time) {
    	amountOfMinutes = time;
    }

    public void setMinutesLeft(int minutesLeft) {
        this.minutesLeft = minutesLeft;
    }
    
    public boolean getIsPaying() {
        return isPaying;
    }
    
    public boolean gethasReserved() {
    	return hasReserved;
    }

    public boolean carReadyToEnterGarage() {
    	return carReadyToEnterGarage;
    }
    
    public void setIsPaying(boolean isPaying) {
        this.isPaying = isPaying;
    }

    public boolean getHasToPay() {
        return hasToPay;
    }

    public void setHasToPay(boolean hasToPay) {
        this.hasToPay = hasToPay;
    }
    
    public void sethasReserved(boolean hasReserved) {
    	this.hasReserved = hasReserved;
    }
    
    public void setcarReadyToEnterGarage(boolean carReadyToEnterGarage) {
    	this.carReadyToEnterGarage = carReadyToEnterGarage;
    }

    public void tick() {
        minutesLeft--;
    }
    
    public abstract Color getColor();
}