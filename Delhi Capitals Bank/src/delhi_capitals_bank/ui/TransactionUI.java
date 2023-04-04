package delhi_capitals_bank.ui;

import java.util.Scanner;

import delhi_capitals_bank.colors.ConsoleColors;
import delhi_capitals_bank.dao.TransactionDAO;
import delhi_capitals_bank.dao.TransactionDAOImpl;
import delhi_capitals_bank.exceptions.NoRecordFoundException;
import delhi_capitals_bank.exceptions.SomethingWentWrongException;

public class TransactionUI {
	
	  //all transaction operations an user can perform 
      public static void transactionOperation(Scanner sc) {

    	  String choice="0";
    	  
    	  do {
    		  System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+"1. Deposit money");
    		  System.out.println("2. Withdraw money");
    		  System.out.println("3. Balance enquiry");
    		  System.out.println("4. Change pin");
    		  System.out.println("5. Check transaction history");
    		  System.out.println("6. Transfer money from one account to another");
    		  System.out.println("7. Close bank account");
    		  System.out.println("0. Exit");
    		  
    		  System.out.print("Enter Selection : ");
    		  
    		  choice=sc.next();
    		  switch(choice) {
    		  case "1": depositMoney(sc);
    			  break;
    		  case "2": withdrawMoney(sc);
    			  break;
    		  case "3": balanceEnquiry(sc);
    			  break;
    		  case "4": changePin(sc);
    			  break;
    		  case "5": checkHistory(sc);
    			  break;
    		  case "6": transferMoney(sc);
    			  break;
    		  case "7": closeAccount(sc);
    		  break;
    		  case "0": BankAccountUI.alreadyBankAcountLogout();
    		  System.out.println(ConsoleColors.BANANA_YELLOW+"Thanks for your time.. Please Visit again!! Bye Bye");
    		    break;
    		  default: System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid choice try again!!");
    		  }
    	  }while(!choice.equals("0"));
    	   
      }
      
      //To check the balance of your bank account
      public static void balanceEnquiry(Scanner sc) {
    	  System.out.print(ConsoleColors.ROSY_PINK+"Enter your pin : ");
    	  int pinNumber=sc.nextInt();
    	  
    	  TransactionDAO tdao=new TransactionDAOImpl();
    	  
    	  try {
			Long bal=tdao.balanceEnquiry(pinNumber);
			System.out.println(ConsoleColors.PURPLE_ITALIC+"Your account balance is "+bal);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e);
		}
      }
      
      
      //To add the money into your bank account
      public static void depositMoney(Scanner sc) {
    	  System.out.print(ConsoleColors.CYAN_BOLD_BRIGHT+"Enter amount : ");
    	  Long bal=sc.nextLong();
    	  System.out.print("Enter your pin number : ");
    	  int pinNumber=sc.nextInt();
    	  
    	  TransactionDAO tdao=new TransactionDAOImpl();
    	  
    	  try {
			tdao.depositMoney(bal, pinNumber);
		} catch (SomethingWentWrongException e) {
			
			System.out.println(e);
		}
    	  		  
      }
      
      
      //To withdraw money from bank account
      public static void withdrawMoney(Scanner sc) {
    	  System.out.print(ConsoleColors.FOREST_GREEN+"Enter amount : ");
    	  Long bal=sc.nextLong();
    	  System.out.print("Enter your pin number : ");
    	  int pinNumber=sc.nextInt();
    	  
    	  TransactionDAO tdao=new TransactionDAOImpl();
    	  
    	  try {
			tdao.withdrawMoney(bal, pinNumber);
		} catch (SomethingWentWrongException e) {
			
			System.out.println(e);
		}
    	  		  
      }
      
      
      //To change Pin Number of Bank account
      public static void changePin(Scanner sc) {
    	  
    	  System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT+"Enter old pin number : ");
    	  int oldpin=sc.nextInt();
    	  System.out.print("Enter new pin number : ");
    	  int newpin=sc.nextInt();
    	  System.out.print("Re-enter pin number : ");
    	  int renewpin=sc.nextInt();
    	  
    	  TransactionDAO tdao=new TransactionDAOImpl();
    	  
    	  try {
			tdao.changePin(oldpin, newpin, renewpin);
			System.out.println(ConsoleColors.BANANA_YELLOW+"Pin changed Successfully!!");
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			
			System.out.println(e);
		}
    	  
      }
      
      
      //To check the history
      public static void checkHistory(Scanner sc) {
    	  System.out.print(ConsoleColors.YELLOW_BOLD+"Enter pin number : ");
    	  int pinNumber=sc.nextInt();
    	  
    	  TransactionDAO tdao=new TransactionDAOImpl();
    	  
    	  try {
    		  System.out.println(ConsoleColors.BANANA_YELLOW+"Your Transaction History");
			tdao.checkHistory(pinNumber);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(e);
		}
      }
      
      
      //To  transfer the money from one bank account to another
      public static void transferMoney(Scanner sc) {
    	  System.out.print(ConsoleColors.ORANGE+"Enter your account number : ");
    	  Long accountNumber=sc.nextLong();
    	  System.out.print("Enter account number in which amount is to be transferred : ");
    	  Long daccountNumber=sc.nextLong();
    	  System.out.print("Enter amount : ");
    	  Long amount=sc.nextLong();
    	  System.out.print("Enter pin Number : ");
    	  int pinNumber=sc.nextInt();
    	  
    	  TransactionDAO tdao=new TransactionDAOImpl();
    	  
    	  try {
			tdao.transferMoney(accountNumber, daccountNumber, amount, pinNumber);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
	
			System.out.println(e);
		}
    	    
      }
      
      //To close bank account
      public static void closeAccount(Scanner sc) {
    	  System.out.print(ConsoleColors.BLUE_BOLD_BRIGHT+"Enter account number : ");
    	  Long accountNumber=sc.nextLong();
    	  System.out.print("Enter pin number : ");
    	  int pinNumber=sc.nextInt();
    	  
    	  TransactionDAO tdao=new TransactionDAOImpl();
    	  
    	  try {
			tdao.closeAccount(accountNumber, pinNumber);
		} catch (SomethingWentWrongException e) {
			
			System.out.println(e);
		}
    	 
      }
      
}
