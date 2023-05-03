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

        Circle newC = newCircle();
        if(newC != null){
            circles.add(newC);
        }

        for (Circle c : circles) {
            if (c.growing){
                if(c.edges(getWidth(), getHeight())){
                    c.growing=false;
                }else{
                    for(Circle other : circles){
                        if(c != other){
                            double d = dist(c.x,c.y,other.x,other.y);
                            if(d<c.r + other.r){
                                c.growing = false;
                                break;
                            }
                        }
                    }
                }
            }

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

    private Circle newCircle() {
        int x = random.nextInt(640);
        int y = random.nextInt(460);

        boolean valid = true;
        for (Circle c : circles) {
            double d = dist(x, y, c.x, c.y);
            if(d<c.r){
                valid = false;
                break;
            }
        }

        if(valid){
            return new Circle(x,y);
        }else return null;
    }

    public static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }



}
