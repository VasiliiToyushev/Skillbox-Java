import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
//        String url = "https://lenta.ru";
        String url = "https://skillbox.ru";
        SitesReadAndWrite readeAndWrite = new SitesReadAndWrite(url);

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(readeAndWrite);

        String str = readeAndWrite.addTab(SitesReadAndWrite.getLinks());

        System.out.println(str);
        System.out.println(SitesReadAndWrite.getLinks().size());

        readeAndWrite.writer(str);
    }
}
