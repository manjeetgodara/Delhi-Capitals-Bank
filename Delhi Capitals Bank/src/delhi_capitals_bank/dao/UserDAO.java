package delhi_capitals_bank.dao;

import delhi_capitals_bank.dto.UserDTO;
import delhi_capitals_bank.exceptions.NoRecordFoundException;
import delhi_capitals_bank.exceptions.SomethingWentWrongException;

public interface UserDAO {
   public void userSignUp(UserDTO udto) throws SomethingWentWrongException ;
   public boolean userSignIn(String username, String password) throws SomethingWentWrongException, NoRecordFoundException;
   public void changePassword(String oldpassword,String newpassword,String renewpassword) 
			throws SomethingWentWrongException, NoRecordFoundException;
  
   public void deleteAccount(String username, String password) throws SomethingWentWrongException;
   public void updateDetails(String username, String cname, String cmobile, String caddress) throws SomethingWentWrongException;

}
