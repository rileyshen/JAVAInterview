package com.exe;

public class HourlyEmployee extends Employee{
    private int wage;
    public int hour;

    public HourlyEmployee(String name, int number, MyData birthday, int wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public HourlyEmployee(String name, int number, MyData birthday) {
        super(name, number, birthday);
    }

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee[" + super.toString() + "]";
    }
}
