/**
 * Java Course 4, Module 3
 * 
 * Java Certification Project
   *
 * @author Jhumel Bonganciso
 */


import java.util.Scanner;

public class PolicyAdminSystemDriver {

	public static void main (String[] args) {
//		Creation of policy admin system object
		PolicyAdminSystem pas = new PolicyAdminSystem();
		
//		Instance variables
		boolean isDone = false;
		Scanner s = new Scanner(System.in);
		int choice;
		
//		Continuous loop for transaction
		do {
			try {
				pas.menu();
				choice = s.nextInt();
				
				switch(choice) {
				case 1: pas.createCustomerAccount();
				break;
				case 2: pas.policyQuoteAndBuy();
				break;
				case 3: pas.cancelAPolicy();
				break;
				case 4: pas.fileAClaim();
				break;
				case 5: pas.searchForCustomerAcct();
				break;
				case 6: pas.searchAndDisplayPolicy();
				break;
				case 7: pas.searchAndDisplayClaim();
				break;
				case 8: isDone = true;
				break;
				default: System.out.println("Choice in only between 1-8");
				}
			} catch (Exception e) {
				s.nextLine();
			}
			
		} while(!isDone);
		
//		Scanner closing
		s.close();
	}
}
