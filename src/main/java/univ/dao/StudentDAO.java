package univ.dao;

import univ.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	// Attribute of the StudentDAO class for database connection
	private Connection connection;

	// Constructor of the StudentDAO class
	public StudentDAO() {
		// Obtaining the database connection via the DatabaseConnection class
		this.connection = DatabaseConnection.getInstance().getConnection();
	}

	// Add a student to the database
	public void addStudent(Student student) {
		String sql = "INSERT INTO etudiants (nom, prenom, numero_etudiant, note_algo, note_python) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, student.getFirstName());
			pstmt.setString(2, student.getLastName());
			pstmt.setInt(3, student.getStudentNumber());
			pstmt.setFloat(4, student.getAlgoGrade());
			pstmt.setFloat(5, student.getPythonGrade());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Display all students from the database
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		String sql = "SELECT * FROM etudiants";
		try (Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Student student = new Student(
						rs.getInt("id"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getInt("numero_etudiant"),
						rs.getFloat("note_algo"),
						rs.getFloat("note_python"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	// Search for students by name
	public List<Student> searchStudentsByName(String firstName) {
		List<Student> students = new ArrayList<>();
		String sql = "SELECT * FROM etudiants WHERE nom = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, firstName);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Student student = new Student(
							rs.getInt("id"),
							rs.getString("nom"),
							rs.getString("prenom"),
							rs.getInt("numero_etudiant"),
							rs.getFloat("note_algo"),
							rs.getFloat("note_python"));
					students.add(student);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	// Search for students by student number
	public List<Student> searchStudentsByNumber(int studentNumber) {
		List<Student> students = new ArrayList<>();
		String sql = "SELECT * FROM etudiants WHERE numero_etudiant = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, studentNumber);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Student student = new Student(
							rs.getInt("id"),
							rs.getString("nom"),
							rs.getString("prenom"),
							rs.getInt("numero_etudiant"),
							rs.getFloat("note_algo"),
							rs.getFloat("note_python"));
					students.add(student);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	// Delete a student from the database by student number
	public void deleteStudentByNumber(int studentNumber) {
		String sql = "DELETE FROM etudiants WHERE numero_etudiant = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, studentNumber);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
