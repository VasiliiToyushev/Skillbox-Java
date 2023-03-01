package practice;

public class BankAccount {
  protected double amountMoney = 0.0;

  protected double getAmount() {
    return amountMoney;
  }

  protected void put(double amountToPut) {
    if (amountToPut > 0) {
      amountMoney += amountToPut;
    }
  }

  protected void take(double amountToTake) {
    if (amountToTake <= getAmount()) {
      amountMoney -= amountToTake;
    }
  }
}
