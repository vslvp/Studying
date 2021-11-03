import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String link = "https://www.moscowmap.ru/metro.html#lines";
    private static List<String> stationsArray = new ArrayList<>();
    public static void main(String[] args) {
        html(link);
        JSONObject object = new JSONObject();
        object.put("Сокольническая линия", stationsArray);
        try {
            FileWriter fileWriter = new FileWriter("data/map.json");
            fileWriter.write(object.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void html(String link){
        try {
            Document doc = Jsoup.connect(link).maxBodySize(0).get();
            Elements stations = doc.getElementsByClass("js-metro-stations t-metrostation-list-table");
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(new File("data/map")));
            out.write(stations.text());
            out.close();
            List<String> file = Files.readAllLines(Paths.get("data/map"));
            for (int i = 0; i < 37; i++){
                String[] lines = file.get(0).split("[0-9]+");
                stationsArray.add(lines[i]);
            }
            System.out.println(stationsArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

