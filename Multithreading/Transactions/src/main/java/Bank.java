import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();
    private Map<String, Account> blackList = new HashMap<>();

    public void addAccount() {
        for (int i = 0; i < 10; i++) {
            accounts.put("" + i,
                    new Account("" + random.nextLong(100_000, 999_999),
                            random.nextLong(10_000, 100_000)));
        }
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public boolean checkBlackList(String fromAccountNum, String toAccountNum) {
        for (Map.Entry<String, Account> entry : blackList.entrySet()) {
            if (accounts.get(fromAccountNum).getAccNumber()
                    .equals(entry.getValue().getAccNumber()) ||
                    accounts.get(toAccountNum).getAccNumber()
                            .equals(entry.getValue().getAccNumber())) {
                System.out.println("----" + entry.getValue().getAccNumber() +
                        " Номер заблокирован операция невозможна\n");
                return true;
            }
        }
        return false;
    }

    public void addBlackList(String numAccount, Account account) {
        blackList.put(numAccount, account);
        System.out.print("Абонент с номером " + blackList.get(numAccount).getAccNumber() +
                " не прошел проверку безопасности \nНомер заблокирован ");
        System.out.println(" Сумма на счете: " +
                blackList.get(numAccount).getMoney() + "руб. заморожена\n");
    }

    public boolean checkMaxLimit(String fromAccountNum, String toAccountNum, long amount) {
        boolean block = false;
        if (amount > 50000) {
            try {
                boolean fraud = isFraud(fromAccountNum, toAccountNum, amount);
                System.out.println("Операция больше 50_000 тысяч " +
                        "Проверка безопастности" + (fraud ? " не пройдена" : " пройдена"));
                if (fraud == true) {
                    addBlackList(fromAccountNum, accounts.get(fromAccountNum));
                    addBlackList(toAccountNum, accounts.get(toAccountNum));
                    block = true;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return block;
    }

    public boolean smallAmount(String fromAccountNum, long amount){
        if (accounts.get(fromAccountNum).getMoney() < amount) {
            System.out.println("Недостаточно средств для выполнения операции\n");
            return true;
        }
        return false;
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        synchronized (this){
        if (checkBlackList(fromAccountNum, toAccountNum) == false) {
                if (!fromAccountNum.equals(toAccountNum)) {
                    if (smallAmount(fromAccountNum, amount) == false) {
                        if (checkMaxLimit(fromAccountNum, toAccountNum, amount) == false) {

                            accounts.get(fromAccountNum).setMoney(
                                    accounts.get(fromAccountNum).getMoney() - amount);
                            System.out.println("Денги отправлены абоненту с номером " +
                                    accounts.get(toAccountNum).getAccNumber());
                            getBalance(fromAccountNum);
                            accounts.get(toAccountNum).setMoney(
                                    accounts.get(toAccountNum).getMoney() + amount);
                            System.out.println("Получена сумма " + amount + "руб. от абонента " +
                                    accounts.get(fromAccountNum).getAccNumber());
                            getBalance(toAccountNum);
                        }
                    }
                }else {
                    System.out.println("Операция невозможна вы набрали ваш номер счета\n ");
                }
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        System.out.println("Ваш баланс: " + accounts.get(accountNum).getMoney() + " руб.\n");
        return getAccounts().get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sum = 0;
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            String k = entry.getKey();
            Account v = entry.getValue();
            sum += v.getMoney();
        }
        System.out.println("Общая сумма в банке : " + sum);
        return sum;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
}

