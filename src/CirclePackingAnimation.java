import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class CirclePackingAnimation extends JPanel {
    ArrayList<Circle> circles;
    Random random = new Random();

    public CirclePackingAnimation() {
        setBackground(Color.BLACK);
        setup();
    }

    void setup(){
        circles = new ArrayList<Circle>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = random.nextInt(640);
        int y = random.nextInt(460);
        circles.add(new Circle(x,y));

        for (Circle c : circles) {
            if(c.edges(getWidth(), getHeight()))
                c.growing=false;
            c.update();
            c.paint(g);
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }
}
