import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel {
    int x;
    int y;
    int r;
    boolean growing = true;
    Color color;

    Circle(int x_, int y_){
        this.x = x_;
        this.y = y_;
        this.r = 1;
//        color = Color.getHSBColor((float) Math.random(), 1, 1);
    }

    public void update(){
        if(growing){
            r+=1;
            if(r > 20){  // Limit the maximum radius to 50
                r = 20;
            }
        }
        repaint();
    }

    boolean edges(int width, int height){
        return  (x+r > width || x-r < 0 || y+r > height || y-r < 0);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
//        g.setColor(color);
        g.setColor(Color.white);
        g2d.drawOval(x-r, y-r, r*2, r*2);
        g2d.setStroke(new BasicStroke(2));
    }
}
