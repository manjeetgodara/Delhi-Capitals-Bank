package delhi_capitals_bank.dto;

import java.time.LocalDate;

public interface BankAccountDTO {
	
	public String getName() ;
	public void setName(String name) ;
	public String getFname() ;
	public void setFname(String fname) ;
	public LocalDate getDob();
	public void setDob(LocalDate dob);
	public String getGender() ;
	public void setGender(String gender);
	public String getEmail() ;
	public void setEmail(String email) ;
	public String getMartial() ;
	public void setMartial(String martial) ;
	public String getAddress() ;
	public void setAddress(String address) ;
	public int getIncome();
	public void setIncome(int income);
	public String getType() ;
	public void setType(String type);
	public String getService() ;
	public void setService(String service);
	
}
