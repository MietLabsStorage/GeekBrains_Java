package com.company;

public class Task3 {
    public static void run(){
        //task 3.
        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;
        System.out.println("--task 3--");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Arr:");
        Main.showArr(arr3);
        for(int i = 0; i < arr3.length; i++) {
            if(arr3[i] < 6)
                arr3[i] *=2;
        }
        System.out.println("New arr:");
        Main.showArr(arr3);
    }
}
