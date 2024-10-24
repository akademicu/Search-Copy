import ru.akademicu.comparators.CompareByDateTime;
import ru.akademicu.comparators.CompareByMeetingRoom;
import ru.akademicu.generator.ArrayCollectionGenerator;
import ru.akademicu.models.Appointment;
import ru.akademicu.models.Date;
import ru.akademicu.models.MeetingRoom;
import ru.akademicu.models.Time;

import java.util.*;

/**
 * class Test003 to test sorting and searching
 */
public class Test003 {
    /**
     * drive method
     * @param args arguments given to the method
     */
    public static void main(String[] args) {
        ArrayCollectionGenerator arrayCollectionGenerator = new ArrayCollectionGenerator();
        ArrayList<Appointment> apArrayList = arrayCollectionGenerator.getAppointmentsList();
        Appointment[] apArray = arrayCollectionGenerator.getAppointments();
        Appointment searchAppointment = new Appointment("Ion", "Java",
                new Date(1983,2,5),
                new Time(5,25),
                new MeetingRoom("C2-22"));
        apArrayList.add(searchAppointment);
        Appointment searchAppointmentClone = (Appointment) searchAppointment.clone();
        //insert in array the appointment for which will search on the last index
        apArray[10] =  searchAppointmentClone;

        //sorting of Array apArray
        Arrays.sort(apArray, new CompareByDateTime());



        //Display of initial ArrayList
        System.out.println("\n\t***Not sorted ArrayList***");
        printList(apArrayList);

        System.out.println();
        //duration2 variable which holds search time in searching in not sorting collection
        long duration2 = findObjectInNonSortedArray(apArrayList,searchAppointmentClone);
        System.out.println("nanoseconds in not sorted ArrayList: "+duration2);
        System.out.println();

        //Sorting by date and time the Appointments from ArrayList
        apArrayList.sort(new CompareByDateTime());

        //duration variable which holds search time in sorting collection
        long duration = findObjectInSortedArray(apArrayList,searchAppointment);
        System.out.println("nanoseconds in sorted ArrayList: "+duration);
        System.out.println();

        long duration3 = findObjectInSortedArrayArray(apArray,searchAppointmentClone);
        System.out.println("nanoseconds in sorted Array: "+duration3);


        //display of sorting ArrayList
        System.out.println("\n\t***Sorted ArrayList***");
        printList(apArrayList);
        System.out.println();

        //sorting Array by name using Comparable interface
//        System.out.println("***Sorted Array by name***");
//        Arrays.sort(apArray,0, 9);
//        //display the sorted array
//        for (int i = 0; i < 9; i++) {
//            System.out.println(apArray[i]);
//        }
    }

    /**
     * method to check time of founded object in sorted ArrayList
     * @param apArrayList given array list
     * @param ap searched object(Appointment)
     * @return long value of time in nanoseconds from start to the end of the method
     */
    public static long findObjectInSortedArray(ArrayList<Appointment> apArrayList, Appointment ap) {
        long startTime = System.nanoTime();
        int rez = Collections.binarySearch(apArrayList,ap,new CompareByDateTime());
        if (rez >= 0) {
            System.out.println("Ap. for "+ap.getName()+" is at index "+rez);
        }
        else {
            System.out.println("Ap for "+ ap.getName()+" not founded in ArrayList");
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     *
     * @param apArray
     * @param ap
     * @return
     */
    public static long findObjectInSortedArrayArray(Appointment[] apArray, Appointment ap) {
        long startTime = System.nanoTime();
        int rez = Arrays.binarySearch(apArray,ap,new CompareByDateTime());
        if (rez >= 0) {
            System.out.println("Ap. for "+ap.getName()+" is at index "+rez);
        }
        else {
            System.out.println("Ap for "+ ap.getName()+" not founded in Array");
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * method to check time of founded object in not sorted ArrayList
     * @param apArrayList given array list
     * @param ap searched object(Appointment)
     * @return long value of time in nanoseconds from start to the end of the method
     */
    public static long findObjectInNonSortedArray(ArrayList<Appointment> apArrayList, Appointment ap) {
        long startTime = System.nanoTime();
        int rez = 0;
        CompareByDateTime compareByDateTime = new CompareByDateTime();
        for (Appointment a : apArrayList) {
            if(compareByDateTime.compare(a,ap) == 0) {
                break;
            }
            rez++;
        }
        if (rez >= 0) {
            System.out.println("Ap for "+ap.getName()+" is at index "+rez);
        }
        else {

            System.out.println("Ap for "+ ap.getName()+" not founded in ArrayList");
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * method to print an ArrayList of Appointments
     * @param appointments ArrayList of appointments
     */
    public static void printList(ArrayList<Appointment> appointments){
        for (Appointment ap : appointments) {
            System.out.println(ap);
        }
    }


}
