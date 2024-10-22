package ru.akademicu.models;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time implements Cloneable {
    private int hour;
    private int minute;

    /**
     * constructor for current time
     */
    public Time() {
        LocalDateTime now = LocalDateTime.now();
        hour = now.getHour();
        minute = now.getMinute();
    }

    /**
     * constructor all params, if any param is not valid for time,
     * the time will set to -1:-1
     * @param hour
     * @param minute
     */
    public Time(int hour, int minute) {
        String regex = "([01]?[0-9]|2[0-3]):[0-5]?\\d";
        String t = hour + ":" + minute;
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(t);
        if (m.matches()) {
            this.hour = hour;
            this.minute = minute;
        }else {
            this.hour = -1;
            this.minute = -1;
        }
    }

//    public Time(Time time) {
//        this.hour = time.hour;
//        this.minute = time.minute;
//    }

    public int getHour() {
        return hour;
    }

    /**
     * setter for hour, set hour to valid time or to -1
     * @param hour
     */
    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            this.hour = -1;
        }else {
            this.hour = hour;
        }
    }

    public int getMinute() {
        return minute;
    }

    /**
     * setter for minutes, set minutes to valid minutes or to -1
     * @param minute
     */
    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            this.minute = -1;
        }else {
            this.minute = minute;
        }
    }

    @Override
    public String toString() {
        return "Time: "+hour + ":" + minute;
    }

    @Override
    public Object clone() {
        try {
            return  super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
