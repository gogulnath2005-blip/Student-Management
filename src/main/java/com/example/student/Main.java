package com.example.student;
import java.sql.*;
import com.example.student.model.Student;
import com.example.student.service.StudentService;
import java.util.*;
public class Main
{
    private static final Scanner scanner = new Scanner(System.in);
           private static final StudentService studentService = new StudentService();
    public static void main(String[] args)
    {
           boolean running = true;
           while(running)
           {
               showMenu();
               int choice=readInt("Enter your choice");
               try
               {
                   switch(choice)
                   {
                       case 1 -> addStudent();
                       case 2 -> viewAllStudent();
                       case 3 -> searchStudent();
                       case 4 -> updateStudent();
                       case 5 -> deleteStudent();
                       case 6 ->
                       {
                           running = false;
                           System.out.println("Application Closed");
                       }
                       default ->  System.out.println("Invalid choice..Try Again");
                   }

               }
               catch(SQLException e)
               {
                   System.out.println("Database Operation failed :" + e.getMessage());
               } catch(IllegalArgumentException e)
               {
                   System.out.println("Invalid input :" + e.getMessage());
               }
           }


    }
    private static void showMenu()
    {
        System.out.println("\n=====Student Management Sytem====");
        System.out.println("1. AddStudent");
        System.out.println("2. ViewAllStudents");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Students");
        System.out.println("5. Delete Students");
        System.out.println("6. EXIT");
    }
    private static  void addStudent() throws SQLException
    {
        System.out.println("\n---- Add Student ----");

        String name = readText("Enter name:");
        String email = readText("Enter email:");
        String course = readText("Enter course:");
        int age = readInt("Enter age");

        Student student = new Student (name,email,course,age);

        boolean inserted = studentService.addStudent(student);

        if(inserted)
        {
            System.out.println("Student added successfully");
        }
        else
        {
            System.out.println("Student was not added");
        }
    }

    private static void viewAllStudent() throws SQLException
    {
        System.out.println("\n--- All Students ---");
        List<Student> students = studentService.getAllStudents();

        if(students.isEmpty())
        {
            System.out.println("No Student found");
            return;
        }

        for(Student student : students)
                {
                    printStudent(student);
                }
    }
    private static void searchStudent() throws SQLException
    {
        System.out.println("\n--- Search Student ---");
        int id = readInt("Enter student ID");
        Student student = studentService.getStudentById(id);

        if(student == null)
        {
            System.out.println("Student not found");
        }
        else
        {
            printStudent(student);
        }
    }
    private static void updateStudent() throws SQLException
    {
        System.out.println("\n--- Update Students ---");
        int id = readInt("Enter student ID to Update: ");
        Student existingStudent = studentService.getStudentById(id);
        if(existingStudent == null)
        {
            System.out.println("Student not found");
            return;
        }
        System.out.println("Current Details: ");
        printStudent(existingStudent);

        String name = readText("Enter name:");
        String email = readText("Enter email:");
        String course = readText("Enter course:");
        int age = readInt("Enter age");

        Student updateStudent =
                new Student(id, name, email, course, age);

        boolean updated = studentService.updateStudent(updateStudent);

        System.out.println((updated ? "Student updated successfully!" : "No Student record"));
    }
    private static void deleteStudent() throws SQLException {

        System.out.println("\n--- Delete Student ---");

        int id = readInt("Enter student ID to delete: ");

        Student student = studentService.getStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        printStudent(student);

        String confirmation = readText("Are you sure? (yes/no): ");

        if (!confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Delete cancelled.");
            return;
        }

        boolean deleted = studentService.deleteStudent(id);

        System.out.println(deleted
                ? "Student deleted successfully!"
                : "Student was not deleted.");
    }

    private static void printStudent(Student student) {

        System.out.println("--------------------------------");
        System.out.println("ID     : " + student.getId());
        System.out.println("Name   : " + student.getName());
        System.out.println("Email  : " + student.getEmail());
        System.out.println("Course : " + student.getCourse());
        System.out.println("Age    : " + student.getAge());
        System.out.println("--------------------------------");
    }

    private static String readText(String message) {

        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static int readInt(String message) {

        while (true) {

            System.out.print(message);
            String value = scanner.nextLine().trim();

            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}
