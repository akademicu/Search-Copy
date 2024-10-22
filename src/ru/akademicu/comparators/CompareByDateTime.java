package ru.akademicu.comparators;

import ru.akademicu.models.Appointment;
import java.time.LocalDateTime;
import java.util.Comparator;

public class CompareByDateTime implements Comparator<Appointment> {
    @Override
    public int compare(Appointment ap1, Appointment ap2) {
        LocalDateTime dateTimeOfAp1 = LocalDateTime.of(
                ap1.getDate().getYear(),
                ap1.getDate().getMonth(),
                ap1.getDate().getDay(),
                ap1.getTime().getHour(),
                ap1.getTime().getMinute());
        LocalDateTime dateTimeOfAp2 = LocalDateTime.of(
                ap2.getDate().getYear(),
                ap2.getDate().getMonth(),
                ap2.getDate().getDay(),
                ap2.getTime().getHour(),
                ap2.getTime().getMinute());
        return dateTimeOfAp1.compareTo(dateTimeOfAp2);
    }
}
