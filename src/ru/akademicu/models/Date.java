package ru.akademicu.models;

import java.time.LocalDate;

public class Date implements Cloneable {
    private int year;
    private int month;
    private int day;

    /**
     *constructor for current dated
     */
    public Date() {
        LocalDate localDate = LocalDate.now();
        this.year = localDate.getYear();
        this.month = localDate.getMonthValue();
        this.day = localDate.getDayOfMonth();
    }

    /**
     * all arg constructor, works only for valid parameters
     * if any param is not valid everything will be set to -1
     * @param year
     * @param month
     * @param day
     */
    public Date(int year, int month, int day) {
        try {
            LocalDate localDate = LocalDate.of(year, month, day);
            this.year = year;
            this.month = month;
            this.day = day;
        }catch (Exception e){
            this.year = -1;
            this.month = -1;
            this.day = -1;
        }
    }

    /**
     * constructor for copy
     * @param date object of type Dte which is coped
     */
//    public Date(Date date) {
//        this.year = date.getYear();
//        this.month = date.getMonth();
//        this.day = date.getDay();
//    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Date: " + year + "/" + month + "/" + day;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
