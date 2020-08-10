package com.company;

import java.util.Random;

public class Cat extends Animal{

    private int appetite;
    private boolean satiety;

    public Cat(Random rndGenerator){
        super(rndGenerator.nextInt(500), rndGenerator.nextInt(30) /10.0, 0);
        appetite = rndGenerator.nextInt(200);
        satiety = false;
    }

    public Cat(int _appetite){
        super(200, 2, 0);
        appetite = _appetite;
        satiety = false;
    }

    @Override
    public void run(int distance){
        System.out.print("Cat:: ");
        super.run(distance);
    }

    @Override
    public void swim(int distance){
        System.out.println("Cat:: can't swim");
    }

    @Override
    public void jump(int height){
        System.out.print("Cat:: ");
        super.jump(height);
    }

    public void eat(Bowl bowl){
        satiety = bowl.isAte(appetite);
        isSatiety();
    }

    private void isSatiety(){
        System.out.println("Cat's satiety: " + satiety);
    }
}
