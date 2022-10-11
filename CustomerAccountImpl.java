/**
 * Java Course 4, Module 3
 * 
 * Java Certification Project
   *
 * @author Jhumel Bonganciso
 */

import java.util.ArrayList;
import java.util.List;

// Customer account Implementation of CustomerAccountInterface
public class CustomerAccountImpl
  extends AccountOwner
  implements CustomerAccountInterface {

  AccountOwner accountOwner;
  private int accountNumber;
  private static int accountNumberCounter = 1000;
  List<Policy> policies = new ArrayList<>();
  ArrayList<PolHolder> polholders = new ArrayList<>();
  
//  Constructor 
  CustomerAccountImpl() {
    accountOwner = super.load();
    setAccountNumber(getAccountNumberCounter());
    setAccountNumberCounter();
  }
  
//  Override method from customerAccountInterface
  @Override
  public void listOfPolicies() {
    // TODO Auto-generated method stub
    if (policies.isEmpty()) {
      System.out.println("There is no policy on the account.");
    } else {
      System.out.println("Policies on the account");
      for (int i = 0; i < policies.size(); i++) {
        System.out.println((i + 1) + " " + policies.get(i).getPolicyNumber());
      }
    }
  }

  @Override
  public void listOfPolHolders() {
    // TODO Auto-generated method stub
    if (polholders.isEmpty()) {
      System.out.println("There is no enrolled policy holder on the account");
    } else {
      System.out.println("Policy holders on the account");
      for (int i = 0; i < polholders.size(); i++) {
        System.out.println((i + 1) + " " + polholders.get(i).toString());
      }
    }
  }
  
//End of override method from customerAccountInterface
  
//  Setter and getter
  public AccountOwner getOwner() {
    return accountOwner;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(int accountNumber) {
    this.accountNumber = accountNumber;
  }

  public static int getAccountNumberCounter() {
    return accountNumberCounter;
  }

  public static void setAccountNumberCounter() {
    CustomerAccountImpl.accountNumberCounter += 1;
  }

  public ArrayList<PolHolder> getPolholders() {
    return polholders;
  }
  
//end of Setter and getter method

//  to string method
  @Override
  public String toString() {
    return (
      "Customer Account" +
      "\nAccount number: " +
      accountNumber +
      "\n" +
      "Account owner: " +
      getOwner().getFirstName() +
      " " +
      getOwner().getLastName()
    );
  }
  
//  Display method
  public void display() {
    toString();
    listOfPolicies();
    listOfPolHolders();
  }
}
