package chatToVid;

import org.xhtmlrenderer.swing.Java2DRenderer;
import org.xhtmlrenderer.util.FSImageWriter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XhtmlToImage {

    static Map<String, Integer> images = new HashMap<>();
    private String imagePath = null;
    private int duration = 1;

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public Map<String, Integer> getImages() {
        return images;
    }

    public void convertAndSave(String url, int count) throws IOException {

        imagePath = String.format("%s/images/chat%04d.png", Main.videoOutput, count);

        System.out.println("Start save");
        int width = 1280;
        int height = 720;
        File file = new File(url);
        Java2DRenderer renderer = new Java2DRenderer(file, width, height);
        BufferedImage bufferedImage = renderer.getImage();
        FSImageWriter imageWriter = new FSImageWriter();
        imageWriter.write(bufferedImage, imagePath);
        System.out.println("Saved");

        images.put(imagePath, duration);

    }

}