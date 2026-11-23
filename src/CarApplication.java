void main() {
    // Instance of this class
    CarController cc = new CarController();

    // TODO uncomment, and adapt if necessary
    // xMax = 700, yMax = 500
    cc.cars.add(new Volvo240(250,250));
    cc.cars.add(new Saab95(450, 250));

    // Start a new view and send a reference to the controller
    cc.frame = new CarView("CarSim 1.0", cc);
    cc.startTimer();
}