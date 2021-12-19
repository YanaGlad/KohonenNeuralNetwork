package Kohonen;

import javax.swing.*;


public class Application {

    public static void main(String[] args) {
        ColorSquareRenderScreen screen = new ColorSquareRenderScreen();
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(screen, "Center");
        frame.setTitle("Карта Кохонена Курсовая Гладких");
        frame.setSize(1200, 1200);
        frame.setVisible(true);

        screen.getKohonen().somAlgorythm();
    }
}
