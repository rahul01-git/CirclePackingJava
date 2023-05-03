import javax.swing.*;
import java.awt.*;

public class Circle  extends JPanel {
    int x;
    int y;
    int r;
    boolean growing = true;
    Circle(int x_, int y_){
        this.x = x_;
        this.y = y_;
        r=50;
    }

    public void update(){
        if(growing) r+=1;
        System.out.println(r);
        repaint();
    }

    boolean edges(){
        return  (x+r > 640 || x-r <0 || y+r > 460 || y-r<0);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.fillRect(0,0,640,460);
        ((Graphics2D) g).setStroke(new BasicStroke(2));
        g.setColor(Color.white);
        g2d.drawOval(x,y,r*2,r*2);
    }

}
