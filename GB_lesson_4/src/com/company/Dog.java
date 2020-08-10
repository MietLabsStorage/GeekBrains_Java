package com.company;

import java.util.Random;

public class Dog extends Animal {
    //7. У каждого животного есть ограничения на действия
    // (бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.;
    // плавание: кот не умеет плавать, собака – 10 м.);
    private int runDistance;
    private int swimDistance;
    private double jumpHeight;
    public Dog(boolean defaultForce){
        if(defaultForce){
            runDistance = 500;
            swimDistance = 10;
            jumpHeight = 0.5;
        }
        else{
            //9. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.
            Random random = new Random();
            runDistance = random.nextInt(1000);
            swimDistance = random.nextInt(15);
            jumpHeight = random.nextInt(15) / 10.0;
        }
    }

    public void run(int distance){
        if(distance <= runDistance){
            System.out.println("Dog:: run " + distance);
        }
        else{
            System.out.println("Dog:: run " + runDistance);
            System.err.println("Dog:: run still " + (distance-runDistance));
        }
    }

    public void swim(int distance){
        if(distance <= swimDistance){
            System.out.println("Dog:: swim " + distance);
        }
        else{
            System.out.println("Dog:: swim " + swimDistance);
            System.err.println("Dog:: swim still " + (distance-swimDistance));
        }
    }

    public void jump(int height){
        if(height <= jumpHeight){
            System.out.println("Dog:: jump " + height);
        }
        else{
            System.out.println("Dog:: jump " + jumpHeight);
            System.err.println("Dog:: jump still " + (height-jumpHeight));
        }
    }
}
