
import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Random;

import static java.lang.System.out;

public class RedisStorage {

    // Объект для работы с Redis
    private RedissonClient redisson;

    // Объект для работы с ключами
    private RKeys rKeys;

    // Объект для работы с Sorted Set'ом
    private RScoredSortedSet<String> onlineUsers;

    private final static String KEY = "ONLINE_USERS";

    public double getTs() {
        return (double) System.currentTimeMillis() / 1000;
    }


    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        onlineUsers = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void shutdown() {
        redisson.shutdown();
    }

    void logPageVisit(int user_id) {
        //ZADD ONLINE_USERS
        onlineUsers.add(getTs(), String.valueOf(user_id));
    }

    public void site() throws InterruptedException {
        int i = 0;
        for (i = 0; i < 20; i++) {
            out.println("- На главной странице показываем пользователя " + onlineUsers.first());
            var first = onlineUsers.first();
            onlineUsers.pollFirst();
            onlineUsers.add(getTs(), first);
        }
        out.println();
        for (;;) {
            i++;
            out.println("-- На главной странице показываем пользователя " + onlineUsers.first());
            var first = onlineUsers.first();
            onlineUsers.pollFirst();
            onlineUsers.add(getTs(), first);

            if (i % 10 == 0) {
                int random = new Random().nextInt(21);
                for (String x : onlineUsers) {
                    if (String.valueOf(random).equals(x)) {
                        out.println("> Пользователь " + x + " оплатил платную услугу");
                        Thread.sleep(1000);
                    }
                }
                out.println();
            }
        }
    }
}
