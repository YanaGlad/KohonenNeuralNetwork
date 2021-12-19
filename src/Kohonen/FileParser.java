package Kohonen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Парсер текстовый файлов. Для упрощения
public class FileParser {

    public static String read(String filename) {
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();

            while (line != null) {
                text.append(line);
                text.append("\n");
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    //вектор + значения
    public static ArrayList<ArrayList<Double>> getListFromFile(String filename) {
        String inputStr = read(filename);
        ArrayList<ArrayList<Double>> input = new ArrayList<>();

        String[] inputSplit = inputStr.split("\n");
        String[] vectors;
        String line;
        int index = 0;

        for (String str : inputSplit) {
            line = str;

            input.add(new ArrayList<>());
            vectors = line.split("\t");

            for (int i = 1; i < vectors.length; i++) {
                input.get(index).add(Double.parseDouble(vectors[i]));
            }
            index++;
        }

        return input;
    }
}
