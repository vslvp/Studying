import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        Path folder = Paths.get(path);
        Long length = Long.valueOf(0);
        try {
            length = Files.walk(folder)
                    .map(Path :: toFile)
                    .filter(File::isFile)
                    .mapToLong(File ::length)
                    .sum();
        }catch (IOException e){
            e.printStackTrace();
        }
        return length;
    }
}
