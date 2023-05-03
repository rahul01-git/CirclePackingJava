import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Circle  {
    int x;
    int y;
    int r;
    Circle(int x_, int y_){
        this.x = x_;
        this.y = y_;
        r=50;
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.fillRect(0,0,640,360);
        ((Graphics2D) g).setStroke(new BasicStroke(2));
        g.setColor(Color.white);
        g2d.drawOval(x,y,r*2,r*2);
    }

}
