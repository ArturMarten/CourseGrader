import java.util.Arrays;

public class Student {
    private double [] scores = new double[5];
    private boolean [] classesAttended = new boolean[16];

    public Student() {
        Arrays.fill(classesAttended, true);
    }

    public double[] getScores() {
        return scores;
    }

    public void setScores(double[] scores) {
        this.scores = scores;
    }

    public boolean[] getClassesAttended() {
        return classesAttended;
    }

    public void setMissedClasses(int[] classesMissed) {
        for (int i = 0; i < classesMissed.length; i++) {
            classesAttended[classesMissed[i]] = false;
        }
    }
}