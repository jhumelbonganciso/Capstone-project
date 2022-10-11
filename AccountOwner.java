/**
 * Java Course 4, Module 3
 * 
 * Java Certification Project
   *
 * @author Jhumel Bonganciso
 */

import java.util.Scanner;

public class AccountOwner {

  Scanner scn = new Scanner(System.in);
  
//  Instance variables
  private String firstName;
  private String lastName;
  private String address;
  
//  Empty constructor
  AccountOwner() {}

//  Setters and getters
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
  
//  End of setters and getters

  
//  Load method as prompt to have the details of the accountOwner
  public AccountOwner load() {
    System.out.print("Please enter customer first name ==> ");
    setFirstName(scn.nextLine());

    System.out.print("Please enter customer last name ==> ");
    setLastName(scn.nextLine());

    System.out.print("Please enter customer address ==> ");
    setAddress(scn.nextLine());
    return this;
  }
  
//  ToString method for display
  @Override
  public String toString() {
    return "Account owner\n" + firstName + "\t" + lastName;
  }
}
