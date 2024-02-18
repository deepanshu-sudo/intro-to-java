import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    //declaring data members
    private int studentId;
    private String studentName;
    private String course;
    private Double sgpa;
    private String email;

    // Constructor for the Student class
    public Student(int studentId, String studentName, String course, Double sgpa, String email) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.sgpa = sgpa;
        this.email = email;
    }

    // Getter for Student ID (Required for findStudentIndex method in StudentRegistration Class)
    public int getStudentId() {
        return this.studentId;
    }

    // Print Student
    @Override
    public String toString() {
        return String.format("%-10d %-20s %-10s %-5.2f %-20s", studentId, studentName, course, sgpa, email);
    }
}

class StudentRegistration {
    private ArrayList<Student> students = new ArrayList<Student>();

    // Registration Method
    public void register() {
        System.out.print("\nHow many students do you want to add? ");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for(int i = 0; i < count; i++) {
            System.out.println("Enter Student #"+(i+1)+" details. \n");
            System.out.print("Enter Student ID: ");
            int studentId = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Enter Student Name: ");
            String studentName = sc.nextLine();
            
            System.out.print("Enter Student Course: ");
            String course = sc.nextLine();
            
            System.out.print("Enter Student SGPA for current Semester: ");
            double sgpa = sc.nextDouble();
            sc.nextLine();
            
            System.out.print("Enter Student Email: ");
            String email = sc.nextLine();

            System.out.println();

            Student student = new Student(studentId, studentName, course, sgpa, email);
            students.add(student);
        }
        System.out.println(count+" students added.");
    }

    // De-Registration Method
    public void deRegisration() {
        System.out.print("Enter Student ID to De-Register: ");
        Scanner sc = new Scanner(System.in);
        int studentIdToRemove = sc.nextInt();
        
        if(findStudentIndex(studentIdToRemove) == -1) {
            System.out.println("\nStudent ID not found. Enter correct Student ID.");
            return;
        }

        System.out.print("Are you sure you want to remove the student with id "+studentIdToRemove+" (y or n)? ");
        char confirm = sc.next().charAt(0);
        if(confirm == 'y' || confirm == 'Y') {
            students.remove(findStudentIndex(studentIdToRemove));
            System.out.println("Student with id "+studentIdToRemove+" removed.");
        }
        return;
    }

    // View & Print Method
    public void view() {
        System.out.print("Enter Student ID to View: ");
        Scanner sc = new Scanner(System.in);
        int studentIdToView = sc.nextInt();

        if(findStudentIndex(studentIdToView) == -1) {
            System.out.println("\nStudent ID not found. Enter correct Student ID.\n");
            return;
        }

        // Print the Student
        System.out.println(String.format("%-10s %-20s %-10s %-5s %-20s", "studentId", "studentName", "course", "sgpa", "email"));
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(students.get(findStudentIndex(studentIdToView)));
        return;
    }

    // View List Method
    public void viewList() {

        if(students.isEmpty()) {
            System.out.println("No students present.");
            return;
        }

        System.out.println(String.format("%-10s %-20s %-10s %-5s %-20s", "studentId", "studentName", "course", "sgpa", "email"));
        System.out.println("--------------------------------------------------------------------------");
        for(Student student : students) {
            System.out.println(student);
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Total Students: "+students.size());
    }

    // Find Index of Student in ArrayList using Student ID
    public int findStudentIndex(int studentId) {
        for(Student student : students) {
            if(student.getStudentId() == studentId) {
                return students.indexOf(student);
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        final StudentRegistration sr = new StudentRegistration();
        int choice;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        // using a do-while loop to display the menu and take user choice
        do {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Student Registration Management");
            System.out.println("1. Register");
            System.out.println("2. De-Register");
            System.out.println("3. View Student");
            System.out.println("4. View All");
            System.out.println("5. Exit");
            System.out.println("--------------------------------------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            System.out.println();

            switch(choice) {
                case 1: sr.register(); break;
                case 2: sr.deRegisration(); break;
                case 3: sr.view(); break;
                case 4: sr.viewList(); break;
                case 5: 
                    System.out.println("Thank you for using Student Registration Management.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
            
            if(choice == 5) {
                flag = false;
            }

        } while(flag);
    }
}