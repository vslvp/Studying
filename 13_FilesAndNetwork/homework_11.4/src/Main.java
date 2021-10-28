import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String link = "http://lenta.ru";
        String path = "data/images";
        html(link);
        System.out.println(parse(path));

    }
    public static List<String> parse(String path){
        List<String> src = new ArrayList<>();
        try {
            src = Files.readAllLines(Paths.get(path));
        }catch (Exception e){
            e.printStackTrace();
        }
        return src;
    }
    public static void html(String link){
        try {
            Document doc = Jsoup.connect(link).get();
            Elements jpgs = doc.select("img[src$=.jpg]");
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(new File("data/images")));
            out.write(jpgs.attr("abs:src"));
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
