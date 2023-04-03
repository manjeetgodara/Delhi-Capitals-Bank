package delhi_capitals_bank.ui;

import java.util.Scanner;

import delhi_capitals_bank.colors.ConsoleColors;
import delhi_capitals_bank.dao.AdminDAO;
import delhi_capitals_bank.dao.AdminDAOImpl;
import delhi_capitals_bank.exceptions.NoRecordFoundException;
import delhi_capitals_bank.exceptions.SomethingWentWrongException;

public class AdminUI {
    
	public static void viewAllCustomers() {
		
		AdminDAO adao=new AdminDAOImpl();
		
		try {
			adao.viewAllCustomer();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e);
		}
	}
	
	
	public static void viewCustomerByID(Scanner sc) {
		
		System.out.print(ConsoleColors.BLUE_BOLD+"Enter customer id : ");
		int customer_id=sc.nextInt();
		
		AdminDAO adao=new AdminDAOImpl();
		
		try {
			adao.viewCustomerByID(customer_id);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			
			System.out.println(e);
		}
	}
	
	
	public static void viewAllAccounts() {
        AdminDAO adao=new AdminDAOImpl();
		
		try {
			adao.viewAllAccounts();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e);
		}
	}
	
	
   public static void viewAccountByaccountNumber(Scanner sc) {
		
		System.out.print(ConsoleColors.WHITE+"Enter account number : ");
		Long accountNumber=sc.nextLong();
		
		AdminDAO adao=new AdminDAOImpl();
		
		try {
			adao.viewAccountByaccountNumber(accountNumber);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e);
		}
	}
   
   public static void changeStatus(Scanner sc) {
	   System.out.print(ConsoleColors.WHITE+"Enter account number : ");
		Long accountNumber=sc.nextLong();
		
          AdminDAO adao=new AdminDAOImpl();
		
		try {
			adao.changeStatus(accountNumber);
			System.out.println(ConsoleColors.BANANA_YELLOW+"Status changed successfully!!");
		} catch (SomethingWentWrongException e) {
			System.out.println(e);
		}
   }
   
   
   public static void changeNonActive(Scanner sc) {
	   System.out.print(ConsoleColors.WHITE+"Enter account number : ");
		Long accountNumber=sc.nextLong();
		
         AdminDAO adao=new AdminDAOImpl();
		
		try {
			adao.changeNonActive(accountNumber);
			System.out.println(ConsoleColors.BANANA_YELLOW+"Status changed successfully!!");
		} catch (SomethingWentWrongException e) {
			System.out.println(e);
		}
   }
   
   
   public static void viewAllInOperative() {
		
		AdminDAO adao=new AdminDAOImpl();
		
		try {
			adao.viewAllInOperative();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e);
		}
	}
   
   public static void viewAllOperative() {
		
		AdminDAO adao=new AdminDAOImpl();
		
		try {
			adao.viewAllOperative();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e);
		}
	}
   
   public static void viewAllclosedAccounts() {
       AdminDAO adao=new AdminDAOImpl();
		
		try {
			adao.viewAllclosedAccounts();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e);
		}
	}
	
   
   public static void transactionReport() {
	   AdminDAO adao=new AdminDAOImpl();
		
		try {
			adao.transactionReport();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e);
		}
   }
   
   public static void highMagnitudeTrans() {
	   AdminDAO adao=new AdminDAOImpl();
		
		try {
			adao.highMagnitudeTrans();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e);
		}
   }
   
}
