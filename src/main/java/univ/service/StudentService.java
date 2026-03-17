package univ.service;

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

	// Method to display all students using the StudentDAO
	public void getAllStudents() {
		studentDAO.getAllStudents().forEach(student -> {
			System.out.println("ID: " + student.getId());
			System.out.println("First Name: " + student.getFirstName());
			System.out.println("Last Name: " + student.getLastName());
			System.out.println("Student Number: " + student.getStudentNumber());
			System.out.println("Algo Grade: " + student.getAlgoGrade());
			System.out.println("Python Grade: " + student.getPythonGrade());
			System.out.println("-----------------------------");
		});
	}

	// Method to search for students by name using the StudentDAO
	public void searchStudentsByName(String firstName) {

	}
}
