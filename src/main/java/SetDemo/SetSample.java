package SetDemo;

/**
 * @author Xiaoyu Cheng
 * @student_ID 40254110
 * @description
 */
public class SetSample implements Element{
    int id;
    String name;

    public SetSample(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Element ID is " + getId() + ", and element name is: " + getName();
    }
}