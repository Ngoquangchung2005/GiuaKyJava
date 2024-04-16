package QuangChung;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement

public class EmployeeDatabase {
    private Connection connection;

    public EmployeeDatabase() {
        try {
            // Kết nối đến cơ sở dữ liệu SQLite
            connection = DriverManager.getConnection("jdbc:sqlite:employees.db");
            System.out.println("Connected to SQLite database.");
        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite database: " + e.getMessage());
        }
    }

    public void createEmployeeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS employees (id INTEGER PRIMARY KEY, name TEXT, age INTEGER)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
            System.out.println("Employee table created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating employee table: " + e.getMessage());
        }
    }

    public void addEmployee(int id, String name, int age) {
        String sql = "INSERT INTO employees (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, age);
            statement.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    public void displayAllEmployees() {
        String sql = "SELECT * FROM employees";
        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            System.out.println("Error displaying employees: " + e.getMessage());
        }
    }

    // Các phương thức khác như cập nhật và xóa nhân viên có thể thêm vào sau
}
