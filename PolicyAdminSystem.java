/**
 * Java Course 4, Module 3
 * 
 * Java Certification Project
   *
 * @author Jhumel Bonganciso
 */


import java.util.ArrayList;
import java.util.Scanner;

public class PolicyAdminSystem {

//	Instance class
  ArrayList<CustomerAccountImpl> customerAccounts = new ArrayList<>();
  ArrayList<String> plateNumbers = new ArrayList<>();
  ArrayList<Claim> claims = new ArrayList<>();
  IsValid isExisting = new IsValid();
  Scanner s = new Scanner(System.in);
  int choice;

//  Create customer method
  public void createCustomerAccount() {
    boolean checker = false;
    System.out.println("How many customer account you wanted to create? ");
    System.out.print("==> ");

    try {
      choice = s.nextInt();
      if (choice > 0) {
        if (customerAccounts.isEmpty()) {
          customerAccounts.add(new CustomerAccountImpl());
          System.out.println("\nAccount created successfully\n");
          System.out.println(
            "Your account number is " +
            customerAccounts
              .get(customerAccounts.size() - 1)
              .getAccountNumber() +
            "\n"
          );
        } else {
          CustomerAccountImpl newCustomer = new CustomerAccountImpl();
          checker =
            isExisting.isExistingCustomerAccount(customerAccounts, newCustomer);
          if (checker) {
            System.out.println("Sorry. Customer is already existing.");
            System.out.println("Will now go back to main menu");
            return;
          } else {
            System.out.println("\nAccount created successfully\n");
            customerAccounts.add(newCustomer);
            System.out.println(
              "Your account number is " +
              customerAccounts
                .get(customerAccounts.size() - 1)
                .getAccountNumber() +
              "\n"
            );
          }
        }
      }
    } catch (Exception e) {
      s.nextLine();
      System.out.println("Invalid input. Will go back to main menu.");
      return;
    }
  }

//Create policy method
  public void policyQuoteAndBuy() {
    boolean checker = false;
    boolean isEmptyPolHolders = false;
    System.out.println("Please enter customer account number");
    System.out.print("==> ");
    try {
      choice = s.nextInt();
    } catch (Exception e) {
      s.nextLine();
      System.out.println("Invalid input. Will go back to main menu.");
      return;
    }

    for (CustomerAccountImpl account : customerAccounts) {
      if (account.getAccountNumber() == choice) {
        checker = true;

        Policy policy = new Policy(
          account,
          account.getPolholders(),
          plateNumbers
        );
        policy.load();
        System.out.println(
          "Your policy premium balance quote is " + policy.getPolicyPremium()
        );
        boolean addToAccount = isExisting.toAddPol();
        if (addToAccount) {
          account.polholders.add(policy.getPolHolder());
          account.policies.add(policy);
          System.out.println("Policy successfully added!\n");
          System.out.println(
            "Your policy number is " + policy.getPolicyNumber() + "\n"
          );
          for (String plates : policy.getPlateNumbers()) {
            plateNumbers.add(plates);
          }
          
        } else {
          System.out.println("Policy is not added");
        }

        if (policy
            .getPolHolder()
            .getFirstName()
            .equalsIgnoreCase(account.getFirstName())
        ) {
          if (
            !policy
              .getPolHolder()
              .getLastName()
              .equalsIgnoreCase(account.getLastName())
          ) {
            account.polholders.add(policy.getPolHolder());
          } else {
            return;
          }
        } else {
          account.polholders.add(policy.getPolHolder());
        }
      }
    }

    if (!checker) {
      System.out.println("Customer Account do not exist");
    }
  }
//Cancel policy method
  public void cancelAPolicy() {
    boolean isExistingPol = false;
    System.out.println("Please enter the Policy Number");
    System.out.print("==> ");
    try {
      choice = s.nextInt();
    } catch (Exception e) {
      s.nextLine();
      System.out.println("Invalid. Will go back to main menu.");
      return;
    }
    for (CustomerAccountImpl account : customerAccounts) {
      for (Policy pol : account.policies) {
        if (choice == pol.getPolicyNumber()) {
          isExistingPol = true;
          boolean toRemove = isExisting.cancelPol();
          if (toRemove) {
            account.policies.remove(pol);
            System.out.println("Policy Remove Successfully! \n");
          } else {
            return;
          }
        }
      }
    }

    if (!isExistingPol) {
      System.out.println(
        "\nPolicy is not on the system. Will now go back to main menu.\n"
      );
    }
  }

//Create claim method
  public void fileAClaim() {
    boolean isExistingPol = false;
    System.out.println("Please enter the Policy Number");
    System.out.print("==> ");
    try {
      choice = s.nextInt();
    } catch (Exception e) {
      s.nextLine();
      System.out.println("Invalid. Will go back to main menu.");
      return;
    }

    for (CustomerAccountImpl account : customerAccounts) {
      for (Policy pol : account.policies) {
        if (choice == pol.getPolicyNumber()) {
          isExistingPol = true;
          claims.add(new Claim(pol));
        }
      }
    }

    if (!isExistingPol) {
      System.out.println("Policy is not existing.");
    }
  }

//Search for customer account
  public void searchForCustomerAcct() {
    boolean fName = isExisting.isFirstNameOnList(customerAccounts);
    if (fName) {
      CustomerAccountImpl account = isExisting.isLastNameOnList(
        customerAccounts
      );
      if (account == null) {
        System.out.println("Account do not exist");
      } else {
        account.display();
      }
    }
  }
  
// Search for Policy 
  public void searchAndDisplayPolicy() {
    boolean isExistingPol = false;
    System.out.println("Please enter the Policy Number");
    System.out.print("==> ");
    try {
      choice = s.nextInt();
    } catch (Exception e) {
      s.nextLine();
      System.out.println("Invalid. Will go back to main menu.");
      return;
    }
    for (CustomerAccountImpl account : customerAccounts) {
      for (Policy pol : account.policies) {
        if (choice == pol.getPolicyNumber()) {
          isExistingPol = true;
          if (isExistingPol) {
            pol.display();
          }
        }
      }
    }

    if (!isExistingPol) {
      System.out.println("Policy is not on the system");
    }
  }

//Search for Policy Claim
  public void searchAndDisplayClaim() {
    String claimNumber;
    boolean isExistingClaim = false;
    System.out.println("Please enter claim number");
    System.out.print("==> ");
    claimNumber = s.nextLine();

    for (Claim claim : claims) {
      if (claim.getClaimNumber().equalsIgnoreCase(claimNumber)) {
        isExistingClaim = true;
        System.out.println(claim.toString());;
      }
    }

    if (!isExistingClaim) {
      System.out.println(
        "\nClaim number do not exist. Will go back to main menu.\n"
      );
    }
  }

//  menu text
  public void menu() {
    System.out.println("Welcome to Policy Administration System\n");
    System.out.println("1. Create a new Customer Account");
    System.out.println("2. Get a policy quote and buy the policy");
    System.out.println("3. Cancel a policy");
    System.out.println("4. File an accident claim against a policy.");
    System.out.println("5. Search for a Customer account ");
    System.out.println("6. Seach for and display for specific policy");
    System.out.println("7. Search for and display a specific claim");
    System.out.println("8. Exit the PAS System");
    System.out.print("==> ");
  }
}
