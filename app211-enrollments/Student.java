/**
 * The Student class contains essential information that identifies 
 * a student at BNU.  The class also contains information 
 * concerning the course the student is currently enrolled on
 * 
 * @author Michael Kölling and David Barnes
 * @modified by Miguel Agostinho
 * @version 07/10/2021
 */
public class Student
{
    // A unique 8 digit BNU identifier
    private int id;
    // the student's full name
    private String name;
    // The course the student is enrolled on
    private Course course;
    
    private int age;
    
    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String name, int id, int age)
    {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    /**
     * Return the full name of this student.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Return Student's Age.
     */
    
    public int getAge()
    {
        return age;
    }
    
     /**
     * Return the student ID of this student.
     */
    public int getID()
    {
        return id;
    }

    public void enrol(Course course)
    {
        this.course = course;
    }
    
    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println(" Student ID: " + id + " Name: " + name + " Age: " + age);
    }
    
    public void printCourse()
    {
        course.print();
    }
}
