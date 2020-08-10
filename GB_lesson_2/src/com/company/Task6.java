package com.company;

public class Task6 {
    //task 6.
    //Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    // если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
    // checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят;

    public static boolean checkBalance(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
            sum += arr[i];
        sum = sum / 2;
        boolean flag = false;
        int leftSum = arr[0]; int rightSum = 0;
        for(int i = 1; i < arr.length; i++){
            if(!flag) {
                if (leftSum != sum)
                    leftSum += arr[i];
                else {
                    flag = true;
                    rightSum = arr[i];
                }
            }
            else{
                rightSum += arr[i];
            }
        }
        return leftSum == rightSum;
    }

    public static void run()
    {
        System.out.println("--task 6--");
        System.out.println(checkBalance (new int[]{1, 1, 1, 2, 1}));
        System.out.println(checkBalance (new int[]{2, 1, 1, 2, 1}));
        System.out.println(checkBalance (new int[]{10, 10}));
        System.out.println(checkBalance (new int[]{4, -4, 4, -4, 0, 0}));
    }
}

