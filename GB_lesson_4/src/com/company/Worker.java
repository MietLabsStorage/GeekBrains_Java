package com.company;

public class Worker {
    //        task 1.
    //        Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;
    private String fio;
    private String post;
    private String email;
    private int telephone;
    private int wage;
    private int age;

    //        2. Конструктор класса должен заполнять эти поля при создании объекта;
    public Worker(String _fio, String _post, String _email, int _telephone, int _wage, int _age) throws Exception {
        this.fio = _fio;
        this.post = _post;
        this.email = _email;
        if(_telephone >= 0)
            this.telephone = _telephone;
        else
            throw new Exception("telephone can\'t be negative");
        if(_wage >= 0)
            this.wage = _wage;
        else
            throw new Exception("wage can\'t be negative");
        if(_age >= 0)
            this.age = _age;
        else
            throw new Exception("age can\'t be negative");
    }
    //        3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    public void showInfo(){
        System.out.println("FIO:       " + fio);
        System.out.println("Post:      " + post);
        System.out.println("Email:     " + email);
        System.out.println("Telephone: " + telephone);
        System.out.println("Wage:      " + wage);
        System.out.println("Age:       " + age);
    }

    public int getAge() {
        return age;
    }
}
