package ru.demanin.spring.FirstRestApp.util;

public class SensorErrorRespons{
     private String message;

    public SensorErrorRespons(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
