package ru.akademicu.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MeetingRoom implements Cloneable {
    private String room;

    public MeetingRoom() {
        this.room = "";
    }

    /**
     * constructor all params
     * if param doesn't match right format (e.g., B1-03 or C2-08 or T4-34)
     * the room will be set to "-1"
     * @param room
     */
    public MeetingRoom(String room) {
        String regex = "([A-Z]\\d)-([0-9]{2})";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(room);
        if(m.matches()){
            this.room = room;
        }else {
            this.room = "-1";
        }
    }

//    public MeetingRoom(MeetingRoom meetingRoom) {
//        this.room = meetingRoom.room;
//    }

    public String getRoom() {
        return room;
    }

    /**
     * setter to set the right value to room or "-1"
     * @param room
     */
    public void setRoom(String room) {
        String regex = "([A-Z]\\d)-([0-9]{2})";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(room);
        if(m.matches()){
            this.room = room;
        }else {
            this.room = "-1";
        }
    }

    @Override
    public String toString() {
        return "MeetingRoom: " + room;
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
