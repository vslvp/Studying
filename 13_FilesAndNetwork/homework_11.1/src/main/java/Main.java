import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            File folder = new File(path);
            File[] files = folder.listFiles();
            for (File file : files) {
                System.out.println(file);
            }
            System.out.println(path + " " + "Size is" + " " + FileUtils.calculateFolderSize(path) + " " + "bytes");

        }
    }
}
