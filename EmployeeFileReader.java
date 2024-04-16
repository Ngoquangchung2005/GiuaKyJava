package QuangChung;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileReader {
    public static List<Employee> readEmployeesFromFile(String filename) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int ID = Integer.parseInt(parts[0]);
                String fullName = parts[1];
                String birthDay = parts[2];
                String phone = parts[3];
                String email = parts[4];
                String employeeType = parts[5];

                Employee employee;
                if (employeeType.equalsIgnoreCase("Experience")) {
                    int expInYear = Integer.parseInt(parts[6]);
                    String proSkill = parts[7];
                    employee = new Experience(ID, fullName, birthDay, phone, email, employeeType, expInYear, proSkill);
                } else if (employeeType.equalsIgnoreCase("Fresher")) {
                    String graduationDate = parts[6];
                    String graduationRank = parts[7];
                    String education = parts[8];
                    employee = new Fresher(ID, fullName, birthDay, phone, email, employeeType, graduationDate, graduationRank, education);
                } else if (employeeType.equalsIgnoreCase("Intern")) {
                    String majors = parts[6];
                    String semester = parts[7];
                    String universityName = parts[8];
                    employee = new Intern(ID, fullName, birthDay, phone, email, employeeType, majors, semester, universityName);
                } else {
                    System.out.println("Invalid employee type in file.");
                    continue;
                }

                employees.add(employee);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return employees;
    }
}
