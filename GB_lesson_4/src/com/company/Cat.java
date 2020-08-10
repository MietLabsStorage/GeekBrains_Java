package com.company;

import java.util.Random;

public class Cat extends Animal{
    //7. У каждого животного есть ограничения на действия
    // (бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.;
    // плавание: кот не умеет плавать, собака – 10 м.);
    private int runDistance;
    private double jumpHeight;
    public Cat(boolean defaultForce){
        if(defaultForce){
            runDistance = 200;
            jumpHeight = 2;
        }
        else{
            //9. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.
            Random random = new Random();
            runDistance = random.nextInt(500);
            jumpHeight = random.nextInt(30) / 10.0;
        }
    }

    public void run(int distance){
        if(distance <= runDistance){
            System.out.println("Cat:: run " + distance);
        }
        else{
            System.out.println("Cat:: run " + runDistance);
            System.err.println("Cat:: run still " + (distance-runDistance));
        }
    }

    public void swim(int distance){
        System.out.println("Cat:: can't swim");
    }

    public void jump(int height){
        if(jumpHeight <= runDistance){
            System.out.println("Cat:: jump " + height);
        }
        else{
            System.out.println("Cat:: jump " + jumpHeight);
            System.err.println("Cat:: jump still " + (height-jumpHeight));
        }
    }
}
