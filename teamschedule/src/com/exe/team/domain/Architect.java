package com.exe.team.domain;

import com.exe.team.domain.Employee;

public class Architect extends Designer {

    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师 \t" + getStatus() + "\t" + getBonus() + " \t" + stock + " \t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t\t架构师" + "\t\t" + getBonus() + "\t\t\t" + stock;
    }
}
