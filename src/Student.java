import java.io.Serializable;

public class Student implements Serializable {
    private int roll;
    private float marks;
    private String name;
    private String hobbies;

    public Student(int roll, float marks, String name, String hobbies) {
        this.roll = roll;
        this.marks = marks;
        this.name = name;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", marks=" + marks +
                ", name='" + name + '\'' +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}
