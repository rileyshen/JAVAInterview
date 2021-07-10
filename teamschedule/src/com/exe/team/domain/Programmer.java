package com.exe.team.domain;

import com.exe.team.domain.Employee;
import com.exe.team.domain.Equipment;
import com.exe.team.service.Status;

import static com.exe.team.service.Status.FREE;

public class Programmer extends Employee {

    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    // 忘了空参

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员 \t" + status + "\t\t\t\t\t\t" + equipment.getDescription();
    }
}