import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CirclePackingAnimation extends JPanel {
    ArrayList<Circle> circles;
    public CirclePackingAnimation() {
        setup();
    }

    void setup(){
        circles = new ArrayList<Circle>();
        circles.add(new Circle(200,200));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circle c : circles) {
            if(c.edges())
                c.growing=false;
            c.paint(g);
            c.update();
        }
    }

}
