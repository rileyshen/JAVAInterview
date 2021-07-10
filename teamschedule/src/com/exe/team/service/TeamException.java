package com.exe.team.service;

/**
 * @Description 自定义异常类
 */
public class TeamException extends Exception {
    static final long serialversionUID = -3387514229948l;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
