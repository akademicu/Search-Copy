import ru.akademicu.models.Appointment;
import ru.akademicu.models.Date;
import ru.akademicu.models.MeetingRoom;
import ru.akademicu.models.Time;

/**
 * @author Akade
 * this is class to test shallow copy, but at the testing moment will work as deep copy
 * screenshot of shallow copy have been atached in report
 */
public class Test001 {
    public static void main(String[] args) {
        String name1 = "Ion";
        String purpose1 = "Because";
        Date date1 = new Date(2003,2,29);
        Time time1 = new Time(12,60);
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
        //shallow copy of ap in pa1
        Appointment ap1 = ap;
        //Both appointments have same date
        System.out.println("\t***Appointments date***");
        System.out.println("date  ap: " + ap.getDate());
        System.out.println("date ap1: " + ap1.getDate());
        System.out.println();
        //change the date of appointment
        date1.setYear(2023);
        //the changes are visible in both appointments ap and ap1
        System.out.println("\t***Appointments date after changes***");
        System.out.println("date  ap: "+ap.getDate());
        System.out.println("date ap1: "+ap1.getDate());
    }
}
