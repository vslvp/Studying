package main.java;
import java.io.File;

public class Main {
    private static final String srcFolder = "resources/src";
    private static final String dstFolder = "resources/dst";
    private static final int newWidth = 300;


    public static void main(String[] args) {
        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int quater = files.length / 4;
        int middle = files.length / 2;
        File[] files1 = new File[quater];
        System.arraycopy(files, 0, files1, 0, quater);
        ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
        new Thread(resizer1).start();
        File[] files2 = new File[quater];
        System.arraycopy(files, quater, files2, quater, middle);
        ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
        new Thread(resizer2).start();
        File[] files3 = new File[quater];
        System.arraycopy(files, middle, files3, middle, files.length - quater);
        ImageResizer resizer3 = new ImageResizer(files3, newWidth, dstFolder, start);
        new Thread(resizer3).start();
        File[] files4 = new File[quater];
        System.arraycopy(files, files.length - quater, files4, files.length - quater, files.length);
        ImageResizer resizer4 = new ImageResizer(files4, newWidth, dstFolder, start);
        new Thread(resizer4).start();
    }
}

