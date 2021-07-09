package com.exe.team.domain.impl;

import com.exe.team.domain.Equipment;

public class PC implements Equipment {

    private String model;
    private String display;

    //原 忘了加空参构造器
    public PC() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    @Override
    public String getDescription() {
//     原 我用了getModel，其实只需要model就可以   return "model: " + getModel() + "display: " + getDisplay();
        return model +"(" + display + ")";
    }
}
