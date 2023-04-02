package delhi_capitals_bank.ui;

import java.util.Scanner;

import delhi_capitals_bank.colors.ConsoleColors;
import delhi_capitals_bank.dao.UserDAO;
import delhi_capitals_bank.dao.UserDAOImpl;
import delhi_capitals_bank.dao.UserLogged;
import delhi_capitals_bank.dto.UserDTO;
import delhi_capitals_bank.dto.UserDTOImpl;
import delhi_capitals_bank.exceptions.NoRecordFoundException;
import delhi_capitals_bank.exceptions.SomethingWentWrongException;




public class UserUI {
	//sign-up method
	public static void userSignUp(Scanner sc) {
		
		System.out.print(ConsoleColors.CYAN_BOLD_BRIGHT+"Enter name : ");
		String name=sc.next();
		System.out.print("Enter mobile number : ");
		Long mobile=sc.nextLong();
		System.out.print("Enter address : ");
		String address=sc.next();
		System.out.print("Enter username : ");
		String username=sc.next();
		System.out.print("Enter password : ");
		String password=sc.next();
		
		UserDTO udto=new UserDTOImpl(name,mobile,address,username,password);
		
		UserDAO udao=new UserDAOImpl();
		try {
			udao.userSignUp(udto);
			System.out.println(ConsoleColors.BANANA_YELLOW+"Sign-up successfully!");
		} catch (SomethingWentWrongException e) {
			System.out.println(e);
		}
    }
	
	//sign-in method
	public static boolean userSignIn(Scanner sc) {
		System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT+"Enter username : ");
		String username=sc.next();
		System.out.print("Enter password : ");
		String password=sc.next();
		
		UserDAO userDAO=new UserDAOImpl();
		
		try {
			boolean res=userDAO.userSignIn(username, password);
			if(res==true && UserLogged.UserLoggedInId!=0) {
				System.out.println(ConsoleColors.BANANA_YELLOW+"Logged In Successfully!!");
				return true;
			}else {
				return false;
			}
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e);
		}
		
		return false;
		
	}
	
	//user logout method
	 public static void userLogout() {
		UserLogged.UserLoggedInId=0;
	 }
	 
	 
	 //user password change method
	 public static void changePassword(Scanner sc) {
		 System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT+"Enter old password : ");
   	     String oldpassword=sc.next();
   	     System.out.print("Enter new password : ");
   	     String newpassword=sc.next();
   	     System.out.print("Re-enter password : ");
   	     String renewpassword=sc.next();
   	     
   	    UserDAO userDAO=new UserDAOImpl();
   	    
   	    try {
			userDAO.changePassword(oldpassword, newpassword, renewpassword);
			System.out.println(ConsoleColors.BANANA_YELLOW+"Password changed Successfully!!");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			
			System.out.println(e);
		}
   	  
	 }
	 
	 //user update details method
	 public static void updateDetails(Scanner sc) {
		 System.out.print(ConsoleColors.PURPLE_BOLD_BRIGHT+"Enter username : ");
		 String username=sc.next();
		 System.out.print("Enter name : ");
		 String Cname=sc.next();
		 System.out.print("Enter mobile number : ");
		 String Cmobile=sc.next();
		 System.out.print("Enter address : ");
		 String Caddress=sc.next();
		 
		 
		 
		 UserDAO uDAO=new UserDAOImpl();
	   	 
		 try {
			uDAO.updateDetails(username, Cname, Cmobile, Caddress);
			System.out.println(ConsoleColors.BANANA_YELLOW+"Details updated successfully!!");
			
		} catch (SomethingWentWrongException e) {
		
			e.printStackTrace();
		}
		 
	 }
	 
	 //To delete user account
	 public static void deleteAccount(Scanner sc) {
		 System.out.print(ConsoleColors.BROWN+"Enter username : ");
		 String username=sc.next();
		 System.out.print("Enter password : ");
		 String password=sc.next();
		 
		 UserDAO userDAO=new UserDAOImpl();
		 
		 try {
			userDAO.deleteAccount(username, password);
			System.out.println(ConsoleColors.BANANA_YELLOW+"Account deleted successfully");
		} catch (SomethingWentWrongException e) {
			e.printStackTrace();
		}
		 
	 }
	
}