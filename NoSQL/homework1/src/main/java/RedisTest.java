public class RedisTest {
    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();

        for (int i = 1; i <= 20; i++) {
            redis.logPageVisit(i);
        }
        redis.site();
    }
}
