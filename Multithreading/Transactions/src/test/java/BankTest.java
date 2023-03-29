import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankTest extends TestCase {
    Bank bank = new Bank();
    long first;
    long last;
    @Override
    protected void setUp() throws Exception {
        List<Thread> threadList = new ArrayList<>();

        Random random = new Random();

        Account account1 = new Account("1", 20_000);
        Account account2 = new Account("2", 30_000);

        bank.addAccount();

        first = bank.getSumAllAccounts();

        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(() -> {
                for (int j = 0; j < 5 ; j++) {
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

        last = bank.getSumAllAccounts();

        bank.getAccounts().clear();

        bank.getAccounts().put("1", account1);
        bank.getAccounts().put("2", account2);
        bank.transfer("1", "2", 5000);

        super.setUp();
    }

    public void testGetSumAllAccounts () {
        long actual = first;
        long expected = last;
        assertEquals(expected, actual);
    }

    public void testGetBalance() {
        long actual = bank.getBalance("1");
        long expected = 15_000;
        assertEquals(expected, actual);
    }
    public void testTransfer() {
        bank.transfer("2", "1", 10_000);
        long actual = bank.getBalance("2");
        long expected = 25_000;
        assertEquals(expected, actual);
    }
        @Override
        protected void tearDown() throws Exception {
            super.tearDown();
        }

    }

