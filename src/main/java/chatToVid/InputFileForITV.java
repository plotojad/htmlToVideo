package chatToVid;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InputFileForITV {

    File input;
    FileWriter fw;
    Map<String, Integer> images;
    Map<String, Integer> imagesShiftValues;


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
        imagesShiftValues = new LinkedHashMap<>();

        List<Integer> durations = new ArrayList<> (images.values());
        for (int i = 0; i < durations.size() - 1; i++) {
            durations.set(i, durations.get(i + 1));
        }
        durations.set(durations.size() - 1, 1);

        int count = 0;
        for (Map.Entry<String, Integer> shentry : images.entrySet()) {
            imagesShiftValues.put(shentry.getKey(), durations.get(count));
            count++;
        }


        for (Map.Entry<String, Integer> entry : imagesShiftValues.entrySet()) {
            try {
                fw.write("file \'" + entry.getKey() + "\'\n" + "duration " + entry.getValue().toString() + "\n");
//                System.out.println(entry.getKey() + " : " + entry.getValue());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
