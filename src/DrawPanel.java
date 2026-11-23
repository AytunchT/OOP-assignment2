import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    // Just a single image, TODO: Generalize
    ArrayList<BufferedImage> images = new ArrayList<>();
    // To keep track of a single car's position
    ArrayList<Point> points= new ArrayList<>();

    // TODO: Make this general for all cars
    void moveit(int index, int x, int y) {
        points.get(index).x = x;
        points.get(index).y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.black);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));
            images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            points.add(new Point());
            images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            points.add(new Point());
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < images.size(); i++) {
            g.drawImage(images.get(i), points.get(i).x, points.get(i).y, null); // see javadoc for more info on the parameters
        }
    }
}
