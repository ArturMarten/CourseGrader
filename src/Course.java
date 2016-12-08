import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent (Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}