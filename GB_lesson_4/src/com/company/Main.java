package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        //        4. Создать массив из 5 сотрудников:
        //        С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        Worker[] worker = new Worker[5];
        worker[0] = new Worker("Loktev K.A.", "intern", "lok@mail.ru", 105784, 4950, 20);
        worker[1] = new Worker("Kurlyk", "Engineer", "kur@mail.ru", 469194, 29000,42);
        worker[2] = new Worker("Mogningstar L.G.", "Satanis", "krouly@hell.com", 666777, 99000, 16000);
        worker[3] = new Worker("Mrgl M.M.", "Warlord", "agurhmgrl@grl.com", 000000, 999999, 27);
        worker[4] = new Worker("Undyne T.T.", "Hero", "krulod@bracadun.com", 969968, 4000, 300);
        for (Worker value : worker) {
            if (value.getAge() > 40) {
                value.showInfo();
                System.out.println();
            }
        }

        //        8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true);
        Animal dog = new Dog(false);
        Animal cat = new Cat(true);

        dog.jump(1);
        dog.run(500);
        dog.swim(5);

        cat.jump(1);
        cat.run(200);
        cat.swim(5);

    }
}
