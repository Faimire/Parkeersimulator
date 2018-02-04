/**
 * @author Jonathan, Nick, Rick and Mark
 * @version 1.0
 */

package logic;
import java.util.LinkedList;
import java.util.Queue;

public class CarQueue {
    private Queue<Car> queue = new LinkedList<>();

    /**
     * 
     * @param car If a car can be added
     * @return returns the car queue
     */
    public boolean addCar(Car car) {
        return queue.add(car);
    }

    /**
     * 
     * @return returns the poll queue
     */
    public Car removeCar() {
        return queue.poll();
    }

    /**
     * 
     * @return returns the size of the queue
     */
    public int carsInQueue(){
    	return queue.size();
    }
}
