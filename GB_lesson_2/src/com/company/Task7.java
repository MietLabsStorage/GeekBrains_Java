package com.company;

public class Task7 {
    //task 7.
    //*Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами.

    public static void shift(int[] arr, int n){
        if(n > 0){
            for(int i = 0; i < n; i++) {
                int tempElement = arr[arr.length - 1];
                for(int j = arr.length - 1; j > 0; j--)
                    arr[j] = arr[j-1];
                arr[0] = tempElement;
            }
        }
        else{
            for(int i = 0; i < Math.abs(n); i++) {
                int tempElement = arr[0];
                for(int j = 0; j < arr.length - 1; j++)
                    arr[j] = arr[j+1];
                arr[arr.length - 1] = tempElement;
            }
        }

    }

    public static void run(){
        System.out.println("--task 7--");
        int[] arr7 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        Main.showArr(arr7);
        shift(arr7, -2);
        Main.showArr(arr7);
        shift(arr7, 3);
        Main.showArr(arr7);
    }
}
