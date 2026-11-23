import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // The delay (ms) corresponds to 20 updates/second (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // TODO A list of cars, modify if needed
    ArrayList<cars> cars = new ArrayList<>(); //Car

    public void startTimer() {
        this.timer.start();
    }

    /* Each step, the TimerListener moves all cars in the list and tells the
     * view to update its images. TODO Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < cars.size(); i++) {
                cars car = cars.get(i);
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                int borderX =frame.drawPanel.getWidth() - frame.drawPanel.images.get(i).getWidth();
                int borderY = frame.drawPanel.getHeight() - frame.drawPanel.images.get(i).getHeight();
                if ((x > borderX && car.getDirection() == 1) || (y > borderY && car.getDirection() == 0) || (x < 0 && car.getDirection() == 3) || (y < 0 && car.getDirection() == 2)){
                    car.stopEngine();
                    car.turnLeft();
                    car.turnLeft();
                    car.startEngine();
                }


                frame.drawPanel.moveit(i, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.revalidate();
                frame.drawPanel.repaint();
            }

        }
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (cars car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (cars car : cars) {
            car.brake(brake);
        }
    }
    void turnRight() {
        for (cars car : cars) {
            car.turnRight();
        }
    }
    void turnLeft() {
        for (cars car : cars) {
            car.turnLeft();
        }
    }
    void startEngine() {
        for (cars car : cars) {
            car.startEngine();
        }
    }
    void stopEngine() {
        for (cars car : cars) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (cars car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (cars car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }
}
