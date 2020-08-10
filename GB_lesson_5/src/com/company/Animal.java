package com.company;

public abstract class Animal {

    private int runDistance;
    private double jumpHeight;
    private int swimDistance;

    public Animal(int _runDistance, double _jumpDistance, int _swimDistance)
    {
        runDistance = _runDistance;
        jumpHeight = _jumpDistance;
        swimDistance = _swimDistance;
    }

    public void run(int distance) {
        if(distance <= runDistance){
            System.out.println("run " + distance);
        }
        else{
            System.out.println("run " + runDistance);
            System.err.println("run still " + (distance-runDistance));
        }
    }

    public void swim(int distance){
        if(distance <= swimDistance){
            System.out.println("swim " + distance);
        }
        else{
            System.out.println("swim " + swimDistance);
            System.err.println("swim still " + (distance-swimDistance));
        }
    }

    public void jump(int height){
        if(height <= jumpHeight){
            System.out.println("jump " + height);
        }
        else{
            System.out.println("jump " + jumpHeight);
            System.err.println("jump still " + (height-jumpHeight));
        }
    }
}
