import java.time.LocalDate;
import java.util.ArrayList;

public class RatingEngine {

  private LocalDate localDateNow = LocalDate.now();
  PolHolder polHolder;
  private int dlx;
  private double premiumToPay;

  RatingEngine(ArrayList<Vehicle> vehicles, PolHolder polHolder) {
    this.polHolder = polHolder;
    setDlx(polHolder);

    for (Vehicle vehicle : vehicles) {
      double vpf = vehiclePriceFactor(vehicle);
      setPremiumToPay(
        premiumCalculation(vehicle.getPurchasePrice(), vpf, getDlx())
      );
    }
  }

  public double vehiclePriceFactor(Vehicle vehicle) {
    double vehicleAge = localDateNow.getYear() - vehicle.getYearModel();

    double vpf = 0;
    if (vehicleAge == 0) {
      vehicleAge = 0.9;
    }

    if (vehicleAge < 1) {
      vpf = 0.01;
    } else if (vehicleAge < 3) {
      vpf = 0.008;
    } else if (vehicleAge < 5) {
      vpf = 0.007;
    } else if (vehicleAge < 10) {
      vpf = 0.006;
    } else if (vehicleAge < 15) {
      vpf = 0.004;
    } else if (vehicleAge < 20) {
      vpf = 0.002;
    } else if (vehicleAge < 40) {
      vpf = 0.001;
    }

    return vpf;
  }

  public void setDlx(PolHolder polHolder) {
    dlx =
      (localDateNow.getYear() + 1) -
      polHolder.getLicensedIssuedDate().getYear();
  }

  public int getDlx() {
    return dlx;
  }

  public void setPremiumToPay(double premiumToPay) {
    this.premiumToPay += premiumToPay;
  }

  public double getPremiumToPay() {
    return premiumToPay;
  }

  public double premiumCalculation(
    double vehiclePurchasePrice,
    double vpf,
    int dlx
  ) {
    double premium =
      (vehiclePurchasePrice * vpf) + ((vehiclePurchasePrice / 100) / dlx);
    return premium;
  }
}
