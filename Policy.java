
/**
 * Java Course 4, Module 3
 * 
 * Java Certification Project
   *
 * @author Jhumel Bonganciso
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Policy {

//	Instance variables
  private AccountOwner accountOwner;
  Scanner s = new Scanner(System.in);
  private PolHolder polHolder;
  static long polNumberCounter = 100000;
  private LocalDate effectiveDate;
  private LocalDate expiryDate;
  private LocalDate dateNow = LocalDate.now();
  private ArrayList<Vehicle> vehicles = new ArrayList<>();
  private double policyPremium;
  private RatingEngine ratingEngine;
  private long policyNumber;
  private ArrayList<PolHolder> polholders;
  private ArrayList<String> plateNumbers;
  private IsValid isValid = new IsValid();

//  Constructor
  Policy() {}

  Policy(AccountOwner accountOwner, ArrayList<PolHolder> polholders, ArrayList<String> plateNumbers) {
    setAccountOwner(accountOwner);
    this.polholders = polholders;
    this.plateNumbers = plateNumbers;
  }
  
//  End of constructor

//  Setters and getters method
  public ArrayList<String> getPlateNumbers() {
    return plateNumbers;
    
  }
  public long getPolicyNumber() {
    return policyNumber;
  }

  public void setPolicyNumber(long policyNumber) {
    this.policyNumber = policyNumber;
    
  }


  private long getPolNumberCounter() {
    // TODO Auto-generated method stub
    return polNumberCounter;
  }

  private void setPolNumberCounter() {
    polNumberCounter += 1;
  }

  public void setAccountOwner(AccountOwner accountOwner) {
    this.accountOwner = accountOwner;
  }

  public AccountOwner getAccountOwner() {
    return accountOwner;
  }

 
  public LocalDate getEffectiveDate() {
    return effectiveDate;
  }

  public void setExpiryDate(int monthsToAdd) {
    expiryDate = getEffectiveDate().plusMonths(monthsToAdd);
  }

  public PolHolder getPolHolder() {
    return polHolder;
  }

  public Vehicle newVehicle() {
    return new Vehicle();
  }
  
  public LocalDate getDateNow() {
	    return dateNow;
	  }

	  public void setDateNow(LocalDate dateNow) {
	    this.dateNow = dateNow;
	  }

	  public double getPolicyPremium() {
	    return policyPremium;
	  }

	  public void setPolicyPremium(double policyPremium) {
	    this.policyPremium = policyPremium;
	  }

	  public ArrayList<Vehicle> getVehicles() {
	    return vehicles;
	  }

	  public RatingEngine getRatingEngine() {
	    return ratingEngine;
	  }

	  public void setRatingEngine(
	    ArrayList<Vehicle> vehicles,
	    PolHolder polHolder
	  ) {
	    this.ratingEngine = new RatingEngine(vehicles, polHolder);
	  }
  
	  
	//  Start of prompt methods
//	  Load method for policy creation prompt

  public void load() {
    vehiclePrompt();
    setEffectiveDate();
    setPolHolder();
    setRatingEngine(getVehicles(), getPolHolder());
    setPolicyPremium(getRatingEngine().getPremiumToPay());
    setPolicyNumber(getPolNumberCounter());
    setPolNumberCounter();
  }
  
//  Set policy holder prompt
  public void setPolHolder() {
	    boolean isCorrect = false;
	    int choice = 0;
	    do {
	      try {
	        System.out.println("\nSet policy holder: ");
	        System.out.println("1. Account Owner to be Policy Holder");
	        System.out.println("2. New Policy Holder");
	        System.out.println("3. Choose from existing policy holder");
	        choice = s.nextInt();

	        if (choice == 1 || choice == 2 || choice == 3) {
	          isCorrect = true;
	        } else {
	          System.out.println("Invalid input. Please try again");
	        }
	      } catch (Exception e) {
	        System.out.println("Invalid input.");
	      }
	    } while (!isCorrect);

	    if (choice == 1) {
	      if (polholders.isEmpty()) {
	        polHolder = new PolHolder((CustomerAccountImpl) getAccountOwner());
	      }
	    } else if (choice == 2) {
	      PolHolder custAccountIsPolHolder = isValid.isAccountHolderExistingOnPolholders(
	        (CustomerAccountImpl) getAccountOwner(),
	        polholders
	      );
	      if (custAccountIsPolHolder != null) {
	        polHolder = custAccountIsPolHolder;
	      }
	    } else if(choice == 3) {
	      if (!polholders.isEmpty()) {
	        policyHolderList();
	        choice = s.nextInt();
	        choice -= 1;
	        polHolder = polholders.get(choice);
	      } else {
	        System.out.println("Policy holder list is empty. Please add a new one first.");
	        polHolder = new PolHolder();
	      }
	    }
	  }
  
//  Set effective date prompt
  public void setEffectiveDate() {
	    boolean isCorrect = false;
	    int year, month = 0, day;
	    System.out.println("\nPolicy effectivity date:\n");
	    do {
	      System.out.print("Effectivity year => ");
	      year = s.nextInt();
	      if (year > 1990) {
	        isCorrect = true;
	      } else {
	        System.out.println("\nPlease enter a year above 1990");
	      }
	    } while (!isCorrect);

	    isCorrect = false;
	    do {
	      try {
	        System.out.print("\nMonth of effectivity 1-12 ==> ");
	        month = s.nextInt();
	        if (month > 0 && month < 13) {
	          effectiveDate = LocalDate.of(year, month, 1);
	          isCorrect = true;
	        }
	      } catch (Exception e) {
	        System.out.println("Invalid input. Please try again.");
	      }
	    } while (!isCorrect);

	    isCorrect = false;
	    do {
	      if (effectiveDate.isLeapYear()) {
	        if (month == 2) {
	          System.out.println("\nDay should be from 1 - 29 only");
	          System.out.print("==> ");
	          day = s.nextInt();
	          if (day > 0 && day < 30) {
	            effectiveDate = LocalDate.of(year, month, day);
	            isCorrect = true;
	          }
	        }
	      } else {
	        if (month == 2) {
	          System.out.println("\nDay should be from 1 - 28 only");
	          System.out.print("==> ");
	          day = s.nextInt();
	          if (day > 0 && day < 29) {
	            effectiveDate = LocalDate.of(year, month, day);
	            isCorrect = true;
	          }
	        } else if (
	          month == 1 ||
	          month == 3 ||
	          month == 5 ||
	          month == 7 ||
	          month == 8 ||
	          month == 10 ||
	          month == 12
	        ) {
	          System.out.println("\nDay should be from 1 - 31 only");
	          System.out.print("==> ");
	          day = s.nextInt();
	          if (day > 0 && day < 32) {
	            effectiveDate = LocalDate.of(year, month, day);
	            isCorrect = true;
	          }
	        } else {
	          System.out.println("\nDay should be from 1 - 30 only");
	          System.out.print("==> ");
	          day = s.nextInt();
	          if (day > 0 && day < 31) {
	            effectiveDate = LocalDate.of(year, month, day);
	            isCorrect = true;
	          }
	        }
	      }
	    } while (!isCorrect);

	    setExpiryDate(6);
	  }

  
//  Vehicle creation prompt
  public void vehiclePrompt() {
    System.out.println("How many vehicle you wanted to put in policy? ");
    System.out.print("==> ");
    int numOfVehicle = s.nextInt();

    for (int i = 0; i < numOfVehicle; i++) {
      Vehicle newVehicle = newVehicle();
      if(plateNumbers.isEmpty()) {
       
        vehicles.add(newVehicle);
        plateNumbers.add(newVehicle.getPlateNumber());

      } else {
        if(plateNumbers.contains(newVehicle.getPlateNumber())) {
          System.out.println("Please enter new vehicle as it is associated with another policy. ");
          i--;
        } else {
          vehicles.add(newVehicle);
          plateNumbers.add(newVehicle.getPlateNumber());
        }
      }
    }
  }

//  End of prompt methods

  
//  Start of Display methods
//  Method to show vehicles on this policy
  public void showVehicles() {
    System.out.println("Vehicles on this policy");
    System.out.println("#\tMaker\tModel\tYear\tColor\tPlate number");
    for (int i = 0; i < vehicles.size(); i++) {
      System.out.println((i + 1) + "\t" + vehicles.get(i).toString());
    }
  }
//Method to show Policy holder of this policy
  public void showPolicyHolder() {
    System.out.println("Policy Holder");
    System.out.println(polHolder.toString());
  }

//  To string method
  @Override
  public String toString() {
    return (
      "Policy Number: " +policyNumber  + "\nPolicy Premium: " + policyPremium + "\nPolicy effective date: " + effectiveDate 
      + "\nPolicy Expiration date: " + expiryDate
    );
  }
  
  
//  Display methods
  public void display() {
    System.out.println(toString());
    showPolicyHolder();
    showVehicles();
  }
  
//  List of policy holder method
  public void policyHolderList() {
    System.out.println("List of policy holder(s)");
    for (int i = 0; i < polholders.size(); i++) {
      System.out.println((i + 1) + " " + polholders.get(i).fullName());
    }
  }
}
