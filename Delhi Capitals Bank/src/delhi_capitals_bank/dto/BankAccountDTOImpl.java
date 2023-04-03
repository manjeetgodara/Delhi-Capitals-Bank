package delhi_capitals_bank.dto;

import java.time.LocalDate;

  public class BankAccountDTOImpl implements BankAccountDTO {
         private String name;
         private String fname;
         private LocalDate dob;
         private String gender;
         private String email;
         private String martial;
         private String address;
         private int income;
         private String type;
         private String service;
         
		public BankAccountDTOImpl(String name, String fname, LocalDate dob, String gender, String email, String martial,
				String address, int income, String type, String service) {
			this.name = name;
			this.fname = fname;
			this.dob = dob;
			this.gender = gender;
			this.email = email;
			this.martial = martial;
			this.address = address;
			this.income = income;
			this.type = type;
			this.service = service;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		@Override
		public LocalDate getDob() {
			return dob;
		}

		@Override
		public void setDob(LocalDate dob) {
			this.dob = dob;
		}

		@Override
		public String getGender() {
			return gender;
		}

		@Override
		public void setGender(String gender) {
			this.gender = gender;
		}

		@Override
		public String getEmail() {
			return email;
		}

		@Override
		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String getMartial() {
			return martial;
		}

		@Override
		public void setMartial(String martial) {
			this.martial = martial;
		}

		@Override
		public String getAddress() {
			return address;
		}

		@Override
		public void setAddress(String address) {
			this.address = address;
		}

		@Override
		public int getIncome() {
			return income;
		}

		@Override
		public void setIncome(int income) {
			this.income = income;
		}

		@Override
		public String getType() {
			return type;
		}

		@Override
		public void setType(String type) {
			this.type = type;
		}

		@Override
		public String getService() {
			return service;
		}

		@Override
		public void setService(String service) {
			this.service = service;
		}

		@Override
		public String toString() {
			return "name = " + name + " fname = " + fname + " dob = " + dob + " gender = " + gender
					+ " email = " + email + " martial = " + martial + " address = " + address + " income = " + income
					+ " type = " + type + " service = " + service;
		}
         
		
         
         
         
   }
