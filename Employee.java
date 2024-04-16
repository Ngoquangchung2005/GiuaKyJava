package QuangChung;

public class Employee  implements IEmployee{
	private int ID;
	private String fullName;
	private String birthDay;
	private String phone;
	private String email;
	private String employee_Type;
	private static int employeeCount = 0;
	
	public Employee(int ID, String fullName, String birthDay, String phone, String email, String employeeType) {
        this.ID = ID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employee_Type = employeeType;
        employeeCount++;
    }
	public void showInfo() {
		   System.out.println("ID: " + ID);
	        System.out.println("Full Name: " + fullName);
	        System.out.println("BirthDay: " + birthDay);
	        System.out.println("Phone: " + phone);
	        System.out.println("Email: " + email);
	        System.out.println("Employee Type: " + employee_Type);
		
	}
	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", fullName=" + fullName + ", birthDay=" + birthDay + ", phone=" + phone
				+ ", email=" + email + ", employee_Type=" + employee_Type + "]";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmployee_Type() {
		return employee_Type;
	}
	public void setEmployee_Type(String employee_Type) {
		this.employee_Type = employee_Type;
	}
	public static int getEmployeeCount() {
		return employeeCount;
	}
	public static void setEmployeeCount(int employeeCount) {
		Employee.employeeCount = employeeCount;
	}

}
