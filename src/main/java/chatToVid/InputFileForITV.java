package chatToVid;

import java.io.*;
import java.util.Map;

public class InputFileForITV {

    File input;
    FileWriter fw;
    Map<String, Integer> images;


    public InputFileForITV(Map<String, Integer> mapFromXhtmlToImg) {
        this.images = mapFromXhtmlToImg;
        input = new File(Main.videoOutput + "/images/input.txt");
        try {
            fw = new FileWriter(input, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeFile() {

        for (Map.Entry<String, Integer> entry : images.entrySet()){
            try {
                fw.write("file '" + entry.getKey() + "'\n"+ "duration " + entry.getValue().toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
