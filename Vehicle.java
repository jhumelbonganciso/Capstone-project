import java.util.Iterator;
import java.util.Scanner;

public class Vehicle {

  private String make;
  private String model;
  private int yearModel;
  private String carType;
  private String fuelType;
  private double purchasePrice;
  private String plateNumber;
  private String color;
  private long premiumCharged;
  private String[] carTypeArray = {
    "4-door sedan",
    "2-door sedan",
    "SUV",
    "Truck",
  };
  private String[] fuelTypeArray = { "Diesel", "Electric", "Petrol" };
  Scanner s = new Scanner(System.in);

  Vehicle() {
    load();
  }

  public void load() {
    setPlateNumber();
    System.out.print("\nCar maker ==> ");
    setMake(s.nextLine());
    setColor();
    System.out.print("\nCar model ==> ");
    setModel(s.nextLine());
   
    System.out.print("\nCar year model ==> ");
    setYearModel(s.nextInt());
    setCarType(getCarTypeArray());
    setFuelType(getFuelTypeArray());
    
    setPurchasePrice();
  }

  public void setPlateNumber() {
    String pNumber;
    System.out.print("\nPlate number ==> ");
    pNumber = s.nextLine();
    plateNumber = pNumber;
  }

  public String getPlateNumber() {
    return plateNumber;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYearModel() {
    return yearModel;
  }

  public void setYearModel(int yearModel) {
    this.yearModel = yearModel;
  }

  public String getCarType() {
    return carType;
  }

  public void setCarType(String[] carTypeArray) {
    System.out.println("\nCar Type:");
    for (int i = 0; i < carTypeArray.length; i++) {
      System.out.println(i + " " + carTypeArray[i]);
    }

    int choice = carTypeArray.length;

    while (choice >= carTypeArray.length) {
      System.out.print("Choice ==> ");
      choice = s.nextInt();
      if (choice < carTypeArray.length) {
        carTypeArray[choice] = carType;
      } else {
        System.out.println(
          "You should only pick from 0 - " + carTypeArray.length
        );
      }
    }
  }

  public String getFuelType() {
    return fuelType;
  }

  public void setFuelType(String[] fuelTypeArray) {
    System.out.println("\nFuel Type:");
    for (int i = 0; i < fuelTypeArray.length; i++) {
      System.out.println(i + " " + fuelTypeArray[i]);
    }

    int choice = fuelTypeArray.length;

    while (choice >= fuelTypeArray.length) {
      System.out.print("Choice ==> ");
      choice = s.nextInt();
      if (choice < fuelTypeArray.length) {
        fuelTypeArray[choice] = fuelType;
      } else {
        System.out.println(
          "You should only pick from 0 - " + fuelTypeArray.length
        );
      }
    }
  }

  public double getPurchasePrice() {
    return purchasePrice;
  }

  public void setPurchasePrice() {
    double amount = 0;
   while(amount == 0) {
    System.out.print("\nPurchase Price of Vehicle ==> ");
    amount = s.nextDouble();
    if (amount > 0) {
      purchasePrice = amount;
    }
   }
  }

  public String getColor() {
    return color;
  }

  public void setColor() {
    String carColor;
    System.out.print("\nColor ==> ");
    carColor = s.nextLine();
    color = carColor;
  }

  public long getPremiumCharged() {
    return premiumCharged;
  }

  public void setPremiumCharged(long premiumCharged) {
    this.premiumCharged = premiumCharged;
  }

  public String[] getCarTypeArray() {
    return carTypeArray;
  }

  public void setCarTypeArray(String[] carTypeArray) {
    this.carTypeArray = carTypeArray;
  }

  public String[] getFuelTypeArray() {
    return fuelTypeArray;
  }

  public void setFuelTypeArray(String[] fuelTypeArray) {
    this.fuelTypeArray = fuelTypeArray;
  }

  @Override
  public String toString() {
    return (
      make + "\t" + model + "\t" + yearModel + "\t" + color + "\t" + plateNumber
    );
  }
}
