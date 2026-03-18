package univ.service;

import java.util.List;
import univ.dao.StudentDAO;

public class StudentService {
	// Attribute of the StudentService class for the StudentDAO
	private StudentDAO studentDAO;

	// Constructor of the StudentService class
	public StudentService() {
		// Instantiating the StudentDAO to use its methods
		this.studentDAO = new StudentDAO();
	}

	// Method to add a student using the StudentDAO
	public void addStudent(String firstName, String lastName, int studentNumber, float algoGrade, float pythonGrade) {
		// Validating the grades before adding the student
		if (!isValidStudentGrade(algoGrade)) {
			System.out.println("Note d'algorithme invalide: " + algoGrade + ". Elle doit être entre 0 et 20.");
			return;
		}
		if (!isValidStudentGrade(pythonGrade)) {
			System.out.println("Note de Python invalide: " + pythonGrade + ". Elle doit être entre 0 et 20.");
			return;
		}

		studentDAO.addStudent(new univ.model.Student(firstName, lastName, studentNumber, algoGrade, pythonGrade));
	}

	public boolean isValidStudentGrade(float grade) {
		return grade >= 0 && grade <= 20;
	}

	private void printStudent(univ.model.Student student) {
		System.out.println("ID: " + student.getId());
		System.out.println("First Name: " + student.getFirstName());
		System.out.println("Last Name: " + student.getLastName());
		System.out.println("Student Number: " + student.getStudentNumber());
		System.out.println("Algo Grade: " + student.getAlgoGrade());
		System.out.println("Python Grade: " + student.getPythonGrade());
		System.out.println("-----------------------------");
	}

	// Method to display all students using the StudentDAO
	public void getAllStudents() {
		studentDAO.getAllStudents().forEach(this::printStudent);
	}

	// Method to search for students by name using the StudentDAO
	public void searchStudentsByName(String firstName) {
		studentDAO.searchStudentsByName(firstName).forEach(this::printStudent);
	}

	// Method to search students by number using the StudentDAO
	public void searchStudentsByNumber(int studentNumber) {
		studentDAO.searchStudentsByNumber(studentNumber).forEach(this::printStudent);
	}

	// Method to delete a student by number using the StudentDAO
	public void deleteStudentByNumber(int studentNumber) {
		studentDAO.deleteStudentByNumber(studentNumber);
	}

	// Method to calculate the average grade of a student
	public float calculateAverageGrade(univ.model.Student student) {
		return (student.getAlgoGrade() + student.getPythonGrade()) / 2;
	}

	// Method to calculate the class averages
	public float[] getClassAverages() {
		List<univ.model.Student> students = studentDAO.getAllStudents();
		if (students.isEmpty()) return new float[]{0, 0};

		float totalAlgoGrade = 0, totalPythonGrade = 0;
		for (univ.model.Student student : students) {
			totalAlgoGrade += student.getAlgoGrade();
			totalPythonGrade += student.getPythonGrade();
		}
		return new float[] {
			totalAlgoGrade / students.size(),
			totalPythonGrade / students.size()
		};
	}

	// Mehode for the best student in the class
	public univ.model.Student getBestStudent() {
		List<univ.model.Student> students = studentDAO.getAllStudents();
		if (students.isEmpty()) return null;

		univ.model.Student bestStudent = students.get(0);
		for (univ.model.Student student : students) {
			if (calculateAverageGrade(student) > calculateAverageGrade(bestStudent)) {
				bestStudent = student;
			}
		}
		return bestStudent;
	}
}
