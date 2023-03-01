package practice;

public class CardAccount extends BankAccount {

    @Override
    protected void take(double amountToTake) {
        double commission = amountToTake * 0.01;
        if (amountToTake <= amountMoney) {
            super.amountMoney = super.amountMoney - amountToTake - commission;
        }
    }
    // не забывайте, обращаться к методам и конструкторам родителя
    // необходимо используя super, например, super.put(10D);
}
