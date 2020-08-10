package com.company;

public class Task1 {
    public static void run(){
        //task1.
        //Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("--task 1--");
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Arr:");
        Main.showArr(arr1);
        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] == 0 ? 1 : 0;
        }
        System.out.println("New arr:");
        Main.showArr(arr1);
    }
}
