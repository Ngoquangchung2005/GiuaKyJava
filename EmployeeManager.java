package QuangChung;


import java.util.ArrayList;
import java.util.List;

import QuangChung.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    //Them nhan vien
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    //Danh sach nhân viên
    public void displayAllEmployees() {
        for (Employee employee : employees) {
            employee.showInfo();
        }
    }

    //Cập nhật nhân viên
    public void updateEmployee(int employeeID, Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID() == employeeID) {
                employees.set(i, updatedEmployee);
                return;
            }
        }
        System.out.println("Employee with ID " + employeeID + " not found.");
    }

    //Xoá nhân viên
    public void deleteEmployee(int employeeID) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID() == employeeID) {
                employees.remove(i);
                System.out.println("Employee with ID " + employeeID + " deleted successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + employeeID + " not found.");
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}


