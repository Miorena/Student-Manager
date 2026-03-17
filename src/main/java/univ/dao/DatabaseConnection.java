package univ.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:postgresql://localhost:5432/gestion_etudiants";
	private static final String USER = "postgres";
	private static final String PASSWORD = "kuroneko";

	// Unique instance of the database connection
	private static DatabaseConnection instance = null;
	private Connection connection;

	// Private constructor to prevent direct instantiation
	private DatabaseConnection() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// getInstance to get the unique instance of the database connection
	public static DatabaseConnection getInstance() {
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

	// Getter to get the database connection
	public Connection getConnection() {
		return connection;
	}
}
