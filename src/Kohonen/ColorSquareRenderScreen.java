package Kohonen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class ColorSquareRenderScreen extends JPanel {

    private final int width = 1200;
    private final int height = 1200;
    private final int squareSize = 50;
    private final int measuredWidth = width / squareSize;
    private final int measuredHeight = height / squareSize;
    private final Kohonen kohonen;

    public Kohonen getKohonen() {
        return this.kohonen;
    }

    // При инициализации окна создается карта Кохонена с рандомными цветами.
    // Затем алгоритм Self-Organizing-Map (SOM) применяется к отображенному окну
    public ColorSquareRenderScreen() {
        this.kohonen = new Kohonen("src/colors.txt", measuredWidth, measuredHeight, this);
        this.init();
        this.setVisible(true);
    }

    // Инициализировать нейроны рандомными значениями
    public void init() {
        for (int i = 0; i < measuredHeight; i++) {
            for (int j = 0; j < measuredWidth; j++) {

                // Установить рандомные цвета
                double red = Math.random();
                double green = Math.random();
                double blue = Math.random();

                // Создать нейрон и добавить в сеть
                kohonen.addNeuron(new ArrayList<>(Arrays.asList(red, green, blue)), j, i);
            }
        }
    }

    // Рисуем цветные квадраты
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < measuredHeight; i++) {
            for (int j = 0; j < measuredWidth; j++) {
                Neuron neuron = kohonen.network.getNeuron(i, j);
                ArrayList<Double> colors = neuron.getWeights();

                g.setColor(new Color((int) (colors.get(0) * 255), (int) (colors.get(1) * 255), (int) (colors.get(2) * 255)));
                g.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
            }
        }
    }
}
