package com.exe.team.domain;

public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // 忘了空参构造器

    public Employee() {
    }

    // set get方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // 实际开发中还要考虑toString方法


    public String getDetails() {
        return id + "\t" + name + " \t" + age + "\t" + salary;
    }
    // 这里名字有两字和三字，后面的“\t”用了 “ \t”空格，这样才能对齐

    @Override
    public String toString() {
        return getDetails();
    }
}
