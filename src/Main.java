import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("hello");
        CirclePackingAnimation cpa = new CirclePackingAnimation();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,360);
        frame.add(cpa);
        frame.setVisible(true);
    }
}