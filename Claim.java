/**
 * Java Course 4, Module 3
 * 
 * Java Certification Project
   *
 * @author Jhumel Bonganciso
 */


import java.time.LocalDate;
import java.util.Scanner;

public class Claim {

//	Instance variables
  private static long claimCounter = 10000;
  private LocalDate dateOfAccident;
  private String addressOfAccident;
  private String descriptionOfAccident;
  private String descriptionOfDamageToVehicle;
  private long costOfRepairs;
  private String claimNumber = "C";
  private Policy policy;
  LocalDate dateNow = LocalDate.now();

  Scanner s = new Scanner(System.in);

//  Constructors
  Claim(){}
  Claim(Policy policy) {
    this.policy = policy;
    load();
  }

//  Load method as prompt
  public void load() {
    
    setAddressOfAccident();
    setDescriptionOfAccident();
    setDescriptionOfDamageToVehicle();
    setCostOfRepairs();
    setClaimNumber(getClaimNumber(), claimCounter);
    setDateOfAccident();
    System.out.println("Claim filed successfully");
    System.out.println("Your claim number is " + getClaimNumber());
  }
  
//  Setters and getters
  public String getClaimNumber() {
    return claimNumber;
  }

  public void setClaimNumber(String claimNumber, long claimCounter) {
    claimNumber += String.valueOf(claimCounter);
    this.claimNumber = claimNumber;
    setClaimCounter();
  }

  public static long getClaimCounter() {
    return claimCounter;
  }

  public static void setClaimCounter() {
    Claim.claimCounter += 1;
  }

  public LocalDate getDateOfAccident() {
    return dateOfAccident;
  }

  public void setDateOfAccident() {
    int year, month, day;

    do {
      System.out.print("Year of accident ==> ");
      year = s.nextInt();
      if (year > dateNow.getYear()) {
        System.out.println(
          "Invalid year. Accident year should be less than or equal to " +
          dateNow.getYear()
        );
      }
    } while (year > dateNow.getYear());

    boolean isCorrect = false;
    do {
      System.out.print("Month of accident 1-12 ==> ");
      month = s.nextInt();

      if (dateNow.getYear() == year) {
        if (month <= dateNow.getMonthValue()) {
          isCorrect = true;
        } else {
          System.out.println(
            "Available month should be from " +
            dateNow.getMonth() +
            " backwards."
          );
        }
      } else if (year < dateNow.getYear()) {
        if (month > 0 && month < 13) {
          isCorrect = true;
        }
      }
    } while (!isCorrect);
    dateOfAccident = LocalDate.of(year, month, 1);

    isCorrect = false;
    do {
      if (dateOfAccident.isLeapYear()) {
        if (month == 2) {
          System.out.println("Day should be from 1 - 29 only");
          System.out.print("==> ");
          day = s.nextInt();
          if (day > 0 && day < 30) {
            isCorrect = true;
          }
        }
      } else {
        if (month == 2) {
          System.out.println("Day should be from 1 - 28 only");
          System.out.print("==> ");
          day = s.nextInt();
          if (day > 0 && day < 29) {
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
          System.out.println("Day should be from 1 - 31 only");
          System.out.print("==> ");
          day = s.nextInt();
          if (day > 0 && day < 32) {
            isCorrect = true;
          }
        } else {
          System.out.println("Day should be from 1 - 30 only");
          System.out.print("==> ");
          day = s.nextInt();
          if (day > 0 && day < 31) {
            isCorrect = true;
          }
        }
      }
    } while (!isCorrect);
  }

  public String getAddressOfAccident() {
    return addressOfAccident;
  }

  public void setAddressOfAccident() {
    String address;
    System.out.print("Address of incident ==> ");
    address = s.nextLine();
    addressOfAccident = address;
  }

  public String getDescriptionOfAccident() {
    return descriptionOfAccident;
  }

  public void setDescriptionOfAccident() {
    System.out.print("Description of incident ==> ");
    String desc = s.nextLine();
    descriptionOfAccident = desc;
  }

  public String getDescriptionOfDamageToVehicle() {
    return descriptionOfDamageToVehicle;
  }

  public void setDescriptionOfDamageToVehicle() {
    System.out.print("Description of damage to vehicle ==> ");
    String desc = s.nextLine();
    descriptionOfDamageToVehicle = desc;
  }

  public long getCostOfRepairs() {
    return costOfRepairs;
  }

  public void setCostOfRepairs() {
    boolean isCorrect = false;
    long cost;
    do {
      try {
        System.out.print("Estimated cost of repairs ==> ");
        cost = s.nextLong();
        costOfRepairs = cost;
        if (cost > 0) {
          isCorrect = true;
        }
      } catch (Exception e) {
        s.nextLine();
        System.out.println("Invalid input. Please Try again");
      }
    } while (!isCorrect);
  }
  
//end of Setters and getters
  
//  To string method for display
  @Override
  public String toString() {
    return (
      "Claim for policy number: " + policy.getPolicyNumber() +
      "\nClaim Number: " +
      claimNumber +
      "\nDate of accident: " +
      dateOfAccident +
      "\nAddress of accident: " +
      addressOfAccident +
      "\nDescription of accident: " +
      descriptionOfAccident +
      "\nDescription of damage to vehicle: " +
      descriptionOfDamageToVehicle +
      "\nCost of repairs: " +
      costOfRepairs
    );
  }
}
