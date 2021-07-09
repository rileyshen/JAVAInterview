package com.exe;

import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);;
        System.out.println("please enter current money");
        int month = scanner.nextInt();

        Employee[] employees = new Employee[2];
        employees[0] = new SalariedEmployee("aa", 1001, new MyData(1999, 01, 01), 20000);
        employees[1] = new HourlyEmployee("bb", 2001, new MyData(1995, 02, 012), 70, 200);

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
            double salary = employees[i].earnings();
            System.out.println("salary: " + salary);

            if (month == employees[i].getBirthday().getMonth()) {
                System.out.println("happy birthday day");
            }
        }
    }

}
