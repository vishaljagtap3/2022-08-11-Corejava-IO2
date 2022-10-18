import java.io.*;

public class Student implements Serializable {

    private int roll;
    private float marks;
    private String name;
    private String hobbies;
    private String email;

    public static final int serialVersionUID = 1018090901;

    public Student(int roll, float marks, String name, String hobbies) {
        this.roll = roll;
        this.marks = marks;
        this.name = name;
        this.hobbies = hobbies;
        email = "info@bitcode.in";
    }

   public Student(int roll, float marks, String name, String hobbies, String email) {
       this.roll = roll;
       this.marks = marks;
       this.name = name;
       this.hobbies = hobbies;
       this.email = email;
   }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", marks=" + marks +
                ", name='" + name + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", email='" + email + '\'' +
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
