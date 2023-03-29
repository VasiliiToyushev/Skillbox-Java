package src;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class ReadJson {
    public static void read(String fileJson) {
        JSONParser parser = new JSONParser();
        JSONArray a;
        try {
            a = (JSONArray) parser.parse(new FileReader(fileJson));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (Object o : a) {
            JSONObject person = (JSONObject) o;

            String name = (String) person.get("station_name");
            System.out.println("station_name: " + name);

            String depth = (String) person.get("depth");
            System.out.println("depth: " + depth);
        }
    }
}
