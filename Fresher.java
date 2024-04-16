package QuangChung;


class Fresher extends Employee {
	    private String graduation_Date;
	    private String graduation_Rank;
	    private String education;

	    public Fresher(int ID, String fullName, String birthDay, String phone, String email, String employee_Type, String graduation_Date, String graduation_Rank, String education) {
	        super(ID, fullName, birthDay, phone, email, employee_Type);
	        this.graduation_Date = graduation_Date;
	        this.graduation_Rank = graduation_Rank;
	        this.education = education;
	    }

	    @Override
	    public void showInfo() {
	        super.showInfo();
	        System.out.println("Graduation Date: " + graduation_Date);
	        System.out.println("Graduation Rank: " + graduation_Rank);
	        System.out.println("Education: " + education);
	    }

		public String getGraduation_Date() {
			return graduation_Date;
		}

		public void setGraduation_Date(String graduation_Date) {
			this.graduation_Date = graduation_Date;
		}

		public String getGraduation_Rank() {
			return graduation_Rank;
		}

		public void setGraduation_Rank(String graduation_Rank) {
			this.graduation_Rank = graduation_Rank;
		}

		public String getEducation() {
			return education;
		}

		public void setEducation(String education) {
			this.education = education;
		}
	}

