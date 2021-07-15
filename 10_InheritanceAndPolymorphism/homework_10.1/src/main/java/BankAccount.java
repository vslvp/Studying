public class BankAccount {

  private double money;

  public double getAmount() {
    return money;
  }

  public void put(double amountToPut) {
    if (amountToPut < 0.0){
      money = money;
    }
    else{
      money += amountToPut;
    }
  }

  public void take(double amountToTake) {
    if (amountToTake > money) {
      money = money;
    }
    else {
      money -= amountToTake;
    }
  }
}
