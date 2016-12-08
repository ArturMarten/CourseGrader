import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class CourseGraderTest {
    private CourseGrader courseGrader;
    private Course course;
    private Student student;

    @Before
    public void setUp() throws Exception {
        courseGrader = new CourseGrader();
        course = new Course("A course");
        student = new Student();
    }
    @Test
    public void calculateGradesForEmptyCourse() {
        course = new Course("Empty course");
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals(new HashMap<Student, String>(), studentGrades);
    }

    @Test
    public void calculateGradesForNonEmptyCourseWithOneStudent() {
        course = new Course("Non-empty course");
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals(1, studentGrades.size());
    }

    @Test
    public void calculateGradesForNonEmptyCourseWithTwoStudents() {
        course = new Course("Non-empty course");
        Student student1 = new Student();
        course.addStudent(student1);
        Student student2 = new Student();
        course.addStudent(student2);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals(2, studentGrades.size());
    }

    @Test
    public void calculateGradeForStudentWithAllZeros() {
        double[] scores = new double[] {0.0, 0.0, 0.0, 0.0, 0.0};
        student.setScores(scores);
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("F", studentGrades.get(student));
    }
    @Test
    public void calculateGradeForStudentWithAverageOf90InFirstThreeAndExam() {
        double[] scores = new double[] {90.0, 90.0, 90.0, 70.0, 90.0};
        student.setScores(scores);
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("A", studentGrades.get(student));
    }

    @Test
    public void calculateGradeForStudentWithAverageOf80InFirstThreeAndExam() {
        double[] scores = new double[] {80.0, 80.0, 80.0, 70.0, 80.0};
        student.setScores(scores);
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("B", studentGrades.get(student));
    }
    @Test
    public void calculateGradeForStudentWithAverageOf70InFirstThreeAndExam() {
        double[] scores = new double[] {70.0, 70.0, 70.0, 70.0, 70.0};
        student.setScores(scores);
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("C", studentGrades.get(student));
    }
    @Test
    public void calculateGradeForStudentWithAverageOf60InFirstThreeAndExam() {
        double[] scores = new double[] {60.0, 60.0, 60.0, 70.0, 60.0};
        student.setScores(scores);
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("D", studentGrades.get(student));
    }
    @Test
    public void calculateGradeForStudentWithAAndAverageOf60InFourth() {
        double[] scores = new double[] {90.0, 90.0, 90.0, 60.0, 90.0};
        student.setScores(scores);
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("B", studentGrades.get(student));
    }
    @Test
    public void calculateGradeForStudentWithBAndAverageOf60InFourth() {
        double[] scores = new double[] {80.0, 80.0, 80.0, 60.0, 80.0};
        student.setScores(scores);
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("C", studentGrades.get(student));
    }
    @Test
    public void calculateGradeForStudentWithCAndAverageOf60InFourth() {
        double[] scores = new double[] {70.0, 70.0, 70.0, 60.0, 70.0};
        student.setScores(scores);
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("D", studentGrades.get(student));
    }
    @Test
    public void calculateGradeForStudentWithAverageOf60InEverything() {
        double[] scores = new double[] {60.0, 60.0, 60.0, 60.0, 60.0};
        student.setScores(scores);
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("E", studentGrades.get(student));
    }
    @Test
    public void calculateGradeForStudentWithAAnd3ClassesMissed() {
        double[] scores = new double[] {90.0, 90.0, 90.0, 70.0, 90.0};
        student.setScores(scores);
        student.setMissedClasses(new int[]{0,5,15});
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("B", studentGrades.get(student));
    }
    @Test
    public void calculateGradeForStudentWithBAnd3ClassesMissed() {
        double[] scores = new double[] {80.0, 80.0, 80.0, 70.0, 80.0};
        student.setScores(scores);
        student.setMissedClasses(new int[]{0,5,15});
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("C", studentGrades.get(student));
    }
    @Test
    public void calculateGradeForStudentWithCAnd3ClassesMissed() {
        double[] scores = new double[] {70.0, 70.0, 70.0, 70.0, 70.0};
        student.setScores(scores);
        student.setMissedClasses(new int[]{0,5,15});
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("D", studentGrades.get(student));
    }
    @Test
    public void calculateGradeForStudentWithDAnd3ClassesMissed() {
        double[] scores = new double[] {60.0, 60.0, 60.0, 70.0, 60.0};
        student.setScores(scores);
        student.setMissedClasses(new int[]{0,5,15});
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("E", studentGrades.get(student));
    }
    @Test
    public void calculateGradeForStudentWithEAnd3ClassesMissed() {
        double[] scores = new double[] {60.0, 60.0, 60.0, 60.0, 60.0};
        student.setScores(scores);
        student.setMissedClasses(new int[]{0,5,15});
        course.addStudent(student);
        HashMap<Student,String> studentGrades = courseGrader.calculateGrades(course);
        assertEquals("F", studentGrades.get(student));
    }
    @After
    public void tearDown() throws Exception {}
}