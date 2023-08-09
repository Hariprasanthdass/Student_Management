import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double tamilScore;
    int age;
    double englishScore;
    double mathScore;

    public Student(String name, int age, double tamilScore, double englishScore, double mathScore) {
        this.name = name;
        this.age = age;
        this.tamilScore = tamilScore;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age +
                ", Tamil Score: " + tamilScore +
                ", English Score: " + englishScore +
                ", Math Score: " + mathScore;
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        do {
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Add Scores");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    studentList.add(new Student(name, age, 0, 0, 0));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    if (studentList.isEmpty()) {
                        System.out.println("No students to display.");
                    } else {
                        System.out.println("List of students:");
                        for (Student student : studentList) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 3:
                    if (studentList.isEmpty()) {
                        System.out.println("No students to add scores to.");
                    } else {
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter student name: ");
                        String studentName = scanner.nextLine();
                        Student studentToUpdate = null;

                        for (Student student : studentList) {
                            if (student.name.equalsIgnoreCase(studentName)) {
                                studentToUpdate = student;
                                break;
                            }
                        }

                        if (studentToUpdate != null) {
                            System.out.print("Enter Tamil score: ");
                            double tamilScore = scanner.nextDouble();
                            System.out.print("Enter English score: ");
                            double englishScore = scanner.nextDouble();
                            System.out.print("Enter Math score: ");
                            double mathScore = scanner.nextDouble();

                            studentToUpdate.tamilScore = tamilScore;
                            studentToUpdate.englishScore = englishScore;
                            studentToUpdate.mathScore = mathScore;
                            System.out.println("Scores added for " + studentToUpdate.name);
                        } else {
                            System.out.println("Student not found.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (true); // Loop until explicitly exited
    }
}