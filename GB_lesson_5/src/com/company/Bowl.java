package com.company;

public class Bowl {

    private int volume;
    private int quantityFood;

    public Bowl(int _volume){
        volume = _volume;
        quantityFood = volume;
    }

    public void fillFood(){
        quantityFood = volume;
        System.out.println("Bowl was filled");
    }

    public void showQuantityFood(){
        System.out.println("Current quantity food: " + quantityFood);
    }

    //3. Метод из первого пункта ДЗ должен взаимодействовать с миской,
    // т.е., конкретный кот ест из конкретной миски, уменьшая объём еды в ней;
    public boolean isAte(int appetite){
        if(quantityFood < appetite){
            showQuantityFood();
            return false;
        }
        else{
            quantityFood -= appetite;
            showQuantityFood();
            if(quantityFood == 0){
                fillFood();
            }
            return true;
        }
    }
}
