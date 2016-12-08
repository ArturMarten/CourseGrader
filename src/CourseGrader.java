import java.util.HashMap;

public class CourseGrader {
    public HashMap<Student, String> calculateGrades(Course course) {
        if (course.getStudents().isEmpty()) {
            return new HashMap<>();
        }
        else {
            HashMap<Student, String> studentGrades = new HashMap <>();
            for (Student student : course.getStudents()){
                String initialGrade = "F";
                double[] scores = student.getScores();
                double firstThreeAndExamTotalScore = 0;
                for(int i = 0; i < scores.length; i++) {
                    if (i != 3) {
                        firstThreeAndExamTotalScore += scores[i];
                    }
                }

                double firstThreeAndExamAverageScore = firstThreeAndExamTotalScore/4;
                if (firstThreeAndExamAverageScore >= 90) {
                    initialGrade = "A";
                }
                else if (firstThreeAndExamAverageScore >= 80) {
                    initialGrade = "B";
                }
                else if (firstThreeAndExamAverageScore >= 70) {
                    initialGrade = "C";
                }
                else if (firstThreeAndExamAverageScore >= 60) {
                    initialGrade = "D";
                }

                double fourthScore = 0;
                for(int i = 0; i < scores.length; i++) {
                    if (i == 3) {
                        fourthScore = scores[i];
                    }
                }

                if (fourthScore < 70.0) {
                    initialGrade = lowerGrade(initialGrade);
                }

                int classesMissed = 0;
                boolean[] classesAttended = student.getClassesAttended();
                for (int i = 0; i < classesAttended.length; i++) {
                    if (classesAttended[i] == false){
                        classesMissed++;
                    }
                }

                String finalGrade = initialGrade;
                if (classesMissed >= 3) {
                    finalGrade = lowerGrade(finalGrade);
                }

                studentGrades.put(student, finalGrade);
            }
            return studentGrades;
        }
    }

    private String lowerGrade(String initialGrade) {
        switch (initialGrade) {
            case "A":
                return "B";
            case "B":
                return "C";
            case "C":
                return "D";
            case "D":
                return "E";
            default:
                return "F";
        }
    }
}