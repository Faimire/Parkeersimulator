package view;

import javax.swing.*;
import javax.swing.border.Border;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import logic.*;
import main.*;

import java.awt.*;

public class SimulatorView extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3151124700217177923L;
	private CarParkView carParkView;
    private int numberOfFloors;
    private int numberOfRows;
    private int numberOfPlaces;
    private int numberOfOpenSpots;
    private Car[][][] cars;
    public static Container contentPane;
    public JButton button1, button2, button3, button4;
    public static JLabel clock;
    public static ChartPanel panel;
    public static int blue = 0, red = 0;

    public SimulatorView(int numberOfFloors, int numberOfRows, int numberOfPlaces) {
    	getContentPane().setBackground(SystemColor.inactiveCaption);
        this.numberOfFloors = numberOfFloors;
        this.numberOfRows = numberOfRows;
        this.numberOfPlaces = numberOfPlaces;
        this.numberOfOpenSpots =numberOfFloors*numberOfRows*numberOfPlaces;
        cars = new Car[numberOfFloors][numberOfRows][numberOfPlaces];
        
        carParkView = new CarParkView();
        panel = new ChartPanel(Piechart.createChart(Piechart.createDataset()));
             
        clock();
        contentPane = getContentPane();
        addToPane();
        contentPane.setLayout(null);
        setupBounds();
        setVisible(true);
        pack();

        updateView();
    }
    
    public void addToPane() {
    	contentPane.add(clock);
        contentPane.add(carParkView);
        contentPane.add(panel);
    }
    
    public void setupBounds() {
    	clock.setBounds(100,600,230,50);
        carParkView.setBounds(100,75,850,500); 
        panel.setBounds(1050, 75, 800, 400);
    }
    
    public static void updatePie() {
    	contentPane.remove(panel);
    	panel = null;
    	panel = new ChartPanel(Piechart.createChart(Piechart.createDataset()));
    	contentPane.add(panel);	
    	panel.setBounds(1050, 75, 800, 400);
    	
    }
    // setups the clock label for view
    public void clock() {
        clock = new JLabel("DD:MM:YY");
        clock.setOpaque(true);
        Font clockfont = clock.getFont();
        clock.setFont(new Font(clockfont.getName(), Font.PLAIN, 15));
    }

    public void updateView() {
        carParkView.updateView();
    }
    
	public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public int getNumberOfOpenSpots(){
    	return numberOfOpenSpots;
    }
    

    
    public Car getCarAt(Location location) {
        if (!locationIsValid(location)) {
            return null;
        }
        return cars[location.getFloor()][location.getRow()][location.getPlace()];
    }

    public boolean setCarAt(Location location, Car car) {
        if (!locationIsValid(location)) {
            return false;
        }
        Car oldCar = getCarAt(location);
        if (oldCar == null) {
            cars[location.getFloor()][location.getRow()][location.getPlace()] = car;
            car.setLocation(location);
            numberOfOpenSpots--;
            return true;
        }
        return false;
    }

    public Car removeCarAt(Location location) {
        if (!locationIsValid(location)) {
            return null;
        }
        Car car = getCarAt(location);
        if (car == null) {
            return null;
        }
        cars[location.getFloor()][location.getRow()][location.getPlace()] = null;
        car.setLocation(null);
        numberOfOpenSpots++;
		// sets value of the amount red to blue cars
        if(car.getHasToPay() == true) {
        	red--;
        }
        if(car.getHasToPay() == false) {
           blue--;
        }
        return car;
    }

	public Location getFirstFreeLocation(Car car) {

		if (car.getHasToPay() == true) {
			 // sets value of the amount red to blue cars
			red++;
			for (int floor = 1; floor < getNumberOfFloors(); floor++) {
				for (int row = 0; row < getNumberOfRows(); row++) {
					for (int place = 0; place < getNumberOfPlaces(); place++) {
						Location location = new Location(floor, row, place);
						if (getCarAt(location) == null) {
							return location;
						}
					}
				}

			}

		}
		if (car.getHasToPay() == false) {
			 // sets value of the amount red to blue cars
			blue++;
			for (int floor = 0; floor < getNumberOfFloors(); floor++) {
				for (int row = 0; row < getNumberOfRows(); row++) {
					for (int place = 0; place < getNumberOfPlaces(); place++) {
						Location location = new Location(floor, row, place);
						if (getCarAt(location) == null) {
							return location;
						}
					}
				}
			}

		}
		return null;
	}

    public Car getFirstLeavingCar() {
        for (int floor = 0; floor < getNumberOfFloors(); floor++) {
            for (int row = 0; row < getNumberOfRows(); row++) {
                for (int place = 0; place < getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    Car car = getCarAt(location);
                    if (car != null && car.getMinutesLeft() <= 0 && !car.getIsPaying()) {
                        return car;
                    }
                }
            }
        }
        return null;
    }

    public void tick() {
        for (int floor = 0; floor < getNumberOfFloors(); floor++) {
            for (int row = 0; row < getNumberOfRows(); row++) {
                for (int place = 0; place < getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    Car car = getCarAt(location);
                    if (car != null) {
                        car.tick();
                    }
                }
            }
        }
    }

    private boolean locationIsValid(Location location) {
        int floor = location.getFloor();
        int row = location.getRow();
        int place = location.getPlace();
        if (floor < 0 || floor >= numberOfFloors || row < 0 || row > numberOfRows || place < 0 || place > numberOfPlaces) {
            return false;
        }
        return true;
    }
    
    private class CarParkView extends JPanel {
        
        /**
		 * 
		 */
		private static final long serialVersionUID = -6763868542977448053L;
		private Dimension size;
        private Image carParkImage;    
    
        /**
         * Constructor for objects of class CarPark
         */
        public CarParkView() {
            size = new Dimension(0, 0);
        }
    
    
        /**
         * Overriden. The car park view component needs to be redisplayed. Copy the
         * internal image to screen.
         */
        public void paintComponent(Graphics g) {
            if (carParkImage == null) {
                return;
            }
    
            Dimension currentSize = getSize();
            if (size.equals(currentSize)) {
                g.drawImage(carParkImage, 0, 0, null);
            }
            else {
                // Rescale the previous image.
                g.drawImage(carParkImage, 0, 0, currentSize.width, currentSize.height, null);
            }
        }
    
        public void updateView() {
            // Create a new car park image if the size has changed.
            if (!size.equals(getSize())) {
                size = getSize();
                carParkImage = createImage(size.width, size.height);
            }
            Graphics graphics = carParkImage.getGraphics();
            for(int floor = 0; floor < getNumberOfFloors(); floor++) {
                for(int row = 0; row < getNumberOfRows(); row++) {
                    for(int place = 0; place < getNumberOfPlaces(); place++) {
                        Location location = new Location(floor, row, place);
                        Car car = getCarAt(location);
                        Color color = car == null ? Color.white : car.getColor();
                        drawPlace(graphics, location, color);
                    }
                }
            }
            repaint();
        }
    
        /**
         * Paint a place on this car park view in a given color.
         */
        private void drawPlace(Graphics graphics, Location location, Color color) {
            graphics.setColor(color);
            graphics.fillRect(
                    location.getFloor() * 260 + (1 + (int)Math.floor(location.getRow() * 0.5)) * 75 + (location.getRow() % 2) * 20,
                    60 + location.getPlace() * 10,
                    20 - 1,
                    10 - 1); // TODO use dynamic size or constants
        }
    }
}
