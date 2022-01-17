package main.java;
import java.io.File;

public class Main {
    private static final String srcFolder = "C:\\Skillbox\\java_basics\\Studying\\15_Multithreading\\ImageResizer" +
            "\\src\\main\\resources\\src";
    private static final String dstFolder = "resources/dst";
    private static final int newWidth = 300;


    public static void main(String[] args) {
        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int quarter = files.length / 4;
        int middle = files.length / 2;
        File[] files1 = new File[quarter];
        System.arraycopy(files, 0, files1, 0, quarter);
        ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
        new Thread(resizer1).start();
        File[] files2 = new File[quarter];
        System.arraycopy(files, quarter, files2, quarter, middle);
        ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
        new Thread(resizer2).start();
        File[] files3 = new File[quarter];
        System.arraycopy(files, middle, files3, middle, files.length - quarter);
        ImageResizer resizer3 = new ImageResizer(files3, newWidth, dstFolder, start);
        new Thread(resizer3).start();
        File[] files4 = new File[quarter];
        System.arraycopy(files, files.length - quarter, files4, files.length - quarter, files.length);
        ImageResizer resizer4 = new ImageResizer(files4, newWidth, dstFolder, start);
        new Thread(resizer4).start();
    }
}

