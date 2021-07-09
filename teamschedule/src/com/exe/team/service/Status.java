package com.exe.team.service;

public class Status {
//final后不能用空参的
    private final String NAME;

    private Status(String name) {
        this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status VOCATION = new Status("VOCATIO");
    public static final Status BUSY = new Status("BUSY");


    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
