package delhi_capitals_bank.dto;

public class UserDTOImpl implements UserDTO {
     private String name;
     private Long mobile;
     private String address;
     private  String username;
     private String password;
     
     //constructor
	public UserDTOImpl(String name, Long mobile, String address, String username, String password) {
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.username = username;
		this.password = password;
	}

	//getter and setter methods
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Long getMobile() {
		return mobile;
	}

	@Override
	public void setMobile(Long mobile) {
		this.mobile = mobile;
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
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
    //toString method
	@Override
	public String toString() {
		return "name = " + name + " mobile = " + mobile + " address = " + address + " username = " + username
				+ " password = " + password ;
	}
     
     
}
