package com.pendext.circuit.service.transfer;

import org.springframework.boot.json.BasicJsonParser;

import java.util.Map;

public class LocalDateTimeJson {
    private String month;
    private String dayOfMonth;
    private String year;
    private String hour;
    private String minute;
    private String second;

    public LocalDateTimeJson(String json) {
        Map<String, Object> objectMap = new BasicJsonParser().parseMap(json);
        this.setMonth((String )objectMap.get("month"));
        this.setDayOfMonth(String.format("%02d", (Long) objectMap.get("dayOfMonth")));
        this.setYear(String.format("%02d", (Long) objectMap.get("year")));
        this.setHour(String.format("%02d", ((Long) objectMap.get("hour"))));
        this.setMinute(String.format("%02d", ((Long) objectMap.get("minute"))));
        this.setSecond((String.format("%02d", (Long) objectMap.get("second"))));
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}
