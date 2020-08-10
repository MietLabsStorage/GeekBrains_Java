package com.company;

public class Task2 {
    public static void run(){
        //task 2.
        //Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("--task 2--");
        int[] arr2 = new int[8];
        for(int i = 0; i< arr2.length; i++) {
            arr2[i] = i * 3;
        }
        Main.showArr(arr2);
    }
}















