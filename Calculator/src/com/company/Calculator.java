package com.company;

public abstract class Calculator {
    private static int left = 0;
    private static int right = 0;
    private static double answer = 0;
    private static int leftPower = 1;
    private static int rightPower = 1;
    private static String operationSym = "?";
    private static boolean isOperation = false;
    private static boolean isAnswer = false;
    private static boolean isDote = false;

    public static String getMessage(){
        return ((leftPower > 1) ? Double.toString(left / (double) leftPower) : Integer.toString(left)) +
                " " + operationSym + " " +
                ((rightPower > 1) ? Double.toString(right / (double) rightPower) : Integer.toString(right)) +
                " = " + answer;
    }

    public static void setDote(){
        if(isAnswer){
            isAnswer = false;
            left = 0;
            right = 0;
            rightPower = 1;
            leftPower = 1;
            isDote = false;
            answer = 0;
            operationSym = "?";
            isOperation = false;
        }
        isDote = true;
    }

    public static void setMinus(){
        if(isAnswer){
            isAnswer = false;
            left = 0;
            right = 0;
            rightPower = 1;
            leftPower = 1;
            isDote = false;
            answer = 0;
            operationSym = "?";
            isOperation = false;
        }
        if (!isOperation) {
            left = left * (-1);
        } else {
            right = right * (-1);
        }
    }

    public static void setNum(int n){
        if(isAnswer){
            isAnswer = false;
            left = 0;
            right = 0;
            rightPower = 1;
            leftPower = 1;
            isDote = false;
            answer = 0;
            operationSym = "?";
            isOperation = false;
        }
        if (!isOperation) {
            left = left * 10 + n;
            if(isDote){
                leftPower*=10;
            }
        } else {
            right = right * 10 + n;
            if(isDote){
                rightPower*=10;
            }
        }
    }

    public static void operation(String sym){
        if(isAnswer){
            isAnswer = false;
            left = (int)(answer*rightPower*leftPower);
            right = 0;
            rightPower = 1;
            leftPower = rightPower*leftPower;
            isDote = false;
            answer = 0;
            operationSym = sym;
            isOperation = true;
        }
        if(isOperation){
            isAnswer = false;
            answer();
            isAnswer = false;
            left = (int)(answer*rightPower*leftPower);
            right = 0;
            rightPower = 1;
            leftPower = rightPower*leftPower;
            isDote = false;
            answer = 0;
            operationSym = sym;
            isOperation = true;
        }
        if(!isOperation){
            operationSym = sym;
            isOperation = true;
            isDote = false;
        }
    }

    public static void answer(){
        if(!isAnswer){
            isAnswer = true;
            switch (operationSym){
                case "+":
                    answer = add(left/(double)leftPower, right/(double)rightPower);
                    break;
                case "-":
                    answer = subtract(left/(double)leftPower, right/(double)rightPower);
                    break;
                case "*":
                    answer = multiply(left/(double)leftPower, right/(double)rightPower);
                    break;
                case "/":
                    answer = divide(left/(double)leftPower, right/(double)rightPower);
                    break;
                case "^":
                    answer = power(left/(double)leftPower, right/(double)rightPower);
                    break;
            }
        }
    }

    private static double add(double left, double right){
        return left + right;
    }

    private static double subtract(double left, double right){
        return left - right;
    }

    private static double multiply(double left, double right){
        return left * right;
    }

    private static double divide(double left, double right){
        return left / right;
    }

    private static double power(double left, double right) {
        return Math.pow(left, right);
    }
}
