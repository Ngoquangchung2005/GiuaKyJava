package QuangChung;

class Experience extends Employee {
    private int expInYear;
    private String proSkill;

    public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	public Experience(int ID, String fullName, String birthDay, String phone, String email, String employee_Type, int expInYear, String proSkill) {
        super(ID, fullName, birthDay, phone, email, employee_Type);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Experience in Year: " + expInYear);
        System.out.println("Professional Skill: " + proSkill);
    }
}
