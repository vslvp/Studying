import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        File folder = new File(sourceDirectory);
        File[] listOfFiles = folder.listFiles();
        Path dest = Paths.get(destinationDirectory);
        if (listOfFiles != null){
            for (File file : listOfFiles){
                Files.copy(file.toPath(), dest.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
            }
        }
        // TODO: write code copy content of sourceDirectory to destinationDirectory
    }
}
