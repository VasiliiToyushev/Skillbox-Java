package src;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import src.core.Line;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class HTMLparse {
    String html = parseFile("DataCollector/metro.html");
    Document doc = Jsoup.parse(html);
    List<String> numStation = new ArrayList<>();
    List<Line> lines1 = new ArrayList<>();
    List<Map<String, String>> listLines = new ArrayList<>();


    public  String parseFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line).append("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder.toString();
    }


    public  void writer() {
        List<List<Object>> connections = new ArrayList<>(connectionsParse());

        String path = "DataCollector/map.json";
        JSONObject json = new JSONObject();
        try {
            json.put("station", parseStation());
            json.put("connections", connections);
            json.put("lines", listLines);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString = gson.toJson(json);
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  Map<Line, List<String>> parseStation() {
        var elements = doc.select("p");
//        System.out.println(elements);
        var station = elements.stream().map(Element::text).collect(Collectors.toList());
        var station123 = elements.stream().map(Element::text)
                .collect(Collectors.toList()).toString();
        Map<Line, List<String>> map1Super = new TreeMap<>();


        String[] masStation = station123.split(" 1. ");
        int i1 = -1;
        int sum1 = 0;
        int sum2 = 0;
        for (String s : masStation){
            i1++;
            String[] mass = s.split(",");
            int sum = mass.length;
            sum1 = sum1 + sum;
            sum2 = sum1 - sum;
            List<String> z = new ArrayList<>();
            for (int i = sum2; i < sum1 ; i++) {
                z.add(""+station.get(i));
            }
            map1Super.put(lines1.get(i1), z);
        }
        return map1Super;
    }


    public  void parseLine() {
        var el = doc.select("span.t-icon-metroln");
        var lines = el.eachText();
        var str = el.unwrap().toString();

        String[] mas = str.split("\n");
        for (String s : mas){
            int start = s.indexOf("ne=\"");
            int end = s.lastIndexOf("\"></sp");
            if (start == -1)continue;
            String sub = s.substring(start+4, end);
            numStation.add(sub);
        }

        for (int i = 0; i < lines.size(); i++) {
            Map<String,String> map = new HashMap<>();
            Map<String,String> map1 = new HashMap<>();
            Map<String,String> map2 = new TreeMap<>(Comparator.reverseOrder());
            lines1.add(new Line(i ,numStation.get(i) + "." + lines.get(i)));
            map.put("number", numStation.get(i));
            map1.put("name", lines.get(i));

            map2.putAll(map);
            map2.putAll(map1);

            listLines.add(map2);
        }
    }

    public List<List<Object>> connectionsParse() {
        var elements = doc.select("p");

        var station123 = elements.stream().map(element-> element.text())
                .collect(Collectors.toList()).toString();

        var str = elements.toString();

        parseLine();


        List<List<Object>> ALL = new ArrayList<>();

        List<String> list = new ArrayList<>();
        String[] mas = str.split("\n");
        for (String m : mas)list.add(m);

        String[] masStation = station123.split(" 1. ");
        int i1 = -1;
        int sum1 = 0;
        int sum2;
        for (String s : masStation){
            i1++;
            String[] mass = s.split(",");
            int sum = mass.length;
            sum1 = sum1 + sum;
            sum2 = sum1 - sum;

            for (int i = sum2; i < sum1 ; i++) {

                List<Object> connections;

                Map<String, String> map = new TreeMap<>();
                Map<String, String> mapLine = new HashMap<>();
                Map<String, String> mapStation = new LinkedHashMap<>();


                int start = list.get(i).indexOf("name");
                int end = list.get(i).lastIndexOf("переход");

                if (end == -1)continue;

                var sub = list.get(i).substring(start+6, end);

                int end3 = sub.indexOf("</span>");

                var sub3 = sub.substring(0, end3);

                mapStation.put("station", sub3);
                mapLine.put("line", numStation.get(i1));

                map.putAll(mapLine);
                map.putAll(mapStation);

                String[] mass1 = list.get(i).split("ln");

                for (String s1 : mass1){
                    Map<String,String> map1L = new HashMap<>();
                    Map<String,String> map1S = new HashMap<>();
                    Map<String, String> mapLS = new TreeMap<>();

                    int end1LL = s1.indexOf("\" title=");
                    int start1LL = s1.indexOf("«");
                    int end2L = s1.indexOf("»");
                    if (end2L == -1)continue;

                    String sub1L = s1.substring(start1LL+1, end2L);
                    String sub2L = s1.substring(1, end1LL);

                    map1S.put("station", sub1L);
                    map1L.put("line", sub2L);

                    mapLS.putAll(map1S);
                    mapLS.putAll(map1L);

                    connections = List.of(map, mapLS);
                    ALL.add(connections);
                }
            }
        }
        return ALL;
    }
}
