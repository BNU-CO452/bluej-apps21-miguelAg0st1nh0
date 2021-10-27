import java.util.ArrayList;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Miguel Agostinho
 * @version 27/10/2021
 */
public class Course
{
    public final static int MAXN_MODULES = 4;
    
    public ArrayList<Module> modules;
    
    private String code;
    private String title;
    
    private Grades finalGrade;
    
    /**
     * Hard code contructor to speed up precess;
     */
    
    public Course()
    {
        this("G400", "BSc Computing");
    }
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        
        modules  = new ArrayList<Module>();
        
        createModules();
    }

    /**
     * Create four modules and add them to the
     * modules list for testing purposes.  These
     * must be your four modules.
     * Hard code to speed up precess.
     */
    public void createModules()
    {   
        Module co452 = new Module("CO452", "Programming Concepts ");
        Module co461 = new Module("CO461", "3D Modelling         ");
        Module co459 = new Module("CO459", "Game Design          ");
        Module co450 = new Module("CO450", "Computer Architecture");
        addModule(co452);
        addModule(co461);
        addModule(co459);
        addModule(co450);
    }
    
    public void addModule(Module module)
    {
        if(modules.size() < MAXN_MODULES)
        {
            modules.add(module);
        }
    }
    
    /**
     * Conditional selection to return grades according to its mark.
     */
    public Grades convertToGrade(int mark)
    {
        if(mark >= 0 && mark < 39)
        {
            return Grades.F;
        }
        else if(mark >= 40 && mark < 49)
        {
            return Grades.D;
        }
        else if(mark >= 50 && mark < 59)
        {
            return Grades.C;
        }
        else if(mark >= 60 && mark <= 69)
        {
            return Grades.B;
        }
        else if(mark >= 70 && mark <= 100)
        {
            return Grades.A;
        }
        else
        {
            return Grades.NS;
        }
        
    }
    
    /**
     * Calculate the average mark from the four module marks
     * and convert that into a final grade.
     */
    public Grades calculateGrade(ArrayList<ModuleMark> marks)
    {
        int total = 0;
        int finalMark = 0;
        
        for(ModuleMark mark: marks)
        {
            total = total + mark.getValue();
        }
        
        finalMark = total / MAXN_MODULES;
        finalGrade = convertToGrade(finalMark);
        return finalGrade;
    }
    
    /**
     * Prints out the details of a course and the
     * four modules
     */
    public void print()
    {
        System.out.println();
        System.out.println(" Course " + code + ": " + title);        
    }
    
   
    
}
