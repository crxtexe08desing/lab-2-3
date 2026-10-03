package grades;

import java.util.ArrayList;

public class gradeManager {

    private ArrayList<Double> grades;

    public gradeManager() {
        grades = new ArrayList<>();
    }

    public void addGrade(Double grade) {
        grades.add(grade);
    }

    public Double calculateAverage() {
        Double sum = 0.0;
        for (Double grade : grades) {
            sum += grade;
        }
        return grades.isEmpty() ? 0.0 : sum / grades.size();
    }

    public Integer countPassingGrades() {
        Integer count = 0;
        for (Double grade : grades) {
            if (grade >= 50.0) {
                count++;
            }
        }
        return count;
    }

    public int getGradesCount() {
        return grades.size();
    }

    public void printGrades() {
        if (grades.isEmpty()) {
            System.out.println("No hay notas registradas.");
            return;
        }
        for (int i = 0; i < grades.size(); i++) {
            System.out.println("  [" + i + "] " + grades.get(i));
        }
    }

    public boolean removeGradeByIndex(int index) {
        if (index >= 0 && index < grades.size()) {
            grades.remove(index);
            return true;
        }
        return false;
    }

    public boolean removeGradeByValue(Double value) {
        return grades.remove(value);
    }
}