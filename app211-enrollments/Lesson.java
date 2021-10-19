
/**
 *  Each module has at least one lesson
 *  scheduled in a room with a tutor on
 *  a particular day and time
 *
 * @author Miguel Agostinho
 * @version 12/10/2021
 */
public class Lesson
{
    private String day;
    private String startTime;
    private String roomNumber;
    private String tutor;

    /**
     * Constructor for objects of module Lesson
     */
    public Lesson(String day, String startTime, String roomNumber, String tutor)
    {
        this.day = day;
        this.startTime = startTime;
        this.roomNumber = roomNumber;
        this.tutor = tutor;
    }
    
    public void printLessonInfo()
    {
        System.out.println("Lesson Info");
        System.out.println("===================");
        System.out.println("Lesson Day: " + day);
        System.out.println("Lesson Time: " + startTime);
        System.out.println("Lesson RoomNumber: " + roomNumber);
        System.out.println("Lesson Tutor: " + tutor);
    }

}
