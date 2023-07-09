import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Gradebook {
    private Map<String, List<Double>> gradebook;

    public Gradebook() {
        gradebook = new HashMap<>();
    }
    public void addStudent(String studentName) {
        gradebook.put(studentName, new ArrayList<>());
    }
    public void addGrade(String studentName, double grade) {
        if (gradebook.containsKey(studentName)) {
            gradebook.get(studentName).add(grade);
        } else {
            System.out.println("Student not found!");
        }
    }
    public double calculateAverage(String studentName) {
        if (gradebook.containsKey(studentName)) {
            List<Double> grades = gradebook.get(studentName);
            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            return sum / grades.size();
        } else {
            System.out.println("Student not found!");
            return 0;
        }
    }
    public void displaySummary(String studentName) {
        if (gradebook.containsKey(studentName)) {
            System.out.println("Summary for " + studentName + ":");
            List<Double> grades = gradebook.get(studentName);
            System.out.println("Grades: " + grades);
            System.out.println("Average: " + calculateAverage(studentName));
        } else {
            System.out.println("Student not found!");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gradebook gradebook = new Gradebook();
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String studentName = scanner.nextLine();
            gradebook.addStudent(studentName);
        }
        System.out.println("Enter grades for each student:");
        for (String student : gradebook.gradebook.keySet()) {
            System.out.println("Enter grades for " + student + ":");
            for (int i = 1; i <= numStudents; i++) {
                System.out.print("Enter grade " + i + ": ");
                double grade = scanner.nextDouble();
                gradebook.addGrade(student, grade);
            }
            scanner.nextLine();
        }
        System.out.println("Enter the name of the student to display the summary (or type 'exit' to quit):");
        String studentName = scanner.nextLine();
        while (!studentName.equals("exit")) {
            gradebook.displaySummary(studentName);
            System.out.println("Enter the name of the student to display the summary (or type 'exit' to quit):");
            studentName = scanner.nextLine();
        }
        scanner.close();
    }
}
