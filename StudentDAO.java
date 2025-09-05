package com.studentapp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	public boolean addStudent(Student student) {
		String sql = "INSERT INTO students (name, email, age, subject) VALUES (?, ?, ?, ?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getEmail());
			pstmt.setInt(3, student.getAge());
			pstmt.setString(4, student.getSubject());
			
			int affectedRows = pstmt.executeUpdate();
			return affectedRows > 0;
		}catch (SQLException e) {
			System.out.println("Error adding student: " + e.getMessage());
			return false;
			
		}
		
	}
	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<>();
		String sql = "SELECT * FROM students";
		
		try (Connection conn = DatabaseConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setAge(rs.getInt("age"));
				student.setSubject(rs.getString("subject"));
				
				students.add(student);
				
				
			}
		}catch (SQLException e) {
			System.out.println("Error retrieving students: " + e.getMessage());
		}
		return students;
		
				
	}
	
	public boolean updateStudent(Student student) {
	    String sql = "UPDATE students SET name = ?, email = ?, age = ?, subject = ? WHERE id = ?";
	    
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, student.getName());
	        pstmt.setString(2, student.getEmail());
	        pstmt.setInt(3, student.getAge());
	        pstmt.setString(4, student.getSubject());
	        pstmt.setInt(5, student.getId());
	        
	        int affectedRows = pstmt.executeUpdate();
	        return affectedRows > 0;
	        
	    } catch (SQLException e) {
	        System.out.println("Error updating student: " + e.getMessage());
	        return false;
	    }
	}

public boolean deleteStudent(int id) {
	String sql = "DELETE FROM students WHERE id = ?";
	
	try(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
		
		pstmt.setInt(1,  id);
		
		int affectedRows = pstmt.executeUpdate();
		return affectedRows > 0;
		
	} catch(SQLException e) {
		System.out.println("Error deleting student: " + e.getMessage());
		return false;
	}
}

public Student getStudentById(int id) {
	String sql = "SELECT * FROM students WHERE id=?";
	Student student = null;
	
	try(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pstmt= conn.prepareStatement(sql)){
		
		pstmt.setInt(1,  id);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setEmail(rs.getString("email"));
			student.setAge(rs.getInt("age"));
			student.setSubject(rs.getString("subject"));
		}
			
			
	}catch (SQLException e) {
		System.out.println("Error retrieving student: " + e.getMessage());
		
	}
	return student;
}
}


