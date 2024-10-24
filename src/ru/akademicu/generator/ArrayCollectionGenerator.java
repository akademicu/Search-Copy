package ru.akademicu.generator;

import ru.akademicu.models.Appointment;
import ru.akademicu.models.Date;
import ru.akademicu.models.MeetingRoom;
import ru.akademicu.models.Time;

import java.util.ArrayList;
import java.util.Random;

public class ArrayCollectionGenerator {
    private final Appointment[] appointments = new Appointment[11];
    private final ArrayList<Appointment> appointmentsList = new ArrayList<>();
    private final Random rand = new Random();

    public ArrayCollectionGenerator() {
        for (int i = 0; i < 10; i++) {
            String name = "Name" + rand.nextInt(100);
            String purpose = "Purpose" + rand.nextInt(100);
            Date date = new Date(rand.nextInt(75)+1950,rand.nextInt(11)+1,rand.nextInt(29)+1);
            Time time = new Time(rand.nextInt(24), rand.nextInt(60));
            MeetingRoom roomX =new MeetingRoom(randomRoom(rand));
            this.appointmentsList.add(new Appointment(name,purpose,date,time,roomX));
            appointments[i] = new Appointment(name,purpose,date,time,roomX);
        }
    }
    public static String randomRoom(Random r){
        StringBuilder sb = new StringBuilder();
        sb.append((char) (r.nextInt(26)+'A'));
        sb.append(r.nextInt(8)+1);
        sb.append('-');
        int nr = r.nextInt(98)+1;
        if(nr<10){
            sb.append('0');
        }
        sb.append(nr);
        return sb.toString();
    }

    public Appointment[] getAppointments() {
        return appointments;
    }

    public ArrayList<Appointment> getAppointmentsList() {
        return appointmentsList;
    }
}
