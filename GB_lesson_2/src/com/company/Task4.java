package com.company;

public class Task4 {
    public static void run(){
        //task 4.
        //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("--task 4--");
        int[][] matrix = new int[5][5];
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - 1 - i] = 1;
        }
        for(int i = 0; i < matrix.length; i++)
            Main.showArr(matrix[i]);
    }
}
