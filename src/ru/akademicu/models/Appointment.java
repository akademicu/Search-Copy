package ru.akademicu.models;

/**
 * @author Akade
 * Class Appointment for create and manipulate appointments
 */

public class Appointment implements Cloneable, Comparable<Appointment> {
    private String name;
    private String purpose;
    private Date date;
    private Time time;
    private MeetingRoom room;

    /**
     * constructor with current date and time only
     */
    public Appointment() {
        this.name = "";
        this.purpose = "";
        this.date = new Date();
        this.time = new Time();
        this.room = new MeetingRoom();
    }

    /**
     * all args constructor
     * @param name name of person for appointment
     * @param purpose purpose of appointment
     * @param date date of appointment
     * @param time time of appointment
     * @param room room of appointment
     */
    public Appointment(String name, String purpose, Date date, Time time, MeetingRoom room) {
        this.name = name;
        this.purpose = purpose;
        this.date = date;
        this.time = time;
        this.room = room;
    }
//    this is constructor for copy, but I didn't use it
//    public Appointment(Appointment a) {
//        this.name = a.name;
//        this.purpose = a.purpose;
//        this.date = new Date(a.date);
//        this.time = new Time(a.time);
//        this.room = new MeetingRoom(a.room);
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public MeetingRoom getRoom() {
        return room;
    }

    public void setRoom(MeetingRoom room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Appointment for " + name +
                "\tpurpose: " + purpose +
                "\t" + date +
                "\t" + time +
                "\troom: " + room;
    }

    @Override
    public Object clone() {
        try {
            //Shallow copy of object
            Appointment cloned = (Appointment) super.clone();
            //shallow copy of attributes not primitive
            cloned.date= (Date) date.clone();
            cloned.time = (Time) time.clone();
            cloned.room = (MeetingRoom) room.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public int compareTo(Appointment o) {
        return this.name.compareTo(o.name);
    }
}
