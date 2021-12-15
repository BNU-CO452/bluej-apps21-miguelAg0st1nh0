


public class Items
{
    String name;
    String description;
    int id;
    public Items(String name, String description, int id)
    {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    private void getShortDescription()
    {
        System.out.println(name);
    }

    private void getLongDescription()
    {
        System.out.println(name + description + id);
    }





}
