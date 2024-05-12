package com.york.pattern.responsibility;

public class LeaveRequest {

    private String name;

    private int days;

    private String reason;

    public LeaveRequest(String name, int days, String reason) {
        this.name = name;
        this.days = days;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    public String getReason() {
        return reason;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

