package com.studentapp;
import java.util.List;
import java.util.Scanner;


public class StudentManagementApp {
	private static Scanner scanner = new Scanner(System.in);
	private static StudentDAO studentDAO = new StudentDAO();
	
	

	public static void main(String[] args) {
		boolean running = true;
		
		while (running) {
			System.out.println("\n=== Student Database Management System ===");
			
			System.out.println("1.Add Students");
			System.out.println("2.View All Students");
			System.out.println("3.Update Student");
			System.out.println("4.Delete Student");
			System.out.println("5.View Student by ID");
			System.out.println("6.Exit");
			System.out.println("Choose an option: ");
			
			int choice = getIntInput();
			
			switch (choice) {
			case 1:
				addStudent();
				break;
				
			case 2:
				viewAllStudents();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				deleteStudent();
				break;
			case 5:
				viewStudentById();
				break;
			case 6:
				running = false;
				System.out.println("Exiting application. Goodbye!");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
				
			  
			 
			  
			
			}
		}
		
		scanner.close();
		

	}
	
	private static void addStudent() {
		System.out.println("\n--- Add new student---");
		
		System.out.println("Enter name: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter email: ");
		String email = scanner.nextLine();
		
		System.out.println("Enter age: ");
		int age = getIntInput();
		scanner.nextLine();
		
		System.out.println("Enter subject: ");
		String subject = scanner.nextLine();
		
		Student student = new Student(name,email,age,subject);
		
		 if (studentDAO.addStudent(student)) {
	            System.out.println("Student added successfully!");
	        } else {
	            System.out.println("Failed to add student.");
	        }
	    }
	    
	    private static void viewAllStudents() {
	        System.out.println("\n--- All Students ---");
	        
	        List<Student> students = studentDAO.getAllStudents();
	        
	        if (students.isEmpty()) {
	            System.out.println("No students found.");
	        } else {
	            for (Student student : students) {
	                System.out.println(student);
	            }
	        }
	    }
	    
	    private static void updateStudent() {
	        System.out.println("\n--- Update Student ---");
	        
	        System.out.print("Enter student ID to update: ");
	        int id = getIntInput();
	        scanner.nextLine(); 
	        
	        Student existingStudent = studentDAO.getStudentById(id);
	        
	        if (existingStudent == null) {
	            System.out.println("Student not found with ID: " + id);
	            return;
	        }
	        
	        System.out.println("Current details: " + existingStudent);
	        
	        System.out.print("Enter new name (press enter to keep current): ");
	        String name = scanner.nextLine();
	        if (!name.isEmpty()) {
	            existingStudent.setName(name);
	        }
	        
	        System.out.print("Enter new email (press enter to keep current): ");
	        String email = scanner.nextLine();
	        if (!email.isEmpty()) {
	            existingStudent.setEmail(email);
	        }
	        
	        System.out.print("Enter new age (press enter to keep current): ");
	        String ageInput = scanner.nextLine();
	        if (!ageInput.isEmpty()) {
	            try {
	                existingStudent.setAge(Integer.parseInt(ageInput));
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid age. Keeping current value.");
	            }
	        }
	        
	        System.out.print("Enter new subject (press enter to keep current): ");
	        String subject = scanner.nextLine();
	        if (!subject.isEmpty()) {
	            existingStudent.setSubject(subject);
	        }
	        
	        if (studentDAO.updateStudent(existingStudent)) {
	            System.out.println("Student updated successfully!");
	        } else {
	            System.out.println("Failed to update student.");
	        }
	    }
	    
	    private static void deleteStudent() {
	        System.out.println("\n--- Delete Student ---");
	        
	        System.out.print("Enter student ID to delete: ");
	        int id = getIntInput();
	        scanner.nextLine(); // Consume newline
	        
	        Student student = studentDAO.getStudentById(id);
	        
	        if (student == null) {
	            System.out.println("Student not found with ID: " + id);
	            return;
	        }
	        
	        System.out.println("You are about to delete: " + student);
	        System.out.print("Are you sure? (yes/no): ");
	        String confirmation = scanner.nextLine();
	        
	        if (confirmation.equalsIgnoreCase("yes")) {
	            if (studentDAO.deleteStudent(id)) {
	                System.out.println("Student deleted successfully!");
	            } else {
	                System.out.println("Failed to delete student.");
	            }
	        } else {
	            System.out.println("Deletion cancelled.");
	        }
	    }
	    
	    private static void viewStudentById() {
	        System.out.println("\n--- View Student by ID ---");
	        
	        System.out.print("Enter student ID: ");
	        int id = getIntInput();
	        scanner.nextLine(); // Consume newline
	        
	        Student student = studentDAO.getStudentById(id);
	        
	        if (student != null) {
	            System.out.println("Student details: " + student);
	        } else {
	            System.out.println("Student not found with ID: " + id);
	        }
	    }
	    
	    private static int getIntInput() {
	        while (true) {
	            try {
	                return Integer.parseInt(scanner.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.print("Invalid input. Please enter a number: ");
	            }
	        }
	    }
	}
		
	    
		
		
	