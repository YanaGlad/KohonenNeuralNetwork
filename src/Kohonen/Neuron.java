package Kohonen;

import java.util.ArrayList;

public class Neuron {

    //Список весов
    private final ArrayList<Double> weights;

    private final int x;
    private final int y;

    // Конструктор, принимающий список весов + расположение
    public Neuron(ArrayList<Double> w, int x, int y) {
        this.weights = w;
        this.x = x;
        this.y = y;
    }

    public ArrayList<Double> getWeights() {
        return weights;
    }

    //Получить вес i позиции из списка весов
    public Double getWeight(int i) {
        return this.weights.get(i);
    }

    //Получить позицию нейрона по абсциссам
    public int getX() {
        return x;
    }

    // Позиция нейрона по ординатам
    public int getY() {
        return y;
    }

    // Установить вес по i позиции
    public void setWeight(int i, double value) {
        this.weights.set(i, value);
    }

    // Получить количество весов
    public int getSizeWeights() {
        return this.weights.size();
    }

}
