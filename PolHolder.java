/**
 * Java Course 4, Module 3
 * 
 * Java Certification Project
   *
 * @author Jhumel Bonganciso
 */

import java.time.LocalDate;
import java.util.Scanner;

public class PolHolder {

//	Instance variables
  Scanner scn = new Scanner(System.in);
  LocalDate localDate = LocalDate.now();
  private String firstName;
  private String lastName;
  LocalDate dateOfBirth;
  private String address;
  private String licenseNumber;
  LocalDate licensedIssuedDate;
  private AccountOwner accountOwner;

//  Constructor function
  PolHolder() {
    load();
  }

  PolHolder(CustomerAccountImpl account) {
    setFirstName(account.getFirstName());
    setLastName(account.getLastName());
    setAddress(account.getAddress());
    birthDatePrompt();
    licenseDatePrompt();
  }

//  load method as prompt
  public void load() {
    System.out.println("Enter first name ==> ");
    setFirstName(scn.nextLine());

    System.out.println("Enter lastName name ==> ");
    setLastName(scn.nextLine());

    System.out.println("Enter address ==> ");
    setAddress(scn.nextLine());

    birthDatePrompt();
    licenseDatePrompt();
  }

//  Full name method
  public String fullName() {
    return firstName + " " + lastName;
  }

//  Birthday prompt
  public void birthDatePrompt() {
    int yearOfBirth;
    int monthOfBirth;
    int dayOfBirth;
    boolean isCorrect = false;
    System.out.println("\nPlease enter date of birth:");
    setDateOfBirth(localDate);

    do {
      System.out.print("\nYear of Birth ==> ");
      yearOfBirth = scn.nextInt();
      if (yearOfBirth > 2004) {
        System.out.println(
          "You should be 18 years old to be a policy holder\n"
        );
      } else {
        dateOfBirth.of(yearOfBirth, 1, 1);
        isCorrect = true;
      }
    } while (!isCorrect);

    isCorrect = false;
    do {
      System.out.print("\nMonth of Birth (1-12) ==> ");
      monthOfBirth = scn.nextInt();
      if (monthOfBirth > 0 && monthOfBirth < 13) {
        dateOfBirth.of(yearOfBirth, monthOfBirth, 1);
        isCorrect = true;
      } else {
        System.out.println("\nInvalid choice. Please try again.");
      }
    } while (!isCorrect);

    do {
      boolean leap = dateOfBirth.isLeapYear();

      if (leap) {
        if (monthOfBirth == 2) {
          System.out.print("\nDay of Birth (1-29) ==> ");
          dayOfBirth = scn.nextInt();
          if (dayOfBirth > 0 && dayOfBirth < 30) {
            dateOfBirth.of(yearOfBirth, monthOfBirth, dayOfBirth);
            isCorrect = true;
          } else {
            System.out.println("\nPlease try again");
          }
        }
      } else {
        if (monthOfBirth == 2) {
          System.out.print("\nDay of Birth (1-28) ==> ");
          dayOfBirth = scn.nextInt();
          if (dayOfBirth > 0 && dayOfBirth < 29) {
            dateOfBirth.of(yearOfBirth, monthOfBirth, dayOfBirth);
            isCorrect = true;
          } else {
            throw new IllegalArgumentException();
          }
        } else if (
          monthOfBirth == 1 ||
          monthOfBirth == 3 ||
          monthOfBirth == 5 ||
          monthOfBirth == 7 ||
          monthOfBirth == 8 ||
          monthOfBirth == 10 ||
          monthOfBirth == 12
        ) {
          System.out.print("\nDay of Birth (1-31) ==> ");
          dayOfBirth = scn.nextInt();
          if (dayOfBirth > 0 && dayOfBirth < 32) {
            dateOfBirth.of(yearOfBirth, monthOfBirth, dayOfBirth);
            isCorrect = true;
          } else {
            System.out.println("\nPlease try again");
          }
        } else {
          System.out.print("\nDay of Birth (1-30) ==> ");
          dayOfBirth = scn.nextInt();
          if (dayOfBirth > 0 && dayOfBirth < 31) {
            dateOfBirth.of(yearOfBirth, monthOfBirth, dayOfBirth);
            isCorrect = true;
          } else {
            System.out.println("\nPlease try again");
          }
        }
      }
    } while (!isCorrect);
  }

//License day prompt
  public void licenseDatePrompt() {
    int yearOflicense;
    int monthOflicense;
    int dayOflicense;
    boolean isCorrect = false;
    System.out.println("\nPlease enter license details as asked");
    setLicensedIssuedDate(localDate);

    do {
      System.out.print("\nYear of license release ==> ");
      yearOflicense = scn.nextInt();
      if (yearOflicense <= localDate.getYear()) {
        licensedIssuedDate.of(yearOflicense, 1, 1);
        isCorrect = true;
      } else {
        System.out.println("\nPlease try again");
      }
    } while (!isCorrect);

    do {
      System.out.print("\nMonth of license release (1-12) ==> ");
      monthOflicense = scn.nextInt();
      if (monthOflicense > 0 && monthOflicense < 13) {
        licensedIssuedDate.of(yearOflicense, monthOflicense, 1);
        isCorrect = true;
      } else {
        System.out.println("\nPlease try again");
      }
    } while (!isCorrect);

    isCorrect = false;

    do {
      boolean leap = dateOfBirth.isLeapYear();

      if (leap) {
        if (monthOflicense == 2) {
          System.out.print("\nDay of Birth (1-29) ==> ");
          dayOflicense = scn.nextInt();
          if (dayOflicense > 0 && dayOflicense < 30) {
            licensedIssuedDate.of(yearOflicense, monthOflicense, dayOflicense);
            isCorrect = true;
          } else {
            System.out.println("\nPlease try again");
          }
        }
      } else {
        if (monthOflicense == 2) {
          System.out.print("\nDay of Birth (1-28) ==> ");
          dayOflicense = scn.nextInt();
          if (dayOflicense > 0 && dayOflicense < 29) {
            licensedIssuedDate.of(yearOflicense, monthOflicense, dayOflicense);
            isCorrect = true;
          } else {
            System.out.println("\nPlease try again");
          }
        } else if (
          monthOflicense == 1 ||
          monthOflicense == 3 ||
          monthOflicense == 5 ||
          monthOflicense == 7 ||
          monthOflicense == 8 ||
          monthOflicense == 10 ||
          monthOflicense == 12
        ) {
          System.out.print("\nDay of Birth (1-31) ==> ");
          dayOflicense = scn.nextInt();
          if (dayOflicense > 0 && dayOflicense < 32) {
            licensedIssuedDate.of(yearOflicense, monthOflicense, dayOflicense);
            isCorrect = true;
          } else {
            System.out.println("\nPlease try again");
          }
        } else {
          System.out.print("\nDay of Birth (1-30) ==> ");
          dayOflicense = scn.nextInt();
          if (dayOflicense > 0 && dayOflicense < 31) {
            licensedIssuedDate.of(yearOflicense, monthOflicense, 1);
            isCorrect = true;
          } else {
            System.out.println("\nPlease try again");
          }
        }
      }
    } while (!isCorrect);
  }

  
//  Setters and getters methods
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getLicenseNumber() {
    return licenseNumber;
  }

  public void setLicenseNumber(String licenseNumber) {
    this.licenseNumber = licenseNumber;
  }

  public LocalDate getLicensedIssuedDate() {
    return licensedIssuedDate;
  }

  public void setLicensedIssuedDate(LocalDate licensedIssuedDate) {
    this.licensedIssuedDate = licensedIssuedDate;
  }
//end of Setters and getters methods

//  To string method for display
  @Override
  public String toString() {
    return "Full name: " + firstName + " " + lastName;
  }
}
