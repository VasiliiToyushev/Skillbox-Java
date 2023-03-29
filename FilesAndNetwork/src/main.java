package src;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;


public class main {

    public static void main(String[] args) {
        HTMLparse htmLparse = new HTMLparse();
        SearchFile searchFile = new SearchFile();

        File file = new File("DataCollector/data");
        searchFile.search(file);

        String file1csv = htmLparse.parseFile(String.valueOf(searchFile.getListFile().get(1)));
        String file2csv = htmLparse.parseFile(String.valueOf(searchFile.getListFile().get(3)));
        String file3csv = htmLparse.parseFile(String.valueOf(searchFile.getListFile().get(6)));

        Document documentCSV = Jsoup.parse(file3csv);

        String text = documentCSV.wholeText();
        System.out.println(text);

        WriteCSV.write(text);

        System.out.println();

        String file1json = String.valueOf(searchFile.getListFile().get(2));
        String file2json = String.valueOf(searchFile.getListFile().get(4));
        String file3json = String.valueOf(searchFile.getListFile().get(5));

       ReadJson.read(file3json);


        htmLparse.writer();
    }
}
