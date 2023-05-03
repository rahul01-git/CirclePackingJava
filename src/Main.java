import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Packing Animation");
        CirclePackingAnimation cpa = new CirclePackingAnimation();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,460);
        frame.add(cpa);
        frame.setVisible(true);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                    cpa.repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
