package univ.model;

public class Student {
	// Class attributes
	private int id;
	private String lastName;
	private String firstName;
	private int studentNumber;
	private float algoGrade;
	private float pythonGrade;

	// Constructor for Student class
	public Student(String lastName, String firstName, int studentNumber, float algoGrade, float pythonGrade) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.studentNumber = studentNumber;
		this.algoGrade = algoGrade;
		this.pythonGrade = pythonGrade;
	}

	public Student(int id, String lastName, String firstName, int studentNumber, float algoGrade, float pythonGrade) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.studentNumber = studentNumber;
		this.algoGrade = algoGrade;
		this.pythonGrade = pythonGrade;
	}

	// Getters and Setters for Student class attributes
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public float getAlgoGrade() {
		return algoGrade;
	}

	public void setAlgoGrade(float algoGrade) {
		this.algoGrade = algoGrade;
	}

	public float getPythonGrade() {
		return pythonGrade;
	}

	public void setPythonGrade(float pythonGrade) {
		this.pythonGrade = pythonGrade;
	}

	@Override
	public String toString() {
		return String.format("Student {id=%d, lastName='%s', firstName='%s', studentNumber=%d, algoGrade=%.2f, pythonGrade=%.2f}",
			id, lastName, firstName, studentNumber, algoGrade, pythonGrade
		);
	}
}
