package delhi_capitals_bank.ui;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import delhi_capitals_bank.colors.ConsoleColors;
import delhi_capitals_bank.dao.BankAccountDAO;
import delhi_capitals_bank.dao.BankAccountDAOImpl;
import delhi_capitals_bank.dao.UserLogged;
import delhi_capitals_bank.dto.BankAccountDTO;
import delhi_capitals_bank.dto.BankAccountDTOImpl;
import delhi_capitals_bank.exceptions.NoRecordFoundException;
import delhi_capitals_bank.exceptions.SomethingWentWrongException;

public class BankAccountUI {
	
	//method for opening a new bank account
   public static void openBankAccount(Scanner sc) {
	   Random ran=new Random();
	   Long number=Math.abs((ran.nextLong()%9000L)+1000L);
	   System.out.println(ConsoleColors.RED_ITALIC+"Application Form No. : "+number);
	   System.out.println("---------------------------");
	   
	   System.out.print(ConsoleColors.BLUE_BOLD_BRIGHT+"Enter name : ");
	   String name=sc.next();
	   System.out.print("Enter father's name : ");
	   String fname=sc.next();
	   System.out.print("Enter date of birth : ");
	   LocalDate dob=LocalDate.parse(sc.next());
	   System.out.print("Enter gender(M/F) : ");
	   String gender=sc.next();
	   System.out.print("Enter email address : ");
	   String email=sc.next();
	   System.out.print("Enter martial status(married/unmarried/other : ");
	   String martial=sc.next();
	   System.out.print("Enter address : ");
	   String address=sc.next();
	   System.out.print("Enter Income : ");
	   int income=sc.nextInt();
	   System.out.print("Enter type of account(saving/loan) : ");
	   String type=sc.next();
	   System.out.print("Enter services required(chequebook,ATMcard,InternetBanking) : ");
	   String service=sc.next();
	   
	   BankAccountDTO bdto=new BankAccountDTOImpl(name,fname,dob,gender,email,martial,address,income,type,service);
	   
	   BankAccountDAO bdao=new BankAccountDAOImpl();
	   
	   try {
		bdao.openBankAccount(bdto);
		System.out.println(ConsoleColors.BANANA_YELLOW+"Bank Account Opened Successfully!!");
		System.out.println(ConsoleColors.WHITE_ITALIC+"Your Account Number : "+BankAccountDAOImpl.accountNumber);
		System.out.println("Your Pin Number : "+BankAccountDAOImpl.pinNumber);
		System.out.println("------------------------");
		
    	} catch (SomethingWentWrongException e) {
		System.out.println(e);
	    } 
   }
   
    //already having account of customers
    public static void alreadyBankAccount(Scanner sc) {
	   System.out.print(ConsoleColors.BLUE_BOLD+"Enter account number : ");
	   Long accountNumber=sc.nextLong();
	   System.out.print("Enter pin number : ");
	   int pinNumber=sc.nextInt();
	   
	   BankAccountDAO bdao=new BankAccountDAOImpl();
	   
	   try {
		boolean res=bdao.alreadyBankAccount(accountNumber, pinNumber);
		if(res==true && UserLogged.UserLoggedInId!=0) {
		  System.out.println(ConsoleColors.BANANA_YELLOW+"Logged In Successfully in Bank Account!!");
	    	TransactionUI.transactionOperation(sc);
		    }
	     } catch (SomethingWentWrongException | NoRecordFoundException e) {
	       System.out.println(e);
	  }
    
    }
    
    public static void alreadyBankAcountLogout() {
    	UserLogged.UserLoggedInId=0;
    }
}
