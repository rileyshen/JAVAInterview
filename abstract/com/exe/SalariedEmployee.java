package com.exe;

/**
 * impl abstract earnings(), return monthlySalary
 * toString() return employee's name, number, birthday
 */
public class SalariedEmployee extends Employee{
    private double monthlySalary;

    public SalariedEmployee(String name, int number, MyData birthday) {
        super(name, number, birthday);
    }

    public SalariedEmployee(String name, int number, MyData birthday, int monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public double earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee[" + super.toString() + "]";
    }
}
