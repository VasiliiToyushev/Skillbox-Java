package src;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WriteCSV {
    public static void write(String text) {
        List<Map<String, String>> list = new ArrayList<>();
        String[] mas = text.split("\n");
        for (String s : mas){
            String[] mas1 = s.split(",");
            Map<String,String>map2 = new TreeMap<>();
            for (String s1 : mas1){
                Map<String,String>map = new TreeMap<>();
                Map<String,String>map1 = new TreeMap<>();
                if (Character.isDigit(s1.charAt(0))){
                    map1.put("data", s1);
                }else {
                    map.put("name", s1);
                }
                map2.putAll(map);
                map2.putAll(map1);
            }
            list.add(map2);
        }
        list.remove(0);
        String path = "DataCollector/jsonCSV.json";
        JSONObject json = new JSONObject();
        try {
            json.put("station", list);
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
}
