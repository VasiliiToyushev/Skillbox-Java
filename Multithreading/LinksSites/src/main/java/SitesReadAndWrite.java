import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.RecursiveAction;

public class SitesReadAndWrite extends RecursiveAction {

    private String url;
    private static Set<String> links = new TreeSet<>();
    private StringBuilder stringBuilder = new StringBuilder();
    public SitesReadAndWrite(String url){
        this.url = url.trim();
    }

    public static Set<String> getLinks() {
        return links;
    }

    @Override
    protected void compute() {
        List<SitesReadAndWrite> taskList = new ArrayList<>();
        try {
            Thread.sleep(100);
            Document doc = Jsoup.connect(url).ignoreContentType(true).userAgent("Mozilla").get();
            for (Element el : doc.select("a")){
                String atr = el.absUrl("href");
                if (atr.startsWith(url) && !links.contains(atr) && !atr.contains("#")){
                    SitesReadAndWrite task = new SitesReadAndWrite(atr);
                    task.fork();
                    taskList.add(task);
                    links.add(atr);
                }
            }
            for (SitesReadAndWrite task : taskList)task.join();
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public String addTab(Set<String> set) {
        String tab = "\t";
        for (String link : set) {
            String[] mas = link.split("/");
            if (mas.length > 3)stringBuilder.append((tab.repeat(mas.length-3)) + link + "\n");
            else stringBuilder.append(link + "\n");
        }
        return stringBuilder.toString();
    }
    public void writer(String srt) {
        String path = "src/main/resources/" + url.replaceAll("https://", " ") + ".txt";
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(path));
            writer.write(srt);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
