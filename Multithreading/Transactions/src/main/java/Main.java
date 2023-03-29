import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Thread> threadList = new ArrayList<>();
        Bank bank = new Bank();
        Random random = new Random();

        bank.addAccount();

        bank.getAccounts().forEach((s, account) ->
                System.out.println(s +"  "+ account.getAccNumber() +" "+ account.getMoney() +" руб."));

        bank.getSumAllAccounts();

        for (int i = 0; i < 5; i++) {
            threadList.add(new Thread(() -> {
                for (int j = 0; j < 10 ; j++) {
                    long amountRandom = random.nextLong(1_000, 60_000);
                    String random1 = String.valueOf(random.nextInt(0, 10));
                    String random2 = String.valueOf(random.nextInt(0, 10));
                    bank.transfer(random1, random2,amountRandom);
                }
            }));
        }

        threadList.forEach(Thread::start);

        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        bank.getSumAllAccounts();
    }
}
