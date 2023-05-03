import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Packing Animation");
        CirclePackingAnimation cpa = new CirclePackingAnimation();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,400);
        frame.add(cpa);
        frame.setVisible(true);
    }
}
