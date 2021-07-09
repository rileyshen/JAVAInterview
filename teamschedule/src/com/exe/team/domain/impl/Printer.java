package com.exe.team.domain.impl;

import com.exe.team.domain.Equipment;

public class Printer implements Equipment {
    private String name;
    private String type;


    //原 忘了加空参构造器

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name +"(" + type + ")";
    }
}
