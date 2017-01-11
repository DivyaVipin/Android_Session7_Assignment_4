package assignment.android.acadglid.DataObject;

/**
 * Created by DivyaVipin on 1/10/2017.
 */

public class Person {
    public Person()
    {

    }
    private String first_name;

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    private String last_name;
    private int id;
    public Person(String first_name, String last_name, int id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.id = id;
    }


}
