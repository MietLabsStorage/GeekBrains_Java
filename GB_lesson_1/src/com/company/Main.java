package com.company;

public class Main {
    //task 3.
    // Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    // где a, b, c, d – входные параметры этого метода;
    public static double task3(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    //task 4.
    // Написать метод, принимающий на вход два числа, и проверяющий,
    // что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false;
    public static boolean task4(double a, double b) {
        return ((10 >= (a + b)) && ((a + b) <= 20));
    }

    //task 5.
    // Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
    // положительное число передали или отрицательное (Замечание: ноль считаем положительным числом.);
    public static void task5(double x) {
        if (x >= 0) {
            System.out.println(x + " is positive number");
        }
        else {
            System.out.println(x + " is negative number");
        }
    }

    //task 6.
    // Написать метод, которому в качестве параметра передается целое число,
    // метод должен вернуть true, если число отрицательное;
    public static boolean task6(int x)
    {
        return x < 0;
    }

    //task 7.
    // Написать метод, которому в качестве параметра передается строка,
    // обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public static void task7(String name)
    {
        System.out.println("Привет, " + name + "!");
    }

    //task 8.
    // *Написать метод, который определяет, является ли год високосным,
    // и выводит сообщение в консоль. Каждый 4-й год является високосным,
    // кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean task8(int year)
    {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }

    //task 1.
    // Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {
        //task 2.
        // Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte byteVar = 127;
        short shortVar = -32000;
        char charVr = 'c';
        int intVar = 1000000;
        long longVar = -100000000L;
        float floatVar = 3.0f;
        double doubleVAar = 3.0;
        boolean boolVar = true;
        String strVar = "java";

        //methods' demonstration
        System.out.println("task 3:\n" + task3(2,2.5,1.5,0));

        System.out.println("task 4:");
        System.out.println(task4(5,5));
        System.out.println(task4(15,6));

        System.out.println("task 5:");
        task5(0);
        task5(-0.1);

        System.out.println("task 6:");
        System.out.println(task6(-1));
        System.out.println(task6(1));

        System.out.println("task 7:");
        task7("Maks");

        System.out.println("task 8:");
        System.out.println("is 2000 bissextile: " + task8(2000));
        System.out.println("is 2100 bissextile: " + task8(2100));
        System.out.println("is 2020 bissextile: " + task8(2020));
    }
}
