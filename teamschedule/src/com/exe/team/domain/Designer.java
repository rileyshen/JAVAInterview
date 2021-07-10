package com.exe.team.domain;

import com.exe.team.domain.Employee;

public class Designer extends Programmer {

    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    @Override
    public String toString() {
//        return getDetails() + "\t架构师 \t" + getStatus() + "\t" + getBonus() + " \t" + stock + " \t" + getEquipment().getDescription();
        return getDetails() + "\t设计师 \t" + getStatus() + "\t" + bonus + " \t\t\t\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t\t设计师" + "\t\t" + bonus;
    }
}
