import ru.akademicu.models.Appointment;
import ru.akademicu.models.Date;
import ru.akademicu.models.MeetingRoom;
import ru.akademicu.models.Time;

public class Test002 {
    public static void main(String[] args) {
        String name1 = "Ion";
        String purpose1 = "Because";
        Date date1 = new Date(2024,12,29);
        Time time1 = new Time(12,59);
        MeetingRoom room1 = new MeetingRoom("A3-04");

        System.out.println("\t***Arguments for appointment ap***");
        System.out.println("Name: "+ name1);
        System.out.println("Purpose: " + purpose1);
        System.out.println(date1);
        System.out.println(time1);
        System.out.println(room1);
        System.out.println();

        Appointment ap = new Appointment(name1, purpose1, date1, time1, room1);
        System.out.println("\t***Appointment ap***");
        System.out.println(ap);
        System.out.println();
        //deep copy of ap in pa1 and in ap3
        Appointment ap1 = (Appointment) ap.clone();
        Appointment ap2 = (Appointment) ap.clone();
        //all appointments have same date
        System.out.println("\t***Appointments date***");
        System.out.println("date  ap: " + ap.getDate());
        System.out.println("date ap1: " + ap1.getDate());
        System.out.println("date ap2: " + ap2.getDate());
        System.out.println();
        //change the date of appointment
        date1.setYear(2023);
        //the changes do not affect copy objects ap and ap1
        System.out.println("\t***Appointments date after changes***");
        System.out.println("date  ap: "+ap.getDate());
        System.out.println("date ap1: "+ap1.getDate());
        System.out.println("date ap2: "+ap2.getDate());
    }
}
