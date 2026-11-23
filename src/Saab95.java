import java.awt.*;

public class Saab95 extends cars {
    private boolean turboOn;

    public Saab95(double x, double y) {
        super(2, Color.red, 125, "Saab95", x, y);
        turboOn = false;
    }

    public void setTurboOn() { turboOn = true; }
    public void setTurboOff() { turboOn = false; }

    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}