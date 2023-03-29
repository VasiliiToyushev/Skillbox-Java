package src;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFile {


    private final List<File> listFile = new ArrayList<>();

    public void search(File file){
        File[] file1 = file.listFiles();
        if (file1 != null) {
            for (File s : file1){
                if (s.isDirectory()) search(s);
                else listFile.add(s);
            }
        }
    }

    public List<File> getListFile() {
        return listFile;
    }
}
