package Peak_Test.Services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataSource {
    public List<String> read(String name) throws IOException {
        List<String> list = new ArrayList<String>();
        String fs = File.separator;
        String dir = System.getProperty("user.dir") + fs + "data";
        String filename = dir + fs + name;
        File fileDir = new File(dir);
        fileDir.mkdirs();
        File file = new File(filename);
        file.createNewFile();

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        reader.close();
        return list;
    }
}
