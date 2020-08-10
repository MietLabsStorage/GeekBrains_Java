package com.company;

public class Task5 {
    public static void run(){
        //task 5.
        //Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("--task 5--");
        int[] arr5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int minIndex = 0;
        int maxIndex = 0;
        int minValue = arr5[minIndex];
        int maxValue = arr5[maxIndex];
        for(int i = 1; i < arr5.length; i++){
            if(arr5[i] < minValue) {
                minValue = arr5[i];
                minIndex = i;
            }
            if(arr5[i] > maxValue) {
                maxValue = arr5[i];
                maxIndex = i;
            }
        }
        System.out.printf("Min element: value = %d\tindex (firstly) = %d\n", minValue, minIndex);
        System.out.printf("Max element: value = %d\tindex (firstly) = %d\n", maxValue, maxIndex);
    }
}
