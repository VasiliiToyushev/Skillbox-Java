package practice;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome = LocalDate.now();
    private LocalDate putData;

    @Override
    protected void put(double amountToPut) {
        putData = lastIncome;
        super.put(amountToPut);
    }

    @Override
    protected void take(double amountToTake) {
        if (putData.isBefore(lastIncome.plusMonths(1))) {
            getAmount();
        } else {
            super.take(amountToTake);
        }
    }
}



