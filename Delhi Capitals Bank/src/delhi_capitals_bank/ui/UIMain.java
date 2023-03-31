package delhi_capitals_bank.ui;

import java.util.Scanner;

import delhi_capitals_bank.colors.ConsoleColors;



public class UIMain {
	
	//Administrator menu method
	public static void adminMenu(Scanner sc) {
		int choice=0;
		do {
			System.out.println(ConsoleColors.TEAL+"1. View all customers information");
			System.out.println("2. View customer by customer_id");
			System.out.println("3. View all accounts information");
			System.out.println("------------------------");
			System.out.println("4. View particular account by account_number");
			System.out.println("5. Change status of inoperative accounts from last 24 months");
			System.out.println("6. View all inoperative accounts");
			System.out.println("7. View all closed accounts");
			System.out.println("-----------------------");
			System.out.println("8. Transaction report day wise of all accounts");
			System.out.println("9. See all high magnitude transaction of a day");
			System.out.println("0. Logout");
			
			System.out.print("Enter Selection : ");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:  //
				break;
			case 2:  //
				break;
			case 3: // 
				break;
			case 4: // 
				break;
			case 5: // 
				break;
			case 6: // 
				break;
			case 7: // 
				break;
			case 8: // 
				break;
			case 9: //
				break;
			case 0:System.out.println(ConsoleColors.BANANA_YELLOW+"Thanks for your time!! Bye Bye admin");	
			 break;
			default:System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid Selection... Please try again");
			}
		
		}while(choice!=0);
		
	}
	
	
	
	//Administrator or accountant signIn method
	public static void adminSignIn(Scanner sc) {
		System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT+"Enter UserName : ");
		String username=sc.next();
		System.out.print("Enter Password : ");
		String password=sc.next();
		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			adminMenu(sc);
		}else {
			System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Wrong username and password!! Please try again.");
		}
	}
	
	
	//User or Customer Menu
	public static void displayUserMenu() {
		System.out.println(ConsoleColors.ORANGE+"1. Open a bank account");
		System.out.println("2. Already having an account");
		System.out.println("3. Change password of login account");
		System.out.println("4. Update details of login account");
		System.out.println("5. Delete Login account");
		System.out.println("0. Logout");
		
	}
	
	public static void  userSignIn(Scanner sc) {
	    if(!UserUI.userSignIn(sc)) {
			System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid Username and Password");
			return;
		 }
		
		int choice=0;
		
		do {
			displayUserMenu();
			System.out.print(ConsoleColors.ORANGE+"Enter Selection : ");
			choice=sc.nextInt();
			switch(choice) {
			case 1: BankAccountUI.openBankAccount(sc);
			    break;
			case 2: BankAccountUI.alreadyBankAccount(sc);
				break;
			case 3://
				break;
			case 4://
				break;
			case 5://
				break;
			case 0:UserUI.userLogout();
				System.out.println(ConsoleColors.BANANA_YELLOW+"Thank you for your time.. Please visit again");
				break;
			default:System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid Selection.. Try again!");
			    break;
			}
			
		}while(choice!=0);
	}
	
	
	//main method
   public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
		
	 int choice=0;
	 do {
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"1. Admin SignIn");
		System.out.println("2. User SignIn");
		System.out.println("3. User SignUp");
		System.out.println("0. Exit");
		
		System.out.print("Enter the selection : ");
		choice=sc.nextInt();
		
		switch(choice) {
		case 1: adminSignIn(sc);
			break;
		case 2: userSignIn(sc);
			break;
		case 3: UserUI.userSignUp(sc);
			break;
		case 0: System.out.println(ConsoleColors.BANANA_YELLOW+"Thanks for using our Service!!");
		   break;
		default: System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid Selection!! Please try again");
		   break;
		}
		
	}while(choice!=0);
	
	sc.close();
}
}

