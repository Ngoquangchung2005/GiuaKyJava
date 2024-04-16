package QuangChung;



import java.util.Scanner;

import QuangChung.Employee;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager employeeManager = new EmployeeManager();

        while (true) {
        	 System.out.println("1. Them nhan vien");
             System.out.println("2. Hien thi danh sach nhan vien");
             System.out.println("3. Cap nhat nhan vien");
             System.out.println("4. Xoa nhan vien");
             System.out.println("5. Ghi danh sach nhan vien vao file");
             System.out.println("6. Doc danh sach nhan vien tu file");
             System.out.println("7. Thoat");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addEmployee(scanner, employeeManager);
                    break;
                case 2:
                    employeeManager.displayAllEmployees();
                    break;
                case 3:
                    updateEmployee(scanner, employeeManager);
                    break;
                case 4:
                    deleteEmployee(scanner, employeeManager);
                    break;
                case 5:
                	 EmployeeFileWriter.writeEmployeesToFile(employeeManager.getEmployees(), "C:\\nhanvien.txt");
                     break;
                case 6:
                    employeeManager.setEmployees(EmployeeFileReader.readEmployeesFromFile("C:\\nhanvien.txt"));
                    System.out.println("Danh sach nhan vien da duoc cap nhat tu file.");
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

    private static void addEmployee(Scanner scanner, EmployeeManager employeeManager) {
        System.out.print("Enter ID: ");
        int ID = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter BirthDay: ");
        String birthDay = scanner.nextLine();

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Employee Type: ");
        String employee_Type = scanner.nextLine();

        // Create Employee object based on employee type
        Employee employee;
        if (employee_Type.equalsIgnoreCase("Experience")) {
            System.out.print("Enter ExpInYear: ");
            int expInYear = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter ProSkill: ");
            String proSkill = scanner.nextLine();

            employee = new Experience(ID, fullName, birthDay, phone, email, employee_Type, expInYear, proSkill);
        } else if (employee_Type.equalsIgnoreCase("Fresher")) {
            System.out.print("Enter Graduation Date: ");
            String graduation_Date = scanner.nextLine();

            System.out.print("Enter Graduation Rank: ");
            String graduation_Rank = scanner.nextLine();

            System.out.print("Enter Education: ");
            String education = scanner.nextLine();

            employee = new Fresher(ID, fullName, birthDay, phone, email, employee_Type, graduation_Date, graduation_Rank, education);
        } else if (employee_Type.equalsIgnoreCase("Intern")) {
            System.out.print("Enter Majors: ");
            String majors = scanner.nextLine();

            System.out.print("Enter Semester: ");
            String semester = scanner.nextLine();

            System.out.print("Enter University Name: ");
            String universityName = scanner.nextLine();

            employee = new Intern(ID, fullName, birthDay, phone, email, employee_Type, majors, semester, universityName);
        } else {
            System.out.println("Invalid employee type. Employee not added.");
            return;
        }

        //Them nhan vien
        employeeManager.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    
    
    
    //cap nhat nhan vien
    private static void updateEmployee(Scanner scanner, EmployeeManager employeeManager) {
        System.out.print("Enter ID of employee to update: ");
        int employeeID = scanner.nextInt();
        scanner.nextLine(); 
     
        for (Employee employee : employeeManager.getEmployees()) {
            if (employee.getID() == employeeID) {
                
                System.out.print("Enter updated Full Name: ");
                String fullName = scanner.nextLine();

                System.out.print("Enter updated BirthDay: ");
                String birthDay = scanner.nextLine();

                System.out.print("Enter updated Phone: ");
                String phone = scanner.nextLine();

                System.out.print("Enter updated Email: ");
                String email = scanner.nextLine();

       
                System.out.print("Enter updated Employee Type (Experience, Fresher, or Intern): ");
                String employeeType = scanner.nextLine();

         
                employee.setFullName(fullName);
                employee.setBirthDay(birthDay);
                employee.setPhone(phone);
                employee.setEmail(email);
                employee.setEmployee_Type(employeeType); 

                
                if (employeeType.equalsIgnoreCase("Experience")) {
                    if (employee instanceof Experience) {
                        Experience experienceEmployee = (Experience) employee;
                        System.out.print("Enter updated ExpInYear: ");
                        int expInYear = scanner.nextInt();
                        scanner.nextLine(); 

                        System.out.print("Enter updated ProSkill: ");
                        String proSkill = scanner.nextLine();

                        experienceEmployee.setExpInYear(expInYear);
                        experienceEmployee.setProSkill(proSkill);
                    } else {
                        
                    }
                } else if (employeeType.equalsIgnoreCase("Fresher")) {
                    if (employee instanceof Fresher) {
                        Fresher fresherEmployee = (Fresher) employee;
                        System.out.print("Enter updated Graduation Date: ");
                        String graduationDate = scanner.nextLine();

                        System.out.print("Enter updated Graduation Rank: ");
                        String graduationRank = scanner.nextLine();

                        System.out.print("Enter updated Education: ");
                        String education = scanner.nextLine();

                        fresherEmployee.setGraduation_Date(graduationDate);
                        fresherEmployee.setGraduation_Rank(graduationRank);
                        fresherEmployee.setEducation(education);
                    } else {
           
                    }
                } else if (employeeType.equalsIgnoreCase("Intern")) {
                    if (employee instanceof Intern) {
                        Intern internEmployee = (Intern) employee;
                        System.out.print("Enter updated Majors: ");
                        String majors = scanner.nextLine();

                        System.out.print("Enter updated Semester: ");
                        String semester = scanner.nextLine();

                        System.out.print("Enter updated University Name: ");
                        String universityName = scanner.nextLine();

                        internEmployee.setMajors(majors);
                        internEmployee.setSemester(semester);
                        internEmployee.setUniversityName(universityName);
                    } else {
                        
                    }
                } else {
                    System.out.println("Invalid Employee Type. Please try again.");
                }

                System.out.println("Employee with ID " + employeeID + " updated successfully.");
                return;
            }
        }

        System.out.println("Employee with ID " + employeeID + " not found.");
    }


    private static void deleteEmployee(Scanner scanner, EmployeeManager employeeManager) {
        System.out.print("Enter ID of employee to delete: ");
        int employeeID = scanner.nextInt();
        scanner.nextLine(); 

        employeeManager.deleteEmployee(employeeID);
    }
}
