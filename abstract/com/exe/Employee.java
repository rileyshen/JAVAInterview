package com.exe;

public abstract class Employee {
    private String name;
    private int number;
    private MyData birthday;

    public Employee(String name, int number, MyData birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyData getBirthday() {
        return birthday;
    }

    public void setBirthday(MyData birthday) {
        this.birthday = birthday;
    }

    public abstract double earnings();

    @Override
    public String toString() {
        return "name=" + name + ", number=" + number + ", birthday=" + birthday.toDataString();
    }
}
