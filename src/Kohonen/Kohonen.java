package Kohonen;

import javax.swing.*;
import java.util.ArrayList;

public class Kohonen {
    // количество итераций
    private final int steps;

    //Сеть
    public Network network;

    // Входная сеть
    ArrayList<ArrayList<Double>> input;

    JPanel screen;

     // Конктруктор. Принимает файл параметров, ширину и длину экрана
    public Kohonen(String filename, int width, int height, JPanel screen) {
        // Размер сети
        this.network = new Network(width, height);
        this.input = FileParser.getListFromFile(filename);
        this.steps = 2000;
        this.screen = screen;
    }

    // Добавляет нейрон в сеть по позиуии
    public void addNeuron(ArrayList<Double> weights, int i, int j) {
        network.setNeuron(i, j, new Neuron(weights, i, j));
    }

    /**
     * SOM алгоритм
     * Пока < iterations :
     * - Выбираем рандомный вектор.
     * - Находим BMU ввода
     * - Обновляем соседей BMU
     */
    public void somAlgorythm() {
        // Выбираем рандомный вектор
        ArrayList<Double> oldVector = new ArrayList<>();
        ArrayList<Double> vector;

        for (int t = 0; t < steps; t++) {

            // Выбрать вектор, отличный от предыдущего
            do {
                int randomInput = (int) (Math.random() * input.size());
                vector = input.get(randomInput);
            } while (oldVector.equals(vector));

            oldVector = new ArrayList<>(vector);

            // Вычисляем bmu (Best Matching Unit).
            Neuron bmu = network.getBMU(vector);

            // Обновляем соседей
            if (steps >= bmu.getSizeWeights()) network.updateNeighbors(bmu, vector, t, steps);

            // Обновляем экран
            this.screen.repaint();
            // Sleep для анимации
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println("Unexpected exception" + e);
            }
        }
    }
}
