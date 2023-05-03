import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CirclePackingAnimation extends JPanel {
    ArrayList<Circle> circles = new ArrayList<>();
    public CirclePackingAnimation() {
        setup();
    }

    void setup(){
        circles.add(new Circle(200,200));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circle c : circles)
            c.paint(g);
    }

}
