import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        String id = sc.nextLine();
    
                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();
    
                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();
    
                        students.add(new Student(id, name, marks));
    
                        System.out.println("Student added successfully!");
                        break;
                    case 2:
                        if (students.isEmpty()) {
                            System.out.println("No student records available.");
                        } else {
                            System.out.println("\nStudent Records:");
                            for (Student student : students) {
                                student.displayStudent();
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter Student ID to search: ");
                        String searchId = sc.nextLine();
    
                        boolean found = false;
    
                        for (Student student : students) {
                            if (student.getStudentId().equals(searchId)) {
                                System.out.println("\nStudent Found:");
                                student.displayStudent();
                                found = true;
                                break;
                            }
                        }
    
                        if (!found) {
                            System.out.println("Student not found.");
                        }
                        break;
    
                    case 4:
                        if (students.isEmpty()) {
                            System.out.println("No student records available.");
                        } else {
                            double total = 0;
    
                            for (Student student : students) {
                                total += student.getMarks();
                            }
    
                            double average = total / students.size();
    
                            System.out.println("Average Marks:"+average);
                        }
                        break;
    
                    case 5:
                        System.out.println("Exiting.....");
                        break;
                    
                    default:
                        System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
