package delhi_capitals_bank.dto;

public interface UserDTO {
	//all abstract methods for customer sign-up
	public String getName() ;
	public void setName(String name);
	public Long getMobile();
	public void setMobile(Long mobile) ;
	public String getAddress() ;
	public void setAddress(String address) ;
	public String getUsername();
	public void setUsername(String username);
	public String getPassword() ;
	public void setPassword(String password) ;
}
