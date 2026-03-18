package univ.ui;

import java.util.Scanner;

public class Menu {
	// Attribute of the Menu class for the StudentService
	private univ.service.StudentService studentService;

	// Method to display the menu options to the user
	public void start() {
		// Instantiating the StudentService to use its methods
		this.studentService = new univ.service.StudentService();
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n========== Menu ==========");
			System.out.println("1. Add Student");
			System.out.println("2. Display All Students");
			System.out.println("3. Search Students by Name");
			System.out.println("4. Search Students by Number");
			System.out.println("5. Delete Student by Number");
			System.out.println("6. Best Student");
			System.out.println("7. Class average");
			System.out.println("8. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
				case 1:
					System.out.print("Enter first name: ");
					String firstName = scanner.nextLine();
					System.out.print("Enter last name: ");
					String lastName = scanner.nextLine();
					System.out.print("Enter student number: ");
					int studentNumber = scanner.nextInt();
					System.out.print("Enter algo grade: ");
					float algoGrade = scanner.nextFloat();
					System.out.print("Enter python grade: ");
					float pythonGrade = scanner.nextFloat();
					studentService.addStudent(firstName, lastName, studentNumber, algoGrade, pythonGrade);
					break;
				case 2:
					studentService.getAllStudents();
					break;
				case 3:
					System.out.print("Enter first name to search: ");
					String searchFirstName = scanner.nextLine();
					studentService.searchStudentsByName(searchFirstName);
					break;
				case 4:
					System.out.print("Enter student number to search: ");
					int searchStudentNumber = scanner.nextInt();
					studentService.searchStudentsByNumber(searchStudentNumber);
					break;
				case 5:
					System.out.print("Enter student number to delete: ");
					int deleteStudentNumber = scanner.nextInt();
					studentService.deleteStudentByNumber(deleteStudentNumber);
					break;
				case 6:
					univ.model.Student bestStudent = studentService.getBestStudent();
					if (bestStudent != null) {
						System.out.println("Best student: " + bestStudent.getFirstName() + " " + bestStudent.getLastName());
						System.out.println("Average grade: " + studentService.calculateAverageGrade(bestStudent));
					} else {
						System.out.println("No students found.");
					}
					break;
				case 7:
					float[] classAverages = studentService.getClassAverages();
					System.out.println("Class average for Algo: " + classAverages[0]);
					System.out.println("Class average for Python: " + classAverages[1]);
					break;
				case 8:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 8);
		scanner.close();
	}
}
