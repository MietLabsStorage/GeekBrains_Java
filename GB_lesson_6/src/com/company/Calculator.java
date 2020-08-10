package com.company;

public abstract class Calculator {
    public static double add(double left, double right){
        return left + right;
    }

    public static double subtract(double left, double right){
        return left - right;
    }

    public static double multiply(double left, double right){
        return left * right;
    }

    public static double divide(double left, double right){
        return left / right;
    }

    public static  double power(double left, double right) { return Math.pow(left, right); }
}
