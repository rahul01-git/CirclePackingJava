import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class CirclePackingAnimation extends JPanel {
    ArrayList<Circle> circles;
    ArrayList<Vector<Integer>> spots;
    Random random = new Random();
    private BufferedImage image;

    public CirclePackingAnimation() {
        setBackground(Color.BLACK);
        try {
            image = ImageIO.read(new File("R:\\Circle packing\\src\\2017.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setup();
    }

    void setup(){
        spots = new ArrayList<Vector<Integer>>();
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int color = image.getRGB(x, y);
                int r = (color >> 16) & 0xFF;
                int g = (color >> 8) & 0xFF;
                int b = color & 0xFF;
                float brightness = (r + g + b) / (3f * 255);
                if(brightness>0.5){
                    Vector<Integer> pos = new Vector<Integer>(2);
                    pos.add(x);
                    pos.add(y);
                    spots.add(pos);
                }
            }
        }
//        System.out.println(spots);
        circles = new ArrayList<Circle>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(image, 0, 0, null);
        int total = 10;
        int count = 0;
        int attempts = 0;
        while (count<total){
            Circle newC = newCircle();
            if(newC != null){
                circles.add(newC);
                count++;
            }
            attempts++;
            if(attempts>1000){
                System.out.println("finished");
                System.exit(0);
                break;
            }
        }

        for (Circle c : circles) {
            if (c.growing){
                if(c.edges(getWidth(), getHeight())){
                    c.growing=false;
                }else{
                    for(Circle other : circles){
                        if(c != other){
                            double d = dist(c.x,c.y,other.x,other.y);
                            if(d-2<c.r + other.r){
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

        int r = random.nextInt(spots.size());
        Vector<Integer> spot = spots.get(r);
        int x = spot.get(0);
        int y = spot.get(1);

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
