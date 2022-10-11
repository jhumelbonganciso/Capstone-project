import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Validation class for input
public class IsValid {

  Scanner s = new Scanner(System.in);
  
//  method to check if customer is existing given that customer should be assumed as unique
  public boolean isExistingCustomerAccount(
    ArrayList<CustomerAccountImpl> customerAccounts,
    CustomerAccountImpl customerAccount
  ) {
    for (CustomerAccountImpl account : customerAccounts) {
      if (
        account
          .getOwner()
          .getFirstName()
          .equalsIgnoreCase(customerAccount.getOwner().getFirstName())
      ) {
        if (
          account
            .getOwner()
            .getLastName()
            .equalsIgnoreCase(customerAccount.getOwner().getLastName())
        ) {
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    }
    return false;
  }
  
//  checker to see if policy holder is empty
  public boolean isPolHolderEmpty(CustomerAccountImpl customerAccount) {
    if (customerAccount.polholders.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }
  
//checker to see if account owner is policy holder
  public PolHolder isAccountHolderExistingOnPolholders(
    CustomerAccountImpl account,
    ArrayList<PolHolder> polholders
  ) {
    for (PolHolder polHolder : polholders) {
      if (account.getFirstName().equalsIgnoreCase(polHolder.getFirstName())) {
        if (account.getLastName().equalsIgnoreCase(polHolder.getLastName())) {
          return polHolder;
        } else {
          return null;
        }
      } else {
        return null;
      }
    }
    return null;
  }

//  to check if user wanted to add policy
  public boolean toAddPol() {
    boolean isCorrect = false;
    boolean toAdd = false;
    do {
      System.out.println("Do you want to add it to your policy? ");
      System.out.println("Enter y or Y to add or Enter n or N to cancel");
      System.out.print("==> ");
      String toAddPolicy = s.nextLine();
      if (toAddPolicy.equalsIgnoreCase("y")) {
        isCorrect = true;
        toAdd =  true;
      } else if(toAddPolicy.equalsIgnoreCase("n")) {
        isCorrect = true;
        toAdd = false;
      }
    } while (!isCorrect);
    
    return toAdd;
    
    
  }
//to check if user wanted to cancel policy
  public boolean cancelPol() {
    String toCancelPolicy;
    boolean isCorrect = false;
    boolean toRemove = false;
    do {
      System.out.println("Do you really wanted to cancel this policy? ");
      System.out.println("Enter y or Y to add or Enter n or N to cancel");
      System.out.print("==> ");
      toCancelPolicy = s.nextLine();
      if (toCancelPolicy.equalsIgnoreCase("y")) {
        toRemove = true;
        isCorrect = true;
      } else if (toCancelPolicy.equalsIgnoreCase("n")) {
        toRemove = false;
        isCorrect = true;
      }
    } while (!isCorrect);
    return toRemove;
  }
  
//  checker to check if customer first name is on list
  public boolean isFirstNameOnList(
    ArrayList<CustomerAccountImpl> customerAccounts
  ) {
    String fName;
    boolean isOnList = false;
    System.out.println("Please enter customer first name");
    System.out.print("==> ");
    fName = s.nextLine();
    for (CustomerAccountImpl customerAccountImpl : customerAccounts) {
      if (fName.equalsIgnoreCase(customerAccountImpl.getFirstName())) {
        isOnList = true;
      }
    }

    return isOnList;
  }

//checker to check if customer last name is on list
  public CustomerAccountImpl isLastNameOnList(
    ArrayList<CustomerAccountImpl> customerAccounts
  ) {
    String lName;
    boolean isOnList = false;
    System.out.println("Please enter customer last name");
    System.out.print("==> ");
    lName = s.nextLine();
    for (CustomerAccountImpl customerAccountImpl : customerAccounts) {
      if (
        lName.equalsIgnoreCase(customerAccountImpl.getOwner().getLastName())
      ) {
        isOnList = true;
        return customerAccountImpl;
      }
    }
    return null;
  }
}
