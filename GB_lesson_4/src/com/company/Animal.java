package com.company;

public abstract class Animal {
    //        5. Создать классы Собака и Кот с наследованием от класса Животное;
    //        6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
    //        В качестве параметра каждому методу передается величина, означающая или длину препятствия
    //        (для бега и плавания), или высоту (для прыжков);
    abstract void run(int distance);
    abstract void swim(int distance);
    abstract void jump(int height);
}
