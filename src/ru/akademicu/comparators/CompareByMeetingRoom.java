package ru.akademicu.comparators;

import ru.akademicu.models.Appointment;

import java.util.Comparator;

public class CompareByMeetingRoom implements Comparator<Appointment> {
    @Override
    public int compare(Appointment ap1, Appointment ap2) {
        String room1ForCompare = changeRoomFormat(ap1.getRoom().getRoom());

        String room2ForCompare = changeRoomFormat(ap2.getRoom().getRoom());
        System.out.println(room2ForCompare);

        return room1ForCompare.compareTo(room2ForCompare);
    }
    private String changeRoomFormat(String str)
    {
        return str.substring(1,2)+str.substring(0,1)+str.substring(2);
    }
}
