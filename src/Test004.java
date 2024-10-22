import ru.akademicu.comparators.CompareByMeetingRoom;
import ru.akademicu.generator.ArrayCollectionGenerator;
import ru.akademicu.models.Appointment;
import ru.akademicu.models.Date;
import ru.akademicu.models.MeetingRoom;
import ru.akademicu.models.Time;

import java.util.ArrayList;

/**
 * class Test004 for testing sorting by MeetingRoom
 * @author Akade
 */
public class Test004 {
    /**
     * drive method
     * @param args arguments given to the method
     */
    public static void main(String[] args) {

        ArrayCollectionGenerator aCG = new ArrayCollectionGenerator();
        ArrayList<Appointment> appointmentsList = aCG.getAppointmentsList();
        Appointment[] apArray = aCG.getAppointments();
        Appointment searchAppointment = new Appointment("Ion2", "Java2",
                new Date(1983,2,5),
                new Time(5,25),
                new MeetingRoom("C2-22"));
        appointmentsList.add(searchAppointment);

        //Display of initial ArrayList
        System.out.println("\n\t***Not sorted ArrayList***");
        Test003.printList(appointmentsList);
        System.out.println();

        //display og sorted Arraylist by MeetingRoom
        System.out.println("\n\t***Sorted ArrayList***");
        appointmentsList.sort(new CompareByMeetingRoom());
        Test003.printList(appointmentsList);
    }
}