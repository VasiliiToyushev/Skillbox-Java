import java.io.File;
public class Main {
    private static final int newWidth = 300;
    public static void main(String[] args) {
        String srcFolder = "E:\\Image\\UHDWalls";
        String dstFolder = "E:\\Image\\Walls2";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int middle = files.length / 8;

       File[] files1 = new File[middle];
       System.arraycopy(files, 0, files1, 0, files1.length);
       ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
       resizer1.start();

       File[] files2 = new File[middle];
       System.arraycopy(files, files.length - middle, files2, 0, files2.length);
       ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
       resizer2.start();

       File[] files3 = new File[middle];
       System.arraycopy(files, files.length - (middle * 2), files3, 0, files3.length);
       ImageResizer resizer3 = new ImageResizer(files3, newWidth, dstFolder, start);
       resizer3.start();

        File[] files4 = new File[middle];
        System.arraycopy(files, files.length - (middle * 3), files4, 0, files4.length);
        ImageResizer resizer4 = new ImageResizer(files4, newWidth, dstFolder, start);
        resizer4.start();

        File[] files5 = new File[middle];
        System.arraycopy(files, files.length - (middle * 4), files5, 0, files5.length);
        ImageResizer resizer5 = new ImageResizer(files5, newWidth, dstFolder, start);
        resizer5.start();

        File[] files6 = new File[middle];
        System.arraycopy(files, files.length - (middle * 5), files6, 0, files6.length);
        ImageResizer resizer6 = new ImageResizer(files6, newWidth, dstFolder, start);
        resizer6.start();

        File[] files7 = new File[middle];
        System.arraycopy(files, files.length - (middle * 6), files7, 0, files7.length);
        ImageResizer resizer7 = new ImageResizer(files7, newWidth, dstFolder, start);
        resizer7.start();

        File[] files8 = new File[middle];
        System.arraycopy(files, files.length - (middle * 7), files8, 0, files8.length);
        ImageResizer resizer8 = new ImageResizer(files8, newWidth, dstFolder, start);
        resizer8.start();
    }
}
