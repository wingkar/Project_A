package com.example.project_a;

public class EventDTO {
    String event1;
    String event2;
    String date;
    int resId;

    public EventDTO(String event1, String event2, String date, int resId) {
        this.event1 = event1;
        this.event2 = event2;
        this.date = date;
        this.resId = resId;
    }

    public String getEvent1() {
        return event1;
    }

    public void setEvent1(String event1) {
        this.event1 = event1;
    }

    public String getEvent2() {
        return event2;
    }

    public void setEvent2(String event2) {
        this.event2 = event2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
