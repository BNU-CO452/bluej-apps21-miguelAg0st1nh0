
/**
 * Write a description of class Module here.
 *
 * @author (Miguel Agostinho)
 * @version (05/10/1995)
 */
public class Module
{
    // instance variables - replace the example below with your own
    private String title;
    private String code;
    private int credit;
    public Lesson lesson;

    /**
     * Constructor for objects of class Module
     */
    
    public Module(String code, String title)
    {
        this.code = code;
        this.title = title;
        credit = 0;
    }
    
    public void assignLesson(Lesson lesson)
    {
        this.lesson = lesson;
    }
    
    public String getCode()
    {
        return this.code;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public int getModuleCredits()
    {
        
        return credit;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setCredits(int credit)
    { 
        this.credit = credit;
    }
    
    public void printModuleInfo()
    {
        System.out.println("Name: " + title);
        System.out.println("Code: " + code);
        System.out.println("Credits: " + credit);
    }
}
