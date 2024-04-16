package QuangChung;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmployeeFileWriter {
    public static void writeEmployeesToFile(List<Employee> employees, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Employee employee : employees) {
                writer.write(employee.toString() + "\n");
            }
            System.out.println("Employee data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
